<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <title>Administraci&oacute;n de aulas</title>

        <!-- Bootstrap core CSS -->
        <link type="text/css" href="css/bootstrap.css" rel="stylesheet">
        <link type="text/css" href="css/bootstrap-theme.css" rel="stylesheet">

        <!--<link type="text/css" href="css/tema.css" rel="stylesheet">-->
        <!-- Add custom CSS here -->
        <!--<link type="text/css" rel="stylesheet" href="font-awesome/css/font-awesome.min.css">-->
        <!-- Page Specific CSS -->



    </head>

    <body>
        <div class="modal fade" id="modalAcercaDe" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
<!--                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="tituloModal"></h4>
                    </div>-->
                    <div class="modal-body" id="cuerpoModal">
                        <h1>Sistema elaborado por</h1>
                        <h2>I.S.C. Oscar Iv&aacute;n Mart&iacute;nez Arce</h2>
                        <h2>En Instituto Tecnol&oacute;gico de Toluca</h2>
                        <h3><strong>Tel.</strong>7221206410</h3>
                        <h3><strong>E-mail.</strong>oima_91@hotmail.com</h3>
                        <div class="col-md-12 center-block" id="logo"><img class="center-block" alt="" src="<%=request.getContextPath()%>/images/tec.jpg" width="238px" height="257px"/></div>
                    </div>
                </div>
            </div>
        </div>
        <div id="wrapper">
            <!-- Sidebar -->
            <!--            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                             Brand and toggle get grouped for better mobile display 
                            <div class="navbar-header">
                                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                                    <span class="sr-only">Toggle navigation</span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                    <span class="icon-bar"></span>
                                </button>
                                <a class="navbar-brand" href="">Administracion de aulas</a>
                            </div>
                        </nav>-->



            <div id="page-wrapper" style="margin-top: 10%;">

                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="row clearfix">
                                <div class="col-md-7 column">
                                    <div class="jumbotron">
                                        <h2>
                                            Administraci&oacute;n de aulas.
                                        </h2>
                                        <p>
                                            Este programa fue realizado con el objetivo de apoyar a los coordinadores de las carreras de los institutos tecnol&oacute;gicos a 
                                            crear, administrar y distribuir los horarios de sus grupos en las distintas aulas asignadas cada carrera.
                                        </p>
                                        <p>
                                            <a class="btn btn-primary btn-large" id="acercaDe">Acerca de</a>
                                        </p>
                                    </div>
                                </div>
                                <div class="col-md-1 column">
                                </div>
                                <div class="col-md-3 column">
                                    <div class="panel panel-primary">
                                        <div class="panel-heading" >
                                            <h3 class="" >Inicio de sesi&oacute;n</h3>
                                        </div>
                                        <div class="panel-body">
                                            <form role="form" action="<c:url value='j_spring_security_check' />" method="POST">
                                                <div class="form-group">
                                                    <label for="">Usuario</label><input type="text" class="form-control" id="" name="j_username"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="">Contrase&ntilde;a</label><input type="password" class="form-control" id="" name="j_password"/>
                                                </div>

                                                <button type="submit" class="btn btn-default">Iniciar</button>
                                            </form>
                                        </div>
                                    </div>
                                    <c:if test="${not empty error}">
                                        <div class="errorblock">
                                            <!--Your login attempt was not successful, try again.<br /> Caused :-->
                                            <div class="alert alert-danger alert-dismissable">
                                                <!--<button type="button" class="close" data-dismiss="alert">&times;</button>-->
                                                <strong>¡Error de usuario o contrase&ntilde;a!</strong> Recuerda que ambos campos son sensibles a may&uacute;sculas.
                                            </div>
                                            ${sessionSscope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                                        </div>
                                    </c:if>
                                </div>
                                <div class="col-md-1 column">
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!--                <div class="panel panel-default" style="width: 35%;margin-left: auto;margin-right: auto;background: #FFF;">
                                    <div class="panel-heading" >
                                        <h3 class="" style="margin-left: 30%;margin-right: auto;">Inicio de sesi&oacute;n</h3>
                                    </div>
                                    <div class="panel-body">
                                        <form class="form-horizontal" action="<c:url value='j_spring_security_check' />" method="POST">
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="usuario" class="col-sm-2 control-label">Usuario</label>
                                                <div class="col-sm-9 col-sm-offset-1">
                                                    <input type="text" class="form-control" id="usuario" placeholder="Usuario o e-mail" name="j_nombre_usuario" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label for="contrasenia" class="col-sm-2 control-label">Contrase&ntilde;a</label>
                                                <div class="col-sm-9 col-sm-offset-1">
                                                    <input type="password" class="form-control" id="contrasenia" placeholder="Contrase&ntilde;a" name="j_password_usuario" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-12">
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <div class="col-sm-offset-3 col-sm-4">
                                                    <button type="submit" class="btn btn-primary btn-lg" >Iniciar</button>
                                                </div>
                                            </div>
                                        </form>
                                    </div>
                                </div>-->
            </div>
        </div><!-- /#wrapper -->





        <!--<script type="text/javascript" src="js/llenarAulas.js"></script>-->
        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script>$("#acercaDe").click(function(){
            $("#modalAcercaDe").modal('toggle');
        });
        </script>
    </body>
</html>

