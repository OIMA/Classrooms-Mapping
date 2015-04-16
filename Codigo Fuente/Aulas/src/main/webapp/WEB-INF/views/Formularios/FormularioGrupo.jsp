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
                        <button id="botonProfesores" type="button" class="btn btn-default">Profesores</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonMaterias" type="button" class="btn btn-default">Materias</button>
                        <button id="botonGrupos" type="button" class="btn btn-primary">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-default">Planes</button>
                        <button id="botonAulas" type="button" class="btn btn-default">Aulas</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonCicloEscolar" type="button" class="btn btn-default">Ciclo Escolar</button>
                    </div>
                </div>
                <!--FormularioGrupos-->
                <div id="formularioGrupo" class="panel">
                    <div class="panel-heading"><h3>Alta grupo</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoGrupo.xx" method="POST" commandName="grupo">
                        
                        
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" for="claveGrupo" class="col-sm-2 control-label">Clave:</form:label>
                                <div class="col-sm-3">
                                <form:input path="claveGrupo" type="text" class="form-control" id="claveGrupo" placeholder="ID o clave del grupo" />
                                <label class="label label-danger">${errorClave}</label>
                            </div>
                            <form:label path="" for="capacidad" class="col-sm-1 control-label">Capacidad</form:label>
                                <div class="col-sm-3">
                                <form:input path="capacidadGrupo" type="text" class="form-control" id="capacidad" placeholder="capacidad del grupo" />
                                <label class="label label-danger">${errorCapacidad}</label>
                            </div>
                        </div>
                        <form:hidden path="horasPracticasRestantes" id="horasPracticasGrupo" value=""/>
                        <form:hidden path="horasTeoricasRestantes" id="horasTeoricasGrupo" value=""/>
                        <div class="form-group">
                            <form:label path="" for="materia" class="col-sm-2 control-label">Materia</form:label>
                                <div class="">
                                    <div class="col-sm-3">
                                    <form:select path="idMateria.idMateria" class="form-control " id="selectMaterias">
                                        <c:forEach items="${listaMaterias}" var="u">
                                            <form:option value="${u.idMateria}" label="${u.nombreMateria}" />
                                        </c:forEach>
                                    </form:select>
                                    <label class="label label-danger">${errorMateria}</label>
                                </div>
                            </div>
                            <div class="">
                                <form:label path="" for="" class="col-sm-1 control-label">Profesor</form:label>
                                    <div class="col-sm-3">
                                    <form:select path="idProfesor.idProfesor" class="form-control ">
                                        <c:forEach items="${listaProfesores}" var="u">
                                            <form:option value="${u.idProfesor}" label="${u.nombreProfesor} ${u.apPatProfesor} ${u.apMatProfesor}" />
                                        </c:forEach>
                                    </form:select>
                                    <label class="label label-danger">${errorProfesor}</label>
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" class="col-sm-2 control-label">Plan:</form:label>
                                <div class="">
                                    <div class="col-sm-3">
                                    <form:select path="idPlan.idPlan" class="form-control ">
                                        <c:forEach items="${listaPlanes}" var="u">
                                            <form:option value="${u.idPlan}" label="${u.nombrePlan}" />
                                        </c:forEach>
                                    </form:select>
                                    <label class="label label-danger">${errorPlan}</label>
                                </div>
                            </div>
                            <div class="">
                                <form:label path="" for="" class="col-sm-1 control-label">Ciclo escolar</form:label>
                                    <div class="col-sm-3">
                                    <form:select path="idCicloEscolar.idCicloEscolar" class="form-control ">
                                        <c:forEach items="${listaCicloEscolar}" var="u">
                                            <form:option value="${u.idCicloEscolar}" label="${u.nombreCicloEscolar}" />
                                        </c:forEach>
                                    </form:select>
                                    <label class="label label-danger">${errorCicloEscolar}</label>
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-2">
                                    <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                    </div>
                                    <div id="divForzar" class="col-sm-offset-1 col-sm-1">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <label class="text-center">Forzar</label>
                                                <input id="checkForzar" type="checkbox" ${checked}>
                                        </span>
                                        <form:select path="forzarGrupo" id="selectForzar" class="form-control">
                                            <form:option value="T" >Te&oacute;rico</form:option>
                                            <form:option value="P" >Pr&aacute;ctico</form:option>
                                            <form:option value="null" >No forzar</form:option>
                                        </form:select>
                                    </div><!-- /input-group -->
                                    </div>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin formularioGrupos-->
            </div>
            ${mensajeInicial}
        </div><!-- /#wrapper -->

        <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
        <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
        <!--<script type="text/javascript" src="js/formularios.js"></script>-->
        <script type="text/javascript" src="js/validaciones.js"></script>
    </body>
</html>

