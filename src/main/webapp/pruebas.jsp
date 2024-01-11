<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.AgenciaViajes,modelo.*" %>
<!DOCTYPE html>
<html>
    <head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Cards</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>
    <body id="page-top">
        <%
            HttpSession ses=request.getSession();
            if(ses.getAttribute("cliente")==null){
                response.sendRedirect("login.jsp");
            }
            Clientes cli=(Clientes)ses.getAttribute("cliente");
            AgenciaViajes obj=new AgenciaViajes();
            String nom="Bienvenido "+cli.getId_cli()+": "+cli.getApe_cli()+", "+cli.getNom_clie();
        %>
        <input type="hidden" value="<%=cli.getId_cli()%>" name="idc">
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-warning sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
                <div class="sidebar-brand-icon">
                 <img src="assets/LOGO.png" style="width: 60px; height: 60px;">
                </div>
                <div class="sidebar-brand-text">Turismo San Ramón</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Volver a la web</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <h1><%=nom%></h1>
                    
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">

                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            
                        </li>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Seleccione su Tour</h1>
                        <a class="h3 mb-2 text-gray-800" href="controlServicio?opc=6&id=<%=cli.getId_cli()%>">Mis Tours</a>
                    </div>

                    <div class="column">

                        <!-- Tour 1 -->
                        <div class="col-xl-12 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="column no-gutters align-items-center">
                                        <div class="col mr-2">
                                            
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">
                                                <table border="0" class="table table-unbordered" id="dataTable" width="100%" cellspacing="0">
                                                    <tr style="font-size: 25px"><th>Id de Tour<th>Descripcion<th>Destino<th>Guia<th>Tarifa<th>Fecha de Inicio<th>Fecha de Finalización<th>Seleccionar
                        <%
                            for(Tours x:obj.lisResTours()){
                                out.print("<tr><td>"+x.getTour_id()+"<td>"+x.getDescrip_tour()+"<td>"+x.getDestino()+"<td>"+x.getGuia()+"<td>"+x.getTarifa()+
                                        "<td>"+x.getFecha_inicio()+"<td>"+x.getFecha_fin()+"<td>");
                                %>
                                <a class="btn btn-circle btn-success" href="controlServicio?opc=5&id=<%=x.getTour_id()%>&idc=<%=cli.getId_cli()%>"></a>
                                <%
                            }
                        %>
                        </table>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>
                                           

                    <div class="column">

                        <div class="col-lg-6">

                        </div>

                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

</body>

</html>