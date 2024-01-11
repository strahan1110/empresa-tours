<%@page import="modelo.*, dao.AgenciaViajes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <title>portada</title>
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

    <div class="container">

        <div class="card o-hidden border-0 shadow-lg my-5">
            <div class="card-body p-0">
                <!-- Nested Row within Card Body -->
                <div class="row">
                    <div class="col-lg-4 d-none d-lg-block bg-listo-image"><img src="img/registro.png" width="350px" height="400px" style="text-align: center;margin: 100px 50px"/></div>
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">Crea tu cuenta fácilmente</h1>
                            </div>
	<form action="controlCliente" id="id_form" class="user" method="POST">
			<input type="hidden" name="opc" value="1">
                        
                        <div class="form-group row">
			<div class="col-sm-6 mb-3 mb-sm-0">
                            <input class="form-control form-control-user" type="text" id="id_nombre" name="nombre" placeholder="Ingrese el nombre">
			</div>
			<div class="col-sm-6">
                            <input class="form-control form-control-user" type="text" id="id_apellido" name="apellido" placeholder="Ingrese el apellido">
			</div>
                            </div>
                        
                        <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                            <input class="form-control form-control-user" type="text" id="id_dni" name="dni" placeholder="Ingrese su DNI">
                        </div>
                            <div class="col-sm-6">
                            <input class="form-control form-control-user" type="text" id="id_direc" name="direc" placeholder="Ingrese su dirección">
			</div>
                           </div> 
                            
                        <div class="form-group">
                            <input class="form-control form-control-user" type="text" id="id_tel" name="tel" placeholder="Ingrese su teléfono">
			</div>
                        
                        <div class="form-group">
                            <input class="form-control form-control-user" type="text" id="id_correo" name="correo" placeholder="Ingrese su correo">
			</div>
                        
                         <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                            <input class="form-control form-control-user" type="text" id="id_nacio" name="nacio"
                                            placeholder="Nacionalidad">
			</div>
                             
                        <div class="col-sm-6">
                            <input class="form-control form-control-user" type="password" id="psw" name="psw" placeholder="Contraseña">
			</div>
                        </div>
                        <input type="submit" class="btn btn-warning btn-user btn-block">
                                <hr>
                        
	</form>
            <hr>
                            <div class="text-center">
                                ¿Ya tienes una cuenta?<a class="small" href="login.jsp"><br>¡Inicia Sesión!</a>
                            </div>
</div>
    </div>   </div>
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
  
    <script type="text/javascript">
$(document).ready(function() {
    $('#id_form').bootstrapValidator({
        message: 'This value is not valid',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	nombre: {
                validators: {
                    notEmpty: {
                        message: 'El nombre es un campo obligatorio'
                    },
              regexp:{
            	  regexp: /^[A-Za-z ñÑ]+$/,
                  message: 'Solo letras o espacios' 
              }
                }
            },
        	apellido: {
                validators: {
                    notEmpty: {
                        message: 'El apellido es un campo obligatorio'
                    },
                    regexp:{
            	  regexp: /^[A-Za-z ñÑ]+$/,
                  message: 'Solo letras o espacios' 
              }
                } //validacion
            },
        	dni: {
                validators: {
                    notEmpty: {
                        message: 'El dni es un campo obligatorio'
                    },
		            regexp:{
            	  regexp: /^\d{8}$/,
                  message: 'Tu DNI debería tener 8 dígitos' 
		            }
                }
            },      
            direc: {
                validators: {
                    notEmpty: {
                        message: 'La dirección es un campo obligatorio'
                    },
              regexp:{
            	  regexp: /[A-Za-z0-9'\.\-\s\,]/,
                  message: 'Letras, números o espacios' 
              }
                }
		           
            },          
               tel: {
                validators: {
                    notEmpty: {
                        message: 'El teléfono es un campo obligatorio'
                    },
		  regexp:{
            	  regexp: /^\d{9}$/,
                  message: 'Tu teléfono debería tener 9 dígitos' 
		            }
                }
            },          
              correo: {
                validators: {
                    notEmpty: {
                        message: 'Tu correo es importante'
                    },
		  regexp:{
            	  regexp: /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                  message: 'Ingresa un correo válido porfavor' 
		            }
                }
            },          
              nacio: {
                validators: {
                    notEmpty: {
                        message: 'Nos importa saber de dónde eres'
                    },
                    regexp:{
            	  regexp: /^[A-Za-z ñÑ]/,
                  message: 'Solo letras' 
              }
                } 
            },
                psw: {
                validators: {
                    notEmpty: {
                        message: 'Contraseña obligatoria'
                    },
		  regexp:{
            	  regexp: /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\S+$).{8,}$/,
                  message: 'Ingrese una contraseña válida' 
		    }
                }
            }
        }   
    });

    // Validate the form manually
    $('#validateBtn').click(function() {
        $('#id_form').bootstrapValidator('validate');
    });
});
</script>
</body>

</html>
