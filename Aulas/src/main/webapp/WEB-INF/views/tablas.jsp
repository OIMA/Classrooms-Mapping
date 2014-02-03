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
                        <li class="active"><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                        <li><a href="Bloques.xx"><i class="fa fa-font"></i> Bloques</a></li>
                        <li><a href="Documentos.xx"><i class="fa fa-desktop"></i> Documentos</a></li>
                        <li><a href="Configuracion.xx"><i class="fa fa-wrench"></i> Configuracion</a></li>
                        <li><a href="Archivos.xx"><i class="fa fa-file"></i> Archivos</a></li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Sesion<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                                <li><a href=""></a></li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Benjamin<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#"><i class="fa fa-user"></i> Perfil</a></li>
                                <li><a href="#"><i class="fa fa-gear"></i> Configuracion</a></li>
                                <li class="divider"></li>
                                <li><a href="#"><i class="fa fa-power-off"></i> Cerrar Sesion</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <div class="btn-toolbar">
                    <div class="btn-group">
                        <button id="botonCarreras" type="button" class="btn btn-danger">Carreras</button>
                        <button id="botonUsuarios" type="button" class="btn btn-danger">Usuarios</button>
                        <button id="botonEspecialidades" type="button" class="btn btn-danger">Especialidades</button>
                        <button id="botonProfesores" type="button" class="btn btn-danger">Profesores</button>
                        <button id="botonMaterias" type="button" class="btn btn-danger">Materias</button>
                        <button id="botonGrupos" type="button" class="btn btn-danger">Grupos</button>
                        <button id="botonPlanes" type="button" class="btn btn-danger">Planes</button>
                        <button id="botonCicloEscolar" type="button" class="btn btn-danger">CicloEscolar</button>
                        <button id="botonAulas" type="button" class="btn btn-danger">Aulas</button>
                    </div>
                    <div class="btn-group">
                        <button id="botonHorarios" type="button" class="btn btn-danger">Horarios</button>
                    </div>
                </div>
                <div id="tablaEspecialidades" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Especialidades</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre especialidad</h4></td>
                            <td><h4>Carrera</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaEspecialidades}" var="e">
                            <tr class="fila">
                                <td class="col-sm-1">${e.idEspecialidad}</td>
                                <td>${e.nombreEspecialidad}</td>
                                <td>${e.idCarrera.nombreCarrera}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${e.idEspecialidad}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${e.idEspecialidad}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaCarreras" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Carreras</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre carrera</h4></td>
                            <td><h4>Administrador </h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaCarreras}" var="c">
                            <tr class="fila">
                                <td class="col-sm-1">${c.idCarrera}</td>
                                <td>${c.nombreCarrera}</td>
                                <td>${c.idUsuario.nombre} ${c.idUsuario.apPat} ${c.idUsuario.apMat}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${c.idCarrera}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${c.idCarrera}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaUsuarios" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Usuarios</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre completo</h4></td>
                            <td><h4>Usuario</h4></td>
                            <td><h4>Contrase&ntilde;a</h4></td>
                            <td><h4>Tipo usuario</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaUsuarios}" var="u">
                            <tr class="fila">
                                <td class="col-sm-1">${u.idUsuario}</td>
                                <td>${u.nombre} ${u.apPat} ${u.apMat}</td>
                                <td>${u.nombreUsuario}</td>
                                <td>${u.passwordUsuario}</td>
                                <td>${u.tipo}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${u.idUsuario}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${u.idUsuario}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaProfesores" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Profesores</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre completo</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaProfesores}" var="p">
                            <tr class="fila">
                                <td class="col-sm-1">${p.idProfesor}</td>
                                <td>${p.nombreProfesor} ${p.apPatProfesor} ${p.apMatProfesor}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${p.idProfesor}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${p.idProfesor}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaPlanes" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Planes </h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre plan</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaPlanes}" var="p">
                            <tr class="fila">
                                <td class="col-sm-1">${p.idPlan}</td>
                                <td>${p.nombrePlan}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${p.idPlan}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${p.idPlan}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaCicloEscolar" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Ciclo Escolar</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Ciclo</h4></td>
                            <td><h4>Fecha inicio</h4></td>
                            <td><h4>Fecha fin</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaCicloEscolar}" var="ce">
                            <tr class="fila">
                                <td class="col-sm-1">${ce.idCicloEscolar}</td>
                                <td>${ce.nombreCicloEscolar}</td>
                                <td>${ce.fechaInicio}</td>
                                <td>${ce.fechaFin}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${ce.idCicloEscolar}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${ce.idCicloEscolar}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaMaterias" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Materias </h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Nombre Materia</h4></td>
                            <td><h4>Nombre Especialidad</h4></td>
                            <td><h4>No_H_pr&aacute;cticas</h4></td>
                            <td><h4>No_H_te&oacute;ricas</h4></td>
                            <td><h4>Bloque</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaMaterias}" var="m">
                            <tr class="fila">
                                <td class="col-sm-1">${m.idMateria}</td>
                                <td>${m.nombreMateria}</td>
                                <td>${m.idEspecialidad.nombreEspecialidad}</td>
                                <td>${m.horasPracticas}</td>
                                <td>${m.horasTeoricas}</td>
                                <td>${m.bloque}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${m.idMateria}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${m.idMateria}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaGrupos" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Grupos</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Clave</h4></td>
                            <td><h4>Materia</h4></td>
                            <td><h4>Profesor</h4></td>
                            <td><h4>Capacidad</h4></td>
                            <td><h4>Plan</h4></td>
                            <td><h4>Ciclo Escolar</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaGrupos}" var="g">
                            <tr class="fila">
                                <td class="col-sm-1">${g.idGrupo}</td>
                                <td>${g.claveGrupo}</td>
                                <td>${g.idMateria.nombreMateria}</td>
                                <td>${g.idProfesor.nombreProfesor} ${g.idProfesor.apPatProfesor} ${g.idProfesor.apMatProfesor}</td>
                                <td>${g.capacidadGrupo}</td>
                                <td>${g.idPlan.nombrePlan}</td>
                                <td>${g.idCicloEscolar.nombreCicloEscolar}</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${g.idGrupo}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${g.idGrupo}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaAulas" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Aulas</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Aula</h4></td>
                            <!--<td><h4>Aula</h4></td>-->
                            <td><h4>Tipo_aula</h4></td>
                            <td><h4>Capacidad_aula</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaAulas}" var="a">
                            <tr class="fila">
                                <td class="col-sm-1">${a.idAula}</td>
                                <td>${a.edificio}-${a.aula}</td>
                                <td>${a.tipoAula}</td>
                                <td>${a.capacidadAula}</td>
                                <!--<td>No_H_pr&aacute;cticas</td>-->
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${a.idAula}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${a.idAula}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
                <div id="tablaHorarios" class="panel panel-danger">
                    <div class="panel-heading"><h1>Tabla Horarios</h1></div>
                    <table class="table table-condensed">
                        <tr class="success">
                            <td class="col-sm-1"><h4>Id</h4></td>
                            <td><h4>Grupo</h4></td>
                            <td><h4>Materia</h4></td>
                            <td><h4>Lunes</h4></td>
                            <td><h4>Martes</h4></td>
                            <td><h4>Miercoles</h4></td>
                            <td><h4>Jueves</h4></td>
                            <td><h4>Viernes</h4></td>
                            <td><h4>Eliminar...</h4></td>
                            <td><h4>Editar...</h4></td>
                        </tr>
                        <c:forEach items="${listaHorarios}" var="h">
                            <tr class="fila">
                                <td class="col-sm-1">${h.idHorario}</td>
                                <td>${h.idGrupo}</td>
                                <td>${h.idMateria}</td>
                                <td>7:00--9:00</td>
                                <td>7:00--9:00</td>
                                <td>7:00--9:00</td>
                                <td>7:00--9:00</td>
                                <td>7:00--9:00</td>
                                <td class="col-sm-1"><button class="btn btn-danger delete" idButton="${t.idUsuario}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                                <td class="col-sm-1"><button class="btn btn-warning" idButton="${t.idUsuario}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                            </tr>
                        </c:forEach>
                    </table>    
                </div>
            </div>
        </div><!-- /#wrapper -->

        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <!--<script type="text/javascript" src="js/llenarAulas.js"></script>-->
        <script type="text/javascript" src="js/tablas.js"></script>

    </body>
</html>
