<%-- 
    Document   : altas
    Created on : Dec 14, 2013, 2:08:27 PM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include  file="../config/bootstrapConf.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Oscar Ivan Martinez Arce">

        <title>Administraci&oacute;n de aulas</title>
    </head>

    <body>
        <div id="wrapper">
            <!-- Sidebar -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="index.html">Administracion de aulas</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <!--Usuario-->
                        <li class="dropdown user-dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i>${nombreUsuario}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Perfil.xx"><i class="fa fa-user"></i> Perfil</a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-1 column">
                        </div>
                        <div class="col-md-6 column">
                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    <h1 class="panel-titl">
                                        Lamentamos las molestias 
                                        (' _ ')
                                    </h1>
                                </div>
                                <div class="panel-body">
                                    <div class="page-header">
                                        <h1>
                                            Por el momento no tienes asignada ninguna carrera
                                        </h1>
                                    </div>
                                    <p>
                                        Te sugerimos que contactes al administrador del sistema.
                                        <br />
                                        S&oacute;lo el administrador puede asignarte una carrera, de lo contrario no podr&aacute;s
                                        modificar nada. O puedes pedir que te den permisos de administrador para poder acceder sin
                                        tener asignada ninguna carrera
                                        <br />
                                        <br />
                                        Para m&aacute;s informaci&oacute;n puedes consultar el manual de usuario.
                                        <br/>
                                        <b>S&oacute;lo el administrador puede romper estas restricciones.</b>
                                        <br /><br/>
                                    Por su comprensi&oacute;n, gracias.
                                        
                                    </p>
                                </div>
                                <div class="panel-footer">
                                    <!--<span class="pull-right">-->
                                    OIMA
                                    <!--</span>-->
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3 column">
                        </div>
                    </div>
                </div>
            </div><!-- /#wrapper -->


            <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
            <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
            <!--<script type="text/javascript" src="../js/formularios.js"></script>-->
            <script type="text/javascript" src="js/validaciones.js"></script>
    </body>
</html>

