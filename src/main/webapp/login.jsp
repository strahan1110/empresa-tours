<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <title>Logueo</title>

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
           //recuperar la lista que el servlet envia
          //Articulo ar=(Articulo)request.getAttribute("dato");
          String mensaje="";
          if(request.getAttribute("dato")!=null){
              mensaje=(String)request.getAttribute("dato");
          }
         %>

    <div class="container">

        <!-- Outer Row -->
        <div class="row justify-content-center">

            <div class="col-xl-10 col-lg-12 col-md-9">

                <div class="card o-hidden border-0 shadow-lg my-5">
                    <div class="card-body p-0">
                        <!-- Nested Row within Card Body -->
                        <div class="row">
                            <div class="col-lg-6 d-none d-lg-block bg-listo-image"><img src="img/fondo1.png" width="400px" height="400px" style="text-align: center;margin: 20px"/></div>
                            <div class="col-lg-6">
                                <div class="p-5">
                                    <div class="text-center">
                                        <a href="portada.jsp"><img src="img/volver-flecha.png" height="20px"></a>
                                        <h1 class="h4 text-gray-900 mb-4">Bienvenido</h1>
                                        </div>
                                                                    
                    <form action="controlLogin" class="user" name="fr" method="POST">
                    <fieldset>
                    <input type="hidden" name="opc" value="1" >
                    <div class="form-group">
                    <input type="text" class="form-control form-control-user" name="user" id="user" placeholder="Ingrese su usuario">
                     </div>
                    <div class="form-group">                
                    <input type="password" class="form-control form-control-user" name="clave" id="psw" placeholder="Contraseña">
                    </div>
                     </fieldset>
                <input type="submit" value="Iniciar Sesion" class="btn btn-warning btn-user btn-block"><br>
                                    
                                    <hr>
                                    <div class="text-center">
                                       ¿No tienes una cuenta?  <a class="small" href="registro.jsp">Regístrate</a>
                                        <a  href="javascript:void(0);" onclick="verificarCodigo()"><img src="img/administrador.png" alt="administrador" height="20px"></a>
                                    </div>
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
    
    <!--VERIFICAR-->
    <script>
    function verificarCodigo() {
        // Obtener el código ingresado por el usuario
        var codigoIngresado = prompt("Ingrese el código otorgado por la oficina administrativa de Turismo San Ramón:");

        // Verificar si el código es correcto (ajusta el código permitido según sea necesario)
        var codigoPermitido = "123456"; // Cambia esto por tu código permitido
        if (codigoIngresado === codigoPermitido) {
            // Código correcto, redirigir a la página permitida
            window.location.href = "login_usr.jsp";
        } else {
            // Código incorrecto, mostrar mensaje de error
            alert("Código Incorrecto");
        }
    }
</script>

</body>

</html>