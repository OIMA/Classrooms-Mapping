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
                    <ul class="nav navbar-nav side-nav">
                        <li><a href="Estadisticas.xx"><i class="fa fa-dashboard"></i> Estadisticas</a></li>
                        <li><a href="LlenarAula.xx"><i class="fa fa-bar-chart-o"></i> Llenar aula</a></li>
                        <li><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li class="active"><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                    </ul>

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
                        <div class="col-md-3 column">
                        </div>
                        <div class="col-md-6 column">
                            <div class="panel panel-danger">
                                <div class="panel-heading">
                                    <h1 class="panel-titl">
                                        Lamentamos las molestias ('_')
                                    </h1>
                                </div>
                                <div class="panel-body">
                                    <div class="page-header">
                                        <h1>
                                            Por el momento no hay aulas disponibles
                                        </h1>
                                    </div>
                                    <p>
                                        Le sugerimos que contacte al administrador del sistema para que le asigne aulas.
                                        <br />
                                        En caso de que sea un administrador le sugerimos que se dirija al m&oacute;dulo de 
                                        Formularios que se encuentra en el panel a la izquierda, despu&eacute;s se dirija 
                                        al bot&oacute;n de Aulas y llene el formulario correspondiente para asignar una nueva
                                        Aula.
                                        <br />
                                        <br />
                                        Las aulas pertenecen a ciertas carreras, por lo que es necesario indicar que carrera es 
                                        la que va a administrar cada aula.
                                        <br/>
                                        S&oacute;olo el administrador puede romper estas restricciones.
                                        <br />
                                        Por su comprensi&oacute;n, gracias.
                                        
                                    </p>
                                </div>
                                <div class="panel-footer">
                                    <button type="button" class="btn btn-danger btn-xs" onclick="$(location).attr('href','Formularios.xx')">Reportar</button>
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

