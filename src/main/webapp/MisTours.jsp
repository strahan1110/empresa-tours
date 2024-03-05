<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.AgenciaViajes,modelo.*" %>
<!DOCTYPE html>
<html>
  <head>
      
    <style>
        /* Estilos para la advertencia */
        .advertencia {
            background-color: #ffe4e1; /* Color de fondo */
            border: 1px solid #ff0000; /* Borde */
            padding: 10px; /* Espaciado interno */
            text-align: center; /* Alineación del texto */
            color: #ff0000; /* Color del texto */
            font-weight: bold; /* Negrita */
        }
    </style>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Dashboard</title>

    <!-- Custom fonts for this template -->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

</head>

<body id="page-top">
  <%
    HttpSession ses = request.getSession();
    Tours cli = null; // Declarar la variable fuera del bloque if
    String nom = "";
    String idcli = "";
    AgenciaViajes obj = null;
    List<Tours> toursList = null; // Declarar la lista previamente como null

   // if (ses.getAttribute("cliente") == null) {
    //    response.sendRedirect("login.jsp");
  //  } else {
        cli = (Tours) ses.getAttribute("cliente");

        // Verificar si cli o cli.getId_cli() es null o vacío
        if (cli == null || cli.getId_cli() == null || cli.getId_cli().isEmpty()) {
        
        %>
            <div class="advertencia">
                <p></p>
                <p>No tienes tours guardados. ¡Agrega algunos y disfruta de nuestra oferta!</p>
            </div>
    <%
         //   out.println("<p>NO TIENES TOURS GUARDADOS");
         //   response.sendRedirect("login.jsp");
        } else {
            // Si se recibe la información necesaria, continuar con el procesamiento
            obj = new AgenciaViajes();
            nom = "Tours Separados Cliente: " + cli.getId_cli();
            idcli = cli.getId_cli();

            // Asignar la lista con los tours a la variable toursList
            toursList = obj.busTourxCli(cli.getId_cli());
            
        }
  //  }

%>


        <input type="hidden" value="<%=idcli%>" name="id">
        
    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-warning sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item">
                <a class="nav-link" href="login.jsp">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Salir</span></a>
            </li>

                      <!-- Nav Item - Tables -->
            <li class="nav-item active">
                <a class="nav-link" href="#">
                    <i class="fas fa-fw fa-table"></i>
                    <span>Tabla</span></a>
            </li>


        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <form class="form-inline">
                        
                        <h1><%=nom%></h1>
                            
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>
                    </form>

                   


                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">Lista de Tours</h1>
                    <p class="mb-4">Estos son los datos de los tours.<br>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">LISTADO</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                    <table border="1" class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
               <tr><th>Id de Tour<th>Descripcion<th>Destino<th>Guia<th>Tarifa<th>Fecha de Inicio<th>Fecha de Finalización<th>PDF
                        <%
    // Resto del código...

    // Verificar si toursList no es null antes de utilizarlo
    if (toursList != null) {
        for (Tours x : toursList) {
            out.print("<tr><td>" + x.getTour_id() + "<td>" + x.getDescrip_tour() + "<td>" + x.getDestino() +
                    "<td>" + x.getGuia() + "<td>" + x.getTarifa() + "<td>" + x.getFecha_inicio() +
                    "<td>" + x.getFecha_fin() + "<td>");
                    
                     %>
                      <a class="btn btn-arrow btn-success" href='controlServicio?opc=8&id=<%=x.getTour_id()%>&idc=<%=cli.getId_cli()%>'>Descargar PDF</a>
                                <%
                    
                    
        }
    } else {
        // Puedes manejar el caso en que toursList es null aquí
        out.print("<tr><td>" + "--" + "<td>" + "--" + "<td>" +"--" +
                    "<td>" + "--" + "<td>" + "--" + "<td>" + "--" +
                    "<td>" + "--" + "</tr>");
    }

    // Otra parte del código...
%>

            </table>
                        
                            </div>
                        </div>
                    </div>
                    
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary">IMPORTANTE</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                    <h1>Para solicitar reembolso o cancelación
                                    </h1> <p>COMUNICARSE CON ATENCIÓN AL CLIENTE</p>
                                    <a class="btn btn-arrow btn-success" href="https://wa.link/o73lgd">CONTACTO</a>                       
                            </div>
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
                        <span>Copyright &copy; Turismo San Ramón 2022</span>
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

   

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="js/demo/datatables-demo.js"></script>

</body>
</html>