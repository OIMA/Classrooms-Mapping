<%-- 
    Document   : tablas
    Created on : Jan 23, 2014, 7:45:33 PM
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
        <meta name="author" content="">
        <title>Consultar tablas</title>
        <link rel="stylesheet" href="css/jquery.dataTables.css" type="text/css"/>
        <link rel="stylesheet" href="css/jquery.dataTables_themeroller.css" type="text/css"/>
    </head>

    <body>
        <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="tituloModal">Modal title</h4>
                    </div>
                    <div class="modal-body" id="cuerpoModal">



                    </div>
                    <!--                    <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                                            <button type="button" class="btn btn-primary">Save changes</button>
                                        </div>-->
                </div>
            </div>
        </div>
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
                        <li class="active"><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li class="dropdown user-dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nombreUsuario}<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Perfil.xx"><i class="fa fa-user"></i> Perfil</a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value="/j_spring_security_logout"/>"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <div class="btn-toolbar" id="toolBar">
                    <div class="btn-group">
                        <!--<button id="botonCarreras" type="button" class="btn btn-danger">Carreras</button>-->
                        <!--<button id="botonUsuarios" type="button" class="btn btn-danger">Usuarios</button>-->
                        <button id="botonEspecialidades" type="button" class="btn btn-danger">Especialidades</button>
                        <button id="botonProfesores" type="button" class="btn btn-danger">Profesores</button>
                        <button id="botonMaterias" type="button" class="btn btn-danger">Materias</button>
                        <button id="botonGrupos" type="button" class="btn btn-danger">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-danger">Planes</button>
                        <button id="botonCicloEscolar" type="button" class="btn btn-danger">CicloEscolar</button>
                        <!--<button id="botonAulas" type="button" class="btn btn-danger">Aulas</button>-->
                    </div>
                </div>
                <div id="tablaEspecialidades" class="hover">
                    <div class="panel-heading"><h1>Tabla Especialidades</h1></div>
                    <table class="table table-hover" id="tEspecialidad">
                        <thead>
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre especialidad</h4></td>
                            <td><h4>Carrera</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaEspecialidades}" var="e">
                            <tr class="fila">
                                <td class="col-sm-1">${e.idEspecialidad}</td>
                                <td>${e.nombreEspecialidad}</td>
                                <td>${e.idCarrera.nombreCarrera}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${e.idEspecialidad}" tabla="Especialidad"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${e.idEspecialidad}" tabla="Especialidad"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>
<!--                <div id="tablaCarreras" class="hover">
                    <div class="panel-heading"><h1>Tabla Carreras</h1></div>
                    <table class="table table-condensed" id="tCarrera">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Nombre carrera</h4></th>
                            <th><h4>Administrador </h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaCarreras}" var="c">
                            <tr class="fila">
                                <td class="col-sm-1">${c.idCarrera}</td>
                                <td>${c.nombreCarrera}</td>
                                <td>${c.idUsuario.nombre} ${c.idUsuario.apPat} ${c.idUsuario.apMat}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${c.idCarrera}" tabla="Carrera"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${c.idCarrera}" tabla="Carrera"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>-->
<!--                <div id="tablaUsuarios" class="hover">
                    <div class="panel-heading"><h1>Tabla Usuarios</h1></div>
                    <table class="table table-condensed" id="tUsuario">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Nombre completo</h4></th>
                            <th><h4>Usuario</h4></th>
                            <th><h4>Contrase&ntilde;a</h4></th>
                            <th><h4>Tipo usuario</h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaUsuarios}" var="u">
                            <tr class="fila">
                                <td class="col-sm-1">${u.idUsuario}</td>
                                <td>${u.nombre} ${u.apPat} ${u.apMat}</td>
                                <td>${u.nombreUsuario}</td>
                                <td>${u.passwordUsuario}</td>
                                <td>${u.tipo}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${u.idUsuario}" tabla="Usuario"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${u.idUsuario}"  tabla="Usuario"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>-->
                <div id="tablaProfesores" class="hover">
                    <div class="panel-heading"><h1>Tabla Profesores</h1></div>
                    <table class="table table-hover" id="tProfesor">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Nombre completo</h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaProfesores}" var="p">
                            <tr class="fila">
                                <td class="col-sm-1">${p.idProfesor}</td>
                                <td>${p.nombreProfesor} ${p.apPatProfesor} ${p.apMatProfesor}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${p.idProfesor}" tabla="Profesor"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${p.idProfesor}" tabla="Profesor"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>
                <div id="tablaPlanes" class="hover">
                    <div class="panel-heading"><h1>Tabla Planes </h1></div>
                    <table class="table table-hover" id="tPlan">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Nombre plan</h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaPlanes}" var="p">
                            <tr class="fila">
                                <td class="col-sm-1">${p.idPlan}</td>
                                <td>${p.nombrePlan}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${p.idPlan}" tabla="Plan"><span class="glyphicon glyphicon-trash" > Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${p.idPlan}" tabla="Plan"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>
                <div id="tablaCicloEscolar" class="hover">
                    <div class="panel-heading"><h1>Tabla Ciclo Escolar</h1></div>
                    <table class="table table-hover" id="tCicloEscolar">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Ciclo</h4></th>
                            <th><h4>Fecha inicio</h4></th>
                            <th><h4>Fecha fin</h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaCicloEscolar}" var="ce">
                            <tr class="fila">
                                <td class="col-sm-1">${ce.idCicloEscolar}</td>
                                <td>${ce.nombreCicloEscolar}</td>
                                <td>${ce.fechaInicio}</td>
                                <td>${ce.fechaFin}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${ce.idCicloEscolar}" tabla="CicloEscolar"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${ce.idCicloEscolar}" tabla="CicloEscolar"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>
                <div id="tablaMaterias" class="hover">
                    <div class="panel-heading"><h1>Tabla Materias </h1></div>
                    <table class="table table-hover" id="tMateria">
                        <thead>
                        <tr class="success">
                            <th class="col-sm-1"><h4>Id</h4></th>
                            <th><h4>Nombre Materia</h4></th>
                            <th><h4>Nombre Especialidad</h4></th>
                            <th><h4>No_H_pr&aacute;cticas</h4></th>
                            <th><h4>No_H_te&oacute;ricas</h4></th>
                            <th><h4>Bloque</h4></th>
                            <th><h4>Eliminar...</h4></th>
                            <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaMaterias}" var="m">
                            <tr class="fila">
                                <td class="col-sm-1">${m.idMateria}</td>
                                <td>${m.nombreMateria}</td>
                                <td>${m.idEspecialidad.nombreEspecialidad}</td>
                                <td>${m.horasPracticas}</td>
                                <td>${m.horasTeoricas}</td>
                                <td>${m.bloque}</td>
                                <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${m.idMateria}"  tabla="Materia"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${m.idMateria}"  tabla="Materia"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>    
                </div>
                <div id="tablaGrupos" class="hover">
                    <div class="panel-heading"><h1>Tabla Grupos</h1></div>
                    <table class="table table-hover" id='tGrupo'>
                        <thead>
                            <tr class="success">
                                <th class="col-sm-1"><h4>Id</h4></th>
                        <th><h4>Clave</h4></th>
                        <th><h4>Materia</h4></th>
                        <th><h4>Profesor</h4></th>
                        <th><h4>Capacidad</h4></th>
                        <th><h4>Plan</h4></th>
                        <th><h4>Ciclo Escolar</h4></th>
                        <th><h4>Eliminar...</h4></th>
                        <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaGrupos}" var="g">
                                <tr class="fila">
                                    <td class="col-sm-1">${g.idGrupo}</td>
                                    <td>${g.claveGrupo}</td>
                                    <td>${g.idMateria.nombreMateria}</td>
                                    <td>${g.idProfesor.nombreProfesor} ${g.idProfesor.apPatProfesor} ${g.idProfesor.apMatProfesor}</td>
                                    <td>${g.capacidadGrupo}</td>
                                    <td>${g.idPlan.nombrePlan}</td>
                                    <td>${g.idCicloEscolar.nombreCicloEscolar}</td>
                                    <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${g.idGrupo}" tabla="Grupo"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                    <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${g.idGrupo}" tabla="Grupo"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>    
                </div>
                <div id="tablaAulas" class="hover">
                    <div class="panel-heading"><h1>Tabla Aulas</h1></div>
                    <table class="table table-hover" id="tAula">
                        <thead>
                            <tr class="success">
                                <th class="col-sm-1"><h4>Id</h4></th>
                        <th><h4>Aula</h4></th>
                        <th><h4>Tipo_aula</h4></th>
                        <th><h4>Capacidad_aula</h4></th>
                        <th><h4>Eliminar...</h4></th>
                        <th><h4>Editar...</h4></th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaAulas}" var="a">
                                <tr class="fila">
                                    <td class="col-sm-1">${a.idAula}</td>
                                    <td>${a.edificio}-${a.aula}</td>
                                    <td>${a.tipoAula}</td>
                                    <td>${a.capacidadAula}</td>
                                    <!--<td>No_H_pr&aacute;cticas</td>-->
                                    <td class="col-sm-1"><button class="btn btn-danger deleteButton" idButton="${a.idAula}" tabla="Aula"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                    <td class="col-sm-1"><button class="btn btn-warning editButton" idButton="${a.idAula}" tabla="Aula"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>    
                </div>
            </div>
        </div><!-- /#wrapper -->

        <!--<script type="text/javascript" src="js/jQuery.js" ></script>-->
        <!--<script type="text/javascript" src="js/bootstrap.js"></script>-->
        <!--<script type="text/javascript" src="js/llenarAulas.js"></script>-->
        <script type="text/javascript" src="js/tablas.js"></script>
        <script type="text/javascript" src="js/jquery.dataTables.js"></script>
        <!--<script type="text/javascript" src="js/datepicker.js"></script>-->
    </body>
</html>
