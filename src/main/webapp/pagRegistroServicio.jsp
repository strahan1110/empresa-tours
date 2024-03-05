
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.AgenciaViajes,modelo.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>Registro de Servicios</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="js/prefixfree.min.js"></script>
    <script src="js/jquery-1.10.2.min.js"></script>
    <script src="js/bootstrapValidator.js"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    
      <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    
</head>

<body class="bg-gradient-warning">
    
    <%
            HttpSession ses=request.getSession();
            if(ses.getAttribute("cliente")==null){
                response.sendRedirect("login.jsp");
            }
            Clientes cli=(Clientes)ses.getAttribute("cliente");
            String nom=cli.getApe_cli()+", "+cli.getNom_clie();
            Tours a=(Tours)request.getAttribute("dato");
            AgenciaViajes obj=new AgenciaViajes();
        %>

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <center>
                <div class="column">
                    <div class="col-lg-6">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Registrar servicios</h1>
                            </div>
	<form action="controlServicio" id="id_form" class="user">
            <input  type="hidden" name="opc" value="7">
            <input type="hidden" name="tour" value="<%=a.getTour_id()%>">
            <input type="hidden" name="id" value="<%=cli.getId_cli()%>">
                        
                        <div class="form-group">
                            <label>Cliente: </label>
                            <input class="form-control form-control-user" name="nombre" type="text"  value="<%=nom%>" readonly>
			</div>
                        
                        <div class="form-group">
                            <label>Placa del Bus</label>
                            <input class="form-control form-control-user" name="placa" type="text"  value="<%=a.getPlaca()%>" readonly>
			</div>
                        
                        <div class="form-group">
                            <label>Nombre de Guia</label>
                            <input class="form-control form-control-user" name="guia" type="text" value="<%=a.getGuia()%>" readonly>
			</div>
                        
                        <div class="form-group">
                            <label>Fecha de Inicio</label>
                            <input class="form-control form-control-user" name="fechai" type="text"value="<%=a.getFecha_inicio()%>" readonly>
                        </div>
                        
                        <div class="form-group">
                            <label>Fecha de Finalización</label>
                            <input class="form-control form-control-user"  name="fechaf" type="text" value="<%=a.getFecha_fin()%>" readonly>
			</div>
                        
                        <div class="form-group">
                            <label id="tour">Tour</label>
                            <input class="form-control form-control-user" name="desc" type="text" value="<%=a.getDescrip_tour()%>" readonly>
			</div>
                        
                        <label id="pago">Metodo de Pago</label><br>
            <%
                for(FormaPago x:obj.lisPago()){
                    %>
                    <input type="radio" name="pago" value="<%=x.getId_fp()%>"><%=x.getDescrip()%><br>
                    <%
                }
            %><br>
                        <hr>
                        <div class="text-center">
                                ¿Conforme con la compra?<br>
                                <p>Si es así, guarde la información de su compra</p>
                            </div>
                        
                        <input class="btn btn-warning btn-user btn-block" type="submit">
                                <hr>
                        
	</form>
            
                            
</div>
    </div>   </div>
                    </center>
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