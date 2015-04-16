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
                        <div class="col-md-1 column">
                        </div>
                        <div class="col-md-5 column">
                            <form:form class="form-horizontal" role="form" action="EditarPerfil.xx" method="POST" commandName="usuario">
                                <form:hidden path="idUsuario"/>
                                <div class="form-group">
                                    <form:label path="" for="nombre" class="col-sm-1 control-label">Nombre(s)</form:label>
                                        <div class="col-">
                                        <form:input path="nombre" type="text" class="form-control" id="nombre" placeholder="Nombre(s)" />
                                        <label class="label label-danger">${errorNombre}</label>
                                    </div>
                                    </div>
                                    <div class="form-group">
                                    <form:label path="" for="ap_pat" class="col-sm-1 control-label">Apellido Paterno</form:label>
                                        <div class="col-sm-">
                                        <form:input path="apPat" type="text" class="form-control" id="ap_pat" placeholder="Apellido Paterno" />
                                        <label class="label label-danger">${errorApPat}</label>
                                    </div>
                                    </div>
                                    <div class="form-group">
                                    <form:label path="" for="ap_mat" class="col-sm-1 control-label">Apellido Materno</form:label>
                                        <div class="col-sm-">
                                        <form:input path="apMat" type="text" class="form-control" id="ap_mat" placeholder="Apellido Materno" />
                                        <label class="label label-danger">${errorApMat}</label>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <form:label path="" for="nombreUsuario" class="col-sm-1 control-label has-error">Usuario</form:label>
                                        <div class="col-sm-">
                                        <form:input path="nombreUsuario" type="text" class="form-control  has-error" id="nombreUsuario" placeholder="Nombre usuario" />
                                        <label class="label label-danger">${errorNombreUsuario}</label>
                                    </div>
                                </div>
                                    <div class="form-group">
                                    <form:label path="" for="passwordUsuario" class="col-sm-1 control-label">Contrase&ntilde;a</form:label>
                                        <div class="col-sm-">
                                        <form:input path="passwordUsuario" type="password" class="form-control" id="passwordUsuario" placeholder="Contrase&ntilde;a" />
                                        <label class="label label-danger">${errorContrasenia}</label>
                                    </div>
                                    </div>
                                <div class="form-group">
                                    <div class="">
                                        <form:button id="botonUsuario" type="submit" class="btn btn-success">Aceptar</form:button>
                                        </div>
                                    </div>
                                        <form:hidden path="tipo"/>
                            </form:form>
                        </div>
                        <div class="col-md-1 column">
                        </div>
                        <div class="col-md-4 column">
                            <h2>
                                Bienvenido
                            </h2>
                            <p>
                                En este sitio podr&aacute;s editar a tu gusto el nombre que quieras que aparezca en tu usuario,
                                y la contrase&ntilde;a con la que iniciar&aacute;s sesi&oacute;n. 
                                <br/>
                                <br/>
                                Ten cuidado al cambiar la contrase&ntilde;a, porque si la olvidas, tendr&aacute;s que acudir al
                                administrador para recuperarla. Por cada cambio que realices en este sitio, tu sesi&oacute;n 
                                ser&aacute; cerrada y tendr&aacute;s que volver a ingresar.
                            </p>
                            <!--<img alt="200x200" src="http://lorempixel.com/350/200/" />-->
                        </div>
                        <div class="col-md-1 column">
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

