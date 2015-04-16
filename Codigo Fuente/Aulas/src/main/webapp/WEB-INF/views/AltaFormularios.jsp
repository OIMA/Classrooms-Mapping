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
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                                <li><a  href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
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
                        <button id="botonGrupos" type="button" class="btn btn-default">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-default">Planes</button>
                        <button id="botonAulas" type="button" class="btn btn-primary">Aulas</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonCicloEscolar" type="button" class="btn btn-default">Ciclo Escolar</button>
                    </div>
                </div>
                <!--FormularioUsuario-->
                <div id="formularioUsuario" class="hover">
                    <div class="panel-heading"><h3>Alta usuario</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevoUsuario.xx" method="POST" commandName="usuario" accept-charset="UTF-8">
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
                            <form:label path="" for="nombreUsuario" class="col-sm-1 control-label has-error">Usuario</form:label>
                                <div class="col-sm-3">
                                <form:input path="nombreUsuario" type="text" class="form-control  has-error" id="nombreUsuario" placeholder="Nombre usuario" />

                            </div>
                            <form:label path="" for="passwordUsuario" class="col-sm-1 control-label">Contrase&ntilde;a</form:label>
                                <div class="col-sm-3">
                                <form:input path="passwordUsuario" type="password" class="form-control" id="passwordUsuario" placeholder="Contraseña" />
                            </div>
                            <form:label path="" class="col-sm-1 control-label">Tipo</form:label>
                                <div class="col-sm-3">
                                <form:select path="tipo" class="form-control ">
                                    <form:option value="1">Administrador</form:option>
                                    <form:option value="2">Coordinador</form:option>
                                </form:select>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-1 col-sm-1">
                                <form:button id="botonUsuario" type="submit" class="btn btn-success">Aceptar</form:button>
                                </div>
                            </div>
                    </form:form>
                </div><!--Fin FormularioUsuario-->
                <!--FormularioCarrera-->
                <div id="formularioCarrera" class="hover">
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
                <div id="formularioEspecialidad" class="hover">
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
                <div id="formularioProfesor" class="hover">
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
                <div id="formularioMateria" class="hover">
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
                                    <button id="b3" type="button" class="btn btn-default" value="3">3</button>
                                    <button id="b4" type="button" class="btn btn-default" value="4">4</button>
                                    <button id="b5" type="button" class="btn btn-default" value="5">5</button>
                                    <button id="b6" type="button" class="btn btn-default" value="6">6</button>
                                    <button id="b7" type="button" class="btn btn-default" value="7">7</button>
                                    <button id="b8" type="button" class="btn btn-default" value="8">8</button>
                                    <button id="b9" type="button" class="btn btn-default" value="9">9</button>
                                </div>
                            </div>
                        <form:hidden path="bloque" class="col-sm-1 control-label" value="-1" id="bloque"></form:hidden>
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
                <div id="formularioPlan" class="hover">
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
                <div id="formularioAula" class="hover">
                    <div class="panel-heading"><h3>Alta Aula</h3></div>
                    <form:form class="form-horizontal" role="form" action="NuevaAula.xx" method="POST" commandName="aula">
                        <div class="form-group">
                            <form:label path="" for="edificio" class="col-sm-2 control-label">Nombre del edificio:</form:label>
                                <div class="col-sm-3">
                                <form:input path="edificio" type="text" class="form-control" id="nombreEdificio" placeholder="Nombre del edificio" />
                                <label class="label label-danger">${errorEdificio}</label>
                            </div>
                            <form:label path="" for="aula" class="col-sm-2 control-label">Nombre del aula</form:label>
                                <div class="col-sm-3">
                                <form:input path="aula" type="text" class="form-control" id="aula" placeholder="Nombre del aula" />
                                <label class="label label-danger">${errorAula}</label>
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
                                <label class="label label-danger">${errorCapacidad}</label>
                                <form:errors path="capacidadAula" cssClass="label-danger"/>
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
                <div id="formularioCicloEscolar" class="hover">
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
                <div id="formularioGrupo" class="hover">
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
                                <div class="col-sm-offset-2 col-sm-2">
                                    <form:button type="submit" class="btn btn-success">Aceptar</form:button>
                                    </div>
                                    <div id="divForzar" class="col-sm-offset-1 col-sm-1">
                                        <div class="input-group">
                                            <span class="input-group-addon">
                                                <label class="text-center">Forzar</label>
                                                <input id="checkForzar" type="checkbox">
                                            </span>
                                        <form:select path="forzarGrupo" id="selectForzar" class="form-control">
                                            <form:option value="T" >Te&oacute;rico</form:option>
                                            <form:option value="P" >Pr&aacute;ctico</form:option>
                                            <form:option value="null" selected="selected">No forzar</form:option>
                                        </form:select>
                                    </div><!-- /input-group -->
                                </div>
                            </div>
                        </form:form>
                    </div><!--Fin formularioGrupos-->
                </div>
                
                ${mensajeInicial}
                
            </div><!-- /#wrapper -->


            <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
            <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
            <script type="text/javascript" src="js/formularios.js"></script>
            <!--<script type="text/javascript" src="js/validaciones.js"></script>-->
    </body>
</html>

