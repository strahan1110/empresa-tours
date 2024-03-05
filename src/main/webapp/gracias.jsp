
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.AgenciaViajes,modelo.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="css/bootstrap-4.min.css" rel="stylesheet" type="text/css"/>
    <script src="js/bootstrapValidator.js" type="text/javascript"></script>
    <script src="js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery-1.10.2.min.js" type="text/javascript"></script>
    <title>Servicio Guardado</title>

    <!-- Custom fonts for this template-->
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
</head>

<body class="bg-gradient-success">
    
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

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-listo-image"><img src="img/check.png" width="400px" height="400px" style="text-align: center;margin: 20px"/></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <a href="portada.jsp"><img src="img/volver-flecha.png" height="20px"></a>
                                        <p>Salir</p>
                                        <h1 class="h4 mb-4 text-success" >¡Registro exitoso!</h1>
                                        </div>
                                                                    
                                    <form class="user" name="fr">
                    <fieldset>
                    <div class="form-group">
                        <label class="text-center ">No olvide acercarse a nuestras instalaciones para finalizar el proceso de compra</label>
                     </div>
                    <div class="form-group">                
                        <label class="text-center ">Recuerde que se le solicitará su Documento de Identidad</label><br>
                        <label class="text-center" style="font-weight: bold">Gracias por elegir a Turismo San Ramon</label>
                    </div>
                    <div class="form-group">                
                        
                    </div>
                     </fieldset>
                                        <input type="button" value="Separar más tours" class="btn btn-success btn-user btn-block" onclick="history.go(-2)"><br>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
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