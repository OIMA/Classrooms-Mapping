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
        <!--        
                <link type="text/css" href="css/bootstrap.css" rel="stylesheet">
                <link rel="stylesheet" href="css/bootstrap-theme.css" type="text/css" />
                <link type="text/css" href="css/sb-admin.css" rel="stylesheet">
                <link type="text/css" rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
                <link rel="stylesheet" href="css/tablas.css" type="text/css" />-->

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
                        <li><a href="LlenarAula.xx?idAulaString=1"><i class="fa fa-bar-chart-o"></i> Llenar aula</a></li>
                        <li><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li class="active"><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                        <li><a href="Bloques.xx"><i class="fa fa-font"></i> Bloques</a></li>
                        <li><a href="Documentos.xx"><i class="fa fa-desktop"></i> Documentos</a></li>
                        <li><a href="Configuracion.xx"><i class="fa fa-wrench"></i> Configuracion</a></li>
                        <li><a href="Archivos.xx"><i class="fa fa-file"></i> Archivos</a></li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Sesion<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="">sd</a></li>
                                <li><a href="">csd</a></li>
                                <li><a href="">dcs</a></li>
                                <li><a href="">cs</a></li>
                                <li><a href="">sd</a></li>
                                <li><a href="">csd</a></li>
                                <li><a href="">dcs</a></li>
                                <li><a href="">cs</a></li>
                                <li><a href="">sd</a></li>
                                <li><a href="">csd</a></li>
                                <li><a href="">dcs</a></li>
                                <li><a href="">cs</a></li>
                                <li><a href="">sd</a></li>
                                <li><a href="">csd</a></li>
                                <li><a href="">dcs</a></li>
                                <li><a href="">cs</a></li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <!--Usuario-->
                        <li class="dropdown user-dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Benjamin<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""><i class="fa fa-user"></i> Perfil</a></li>
                                <li><a href=""><i class="fa fa-gear"></i> Configuracion</a></li>
                                <li class="divider"></li>
                                <li><a href=""><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <div class="btn-toolbar">
                    <div class="btn-group">
                        <button id="botonCarreras" type="button" class="btn btn-primary">Carreras</button>
                        <button id="botonUsuarios" type="button" class="btn btn-primary">Usuarios</button>
                        <button id="botonEspecialidades" type="button" class="btn btn-primary">Especialidades</button>
                        <button id="botonProfesores" type="button" class="btn btn-primary">Profesores</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonMaterias" type="button" class="btn btn-primary">Materias</button>
                        <button id="botonGrupos" type="button" class="btn btn-primary">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-primary">Planes</button>
                        <button id="botonAulas" type="button" class="btn btn-primary">Aulas</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonCicloEscolar" type="button" class="btn btn-primary">Ciclo Escolar</button>
                    </div>
                </div>
                <!--FormularioUsuario-->
                <div id="formularioUsuario" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta usuario</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoUsuario.xx" method="POST" commandName="usuario">
                        <div class="form-group">
                            <form:label path="" for="nombre" class="col-sm-1 control-label">Nombre(s)</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombre" type="text" class="form-control" id="nombre" placeholder="Nombre(s)" />
                            </div>
                            <form:label path="" for="ap_pat" class="col-sm-1 control-label">Apellido Paterno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apPat" type="text" class="form-control" id="ap_pat" placeholder="Apellido Paterno" />
                            </div>
                            <form:label path="" for="ap_mat" class="col-sm-1 control-label">Apellido Materno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apMat" type="text" class="form-control" id="ap_mat" placeholder="Apellido Materno" />
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" for="nombreUsuario" class="col-sm-1 control-label">Usuario</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreUsuario" type="text" class="form-control" id="nombreUsuario" placeholder="Nombre usuario" />
                            </div>
                            <form:label path="" for="passwordUsuario" class="col-sm-1 control-label">Contrase&ntilde;a</form:label>
                                <div class="col-sm-3">
                                <form:input path="passwordUsuario" type="password" class="form-control" id="passwordUsuario" placeholder="Contrase&ntilde;a" />
                            </div>
                            <form:label path="" class="col-sm-1 control-label">Tipo</form:label>
                                <div class="col-sm-3">
                                <form:select path="tipo" class="form-control ">
                                    <form:option value="1">Administrador</form:option>
                                    <form:option value="2">Coordinador</form:option>
                                    <form:option value="3">Visitante</form:option>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-1">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin FormularioUsuario-->
                <!--FormularioCarrera-->
                <div id="formularioCarrera" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta carrera</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevaCarrera.xx" method="POST" commandName="carrera">
                        <div class="form-group">
                            <form:label path="" for="nombreCarrera" class="col-sm-2 control-label">Nombre</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreCarrera" type="text" class="form-control" id="nombreCarrera" placeholder="Nombre(s)" />
                            </div>
                            <form:label path="" for="usuario" class="col-sm-2 control-label">Usuario</form:label>
                                <div class="col-sm-3">
                                <form:select path="idUsuario.idUsuario" class="form-control ">
                                    <c:forEach items="${listaUsuarios}" var="u">
                                        <form:option value="${u.idUsuario}" label="${u.nombreUsuario}" />
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin formularioCarrera-->
                <!--formulariespecialidad-->
                <div id="formularioEspecialidad" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta Especialidad</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevaEspecialidad.xx" method="POST" commandName="especialidad">
                        <div class="form-group">
                            <form:label path="" for="nombreEspecialidad" class="col-sm-2 control-label">Nombre Especialidad</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreEspecialidad" type="text" class="form-control" id="nombreEspecialidad" placeholder="Nombre de la especialidad" />
                            </div>
                            <form:label path="" for="usuario" class="col-sm-2 control-label">Carrera</form:label>
                                <div class="col-sm-3">
                                <form:select path="idCarrera.idCarrera" class="form-control ">
                                    <c:forEach items="${listaCarreras}" var="t">
                                        <form:option value="${t.idCarrera}">${t.nombreCarrera}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin formularioEspecialidad-->
                <!--FormularioProfesor-->
                <div id="formularioProfesor" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta Profesor</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoProfesor.xx" method="POST" commandName="profesor">
                        <div class="form-group">
                            <form:label path="nombreProfesor" for="nombre" class="col-sm-1 control-label">Nombre(s)</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreProfesor" type="text" class="form-control" id="nombre" placeholder="Nombre(s)" name="nombre_profesor"/>
                            </div>
                            <form:label path="apPatProfesor" class="col-sm-1 control-label">Apellido Paterno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apPatProfesor" type="text" class="form-control" id="apPatProfesor" placeholder="Apellido Paterno" name="apPatProfesor"/>
                            </div>
                            <form:label path="apMatProfesor" for="apMatProfesor" class="col-sm-1 control-label">Apellido Materno</form:label>
                                <div class="col-sm-3">
                                <form:input path="apMatProfesor" type="text" class="form-control" id="apMatProfesor" placeholder="Apellido Materno" name="apMatProfesor"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-1">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin FormularioProfesor-->
                <!--FormularioMateria-->
                <div id="formularioMateria" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta Materia</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevaMateria.xx" method="POST" commandName="materia">
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-1">
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" for="nombreMateria" class="col-sm-1 control-label">Nombre</form:label>
                                <div class="col-sm-7">
                                <form:input path="nombreMateria" type="text" class="form-control" id="nombreMateria" placeholder="Nombre Materia" />
                            </div>
                            <form:label path="" for="hp" class="col-sm-1 control-label">Horas Pr&aacute;cticas</form:label>
                                <div class="col-sm-1">
                                <form:input path="horasPracticas" type="text" class="form-control" id="hp" placeholder="Horas Pr&aacute;cticas" />
                            </div>
                            <form:label path="" for="ht" class="col-sm-1 control-label">Horas Te&oacute;ricas</form:label>
                                <div class="col-sm-1">
                                <form:input path="horasTeoricas" type="text" class="form-control" id="ht" placeholder="Horas te&oacute;ricas" />
                            </div>
                        </div>
                        <form:label path="" for="carrera" class="col-sm-1 control-label">Especialidad</form:label>
                            <div class="col-sm-3">
                            <form:select path="idEspecialidad.idEspecialidad" class="form-control" id="carrera">
                                <c:forEach items="${listaEspecialidades}" var="t">
                                    <form:option value="${t.idEspecialidad}">${t.nombreEspecialidad}</form:option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <form:label path="" class="col-sm-1 control-label">Bloque</form:label>
                            <div class="btn-toolbar">
                                <div class="btn-group">
                                    <button id="b1" type="button" class="btn btn-default" value="1">1</button>
                                    <button id="b2" type="button" class="btn btn-default" value="2">2</button>
                                    <button id="b3" type="button" class="btn btn-success" value="3">3</button>
                                    <button id="b4" type="button" class="btn btn-default" value="4">4</button>
                                    <button id="b5" type="button" class="btn btn-default" value="5">5</button>
                                    <button id="b6" type="button" class="btn btn-default" value="6">6</button>
                                    <button id="b7" type="button" class="btn btn-default" value="7">7</button>
                                    <button id="b8" type="button" class="btn btn-default" value="8">8</button>
                                    <button id="b9" type="button" class="btn btn-default" value="9">9</button>
                                </div>
                            </div>
                        <form:hidden path="bloque" class="col-sm-1 control-label" value="3" id="bloque"></form:hidden>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-1">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-1">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin FormularioMateria-->
                <!--formulariPlan-->
                <div id="formularioPlan" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta nuevo plan de estudios</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoPlan.xx" method="POST" commandName="plan">
                        <div class="form-group">
                            <label for="nombre_plan" class="col-sm-2 control-label">Nombre o clave:</label>
                            <div class="col-sm-3">
                                <form:input path="nombrePlan" type="text" class="form-control" id="nombrePlan" placeholder="Nombre o clave del plan" name="nombre_plan" />
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin formularioPlan-->
                <div id="formularioAula" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta Aula</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevaAula.xx" method="POST" commandName="aula">
                        <div class="form-group">
                            <form:label path="" for="edificio" class="col-sm-2 control-label">Nombre del edificio:</form:label>
                                <div class="col-sm-3">
                                <form:input path="edificio" type="text" class="form-control" id="nombreEdificio" placeholder="Nombre del edificio" />
                            </div>
                            <form:label path="" for="aula" class="col-sm-2 control-label">Nombre del aula</form:label>
                                <div class="col-sm-3">
                                <form:input path="aula" type="text" class="form-control" id="aula" placeholder="Nombre del aula" />
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" for="tipoAula" class="col-sm-2 control-label">Tipo de aula</form:label>
                                <div class="col-sm-3">
                                <form:select path="tipoAula" class="form-control" id="tipoAula">
                                    <form:option value="0">Practica</form:option>
                                    <form:option value="1">Teorica</form:option>
                                </form:select>
                            </div>
                            <form:label path="" for="capacidad" class="col-sm-2 control-label">Capacidad del aula</form:label>
                                <div class="col-sm-3">
                                <form:input path="capacidadAula" type="text" class="form-control" id="capacidad" placeholder="Capacidad de alumnos" />
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="" for="idCarrera" class="col-sm-2 control-label">Carrera</form:label>
                                <div class="col-sm-3">
                                <form:select path="idCarrera.idCarrera" class="form-control" id="idCarrera">
                                    <c:forEach items="${listaCarreras}" var="t">
                                        <form:option value="${t.idCarrera}">${t.nombreCarrera}</form:option>
                                    </c:forEach>
                                </form:select>
                            </div>
                            <div class="col-sm-offset-1 col-sm-3">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>    
                            </div>

                    </form:form>
                </div><!--Fin formularioAula-->
                <div id="formularioCicloEscolar" class="panel panel-success">
                    <div class="panel-heading"><h3>Alta Ciclo Escolar</h3></div>
                    <form:form class="form-horizontal" role="form"  commandName="cicloEscolar" action="NuevoCicloEscolar.xx" method="POST" >
                        <div class="form-group">
                            <form:label path="" for="nombreCicloEscolar" class="col-sm-2 control-label">Ciclo Escolar</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreCicloEscolar" type="text" class="form-control" id="nombreCicloEscolar" name="nombreCicloEscolar" placeholder="Nombre CicloEscolar"/>
                                <form:input path="fechaInicio" type="text" class="form-control" id="fechaInicioCicloEscolar" name="fechaInicio" placeholder="Fecha inicio"/>
                                <form:input path="fechaFin" type="text" class="form-control" id="fechaFinCicloEscolar" name="fechaFin" placeholder="Fecha fin"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin formularioCicloEscolar-->
                <!--FormularioGrupos-->
                <div id="formularioGrupo" class="panel panel-success">
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
                            </div>
                            <form:label path="" for="capacidad" class="col-sm-1 control-label">Capacidad</form:label>
                                <div class="col-sm-3">
                                <form:input path="capacidadGrupo" type="text" class="form-control" id="capacidad" placeholder="capacidad del grupo" />
                            </div>
                        </div>
                        <!--<div class="form-group">-->
                            <%--<form:label path="" for="horasPracticas" class="col-sm-1 col-sm-offset-1 control-label">Horas Pr&aacute;cticas</form:label>--%>
                                <!--<div class="col-sm-3">-->
                                <form:hidden path="horasPracticasRestantes" id="horasPracticasGrupo" value=""/>
                            <!--</div>-->
                            <%--<form:label path="" for="horasTeoricas" class="col-sm-1 control-label">Horas te&oacute;ricas</form:label>--%>
                                <!--<div class="col-sm-3">-->
                                <form:hidden path="horasTeoricasRestantes" id="horasTeoricasGrupo" value=""/>
                            <!--</div>-->
                        <!--</div>-->
                        <div class="form-group">
                            <form:label path="" for="materia" class="col-sm-2 control-label">Materia</form:label>
                                <div class="">
                                    <div class="col-sm-3">
                                    <form:select path="idMateria.idMateria" class="form-control " id="selectMaterias">
                                        <c:forEach items="${listaMaterias}" var="u">
                                            <form:option value="${u.idMateria}" label="${u.nombreMateria}" />
                                        </c:forEach>
                                    </form:select>
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
                                </div>
                            </div>

                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                    </div>
                                </div>
                        </form:form>
                    </div><!--Fin formularioGrupos-->
                </div>
            </div><!-- /#wrapper -->


            <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
            <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
            <script type="text/javascript" src="js/formularios.js"></script>
    </body>
</html>

