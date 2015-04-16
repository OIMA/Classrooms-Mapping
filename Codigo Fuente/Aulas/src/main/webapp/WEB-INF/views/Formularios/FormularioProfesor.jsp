<%-- 
    Document   : altas
    Created on : Dec 14, 2013, 2:08:27 PM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include  file="../../config/bootstrapConf.jsp"%>
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
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nombreUsuario}<b class="caret"></b></a>
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
                <div class="btn-toolbar">
                    <div class="btn-group">
                        <button id="botonCarreras" type="button" class="btn btn-default">Carreras</button>
                        <button id="botonUsuarios" type="button" class="btn btn-default">Usuarios</button>
                        <button id="botonEspecialidades" type="button" class="btn btn-default">Especialidades</button>
                        <button id="botonProfesores" type="button" class="btn btn-primary">Profesores</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonMaterias" type="button" class="btn btn-default">Materias</button>
                        <button id="botonGrupos" type="button" class="btn btn-default">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-default">Planes</button>
                        <button id="botonAulas" type="button" class="btn btn-default">Aulas</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonCicloEscolar" type="button" class="btn btn-default">Ciclo Escolar</button>
                    </div>
                </div>
                <!--FormularioProfesor-->
                <div id="formularioProfesor" class="panel">
                    <div class="panel-heading"><h3>Alta Profesor</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoProfesor.xx" method="POST" commandName="profesor">
                        <div class="form-group">
                            <form:label path="nombreProfesor" for="nombre" class="col-sm-1 control-label">Nombre(s)</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreProfesor" type="text" class="form-control" id="nombre" placeholder="Nombre(s)" name="nombre_profesor"/>
                                <label class="label label-danger">${errorNombre}</label>
                            </div>
                            <form:label path="apPatProfesor" class="col-sm-1 control-label">Apellido Paterno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apPatProfesor" type="text" class="form-control" id="apPatProfesor" placeholder="Apellido Paterno" name="apPatProfesor"/>
                                <label class="label label-danger">${errorApPat}</label>
                            </div>
                            <form:label path="apMatProfesor" for="apMatProfesor" class="col-sm-1 control-label">Apellido Materno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apMatProfesor" type="text" class="form-control" id="apMatProfesor" placeholder="Apellido Materno" name="apMatProfesor"/>
                                <label class="label label-danger">${errorApMat}</label>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-1">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin FormularioProfesor-->
            </div>
                            ${mensajeInicial}
        </div><!-- /#wrapper -->


        <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
        <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
        <!--<script type="text/javascript" src="../js/formularios.js"></script>-->
        <script type="text/javascript" src="js/validaciones.js"></script>
    </body>
</html>

