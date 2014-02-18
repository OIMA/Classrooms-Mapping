<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : ManejoAulas
    Created on : Jan 16, 2014, 11:24:53 AM
    Author     : OIMA
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="Oscar Ivan Martinez Arce">

        <title>Administraci&oacute;n de aulas</title>

        <link type="text/css" href="css/bootstrap.css" rel="stylesheet">
        <link type="text/css" href="css/bootstrap-theme.css" rel="stylesheet">
        <link type="text/css" href="css/sb-admin.css" rel="stylesheet">
        <link type="text/css" href="css/jquery-ui.css" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="css/tablas.css" type="text/css" />

    </head>

    <body>
        <!--/.modal-->
        <div class="modal fade" id="modalDesocupado" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" status="add">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                        <h4 class="modal-title" id="myModalLabel">Edificio <span id="edificioModal"></span>, Aula <span id="aulaModal"></span></h4>
                        <h5 class="modal-title" id="myModalLabel2"><span id="diaModal"></span>, <span id="horaModal"></span></h5>
                    </div>
                    <div class="modal-body">
                        <h3>Aula <span id="tipoAulaModal"></span></h3>
                        <div class="pull-right col-lg-12 form-group" style="margin-left: 0;">
                            <label class="col-sm-2 control-label ">Materia</label>
                            <div class="col-sm-10">
                                <select class="form-control" id="materiaModal" idMateriaSeleccionada="-1">
                                    <option class="" value="-1" style="background: #DF4444;color: white;">No filtrar por materia</option>
                                    ${listaMaterias}
                                </select>
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">Grupo</label>
                        <div class="col-sm-4">
                            <select class="form-control" id="grupoModal" selectedId="">

                            </select>
                        </div>

                        <div class="btn-toolbar pull-right">
                            <div class="btn-group" id="tipoHorario" tipo="T">
                                <!--<button id="botonTodos" type="button" class="btn btn-success" value="T">Todos</button>-->
                                <button id="botonPracticos" type="button" class="btn btn-success" value="P">Pr&aacute;cticos</button>
                                <button id="botonTeoricos" type="button" class="btn btn-default" value="T">Te&oacute;ricos</button>
                            </div>
                        </div>
                        
                        <div class="form-group row"></div>
                        <table class="table table-striped" id="tablaModal">

                        </table>
                    </div><!--modal-body-->
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal" id="cancelarModal">Cancelar</button>
                        <button type="button" class="btn btn-primary" id="aceptarModal">Aceptar</button>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <div id="wrapper">
            <!-- Sidebar -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                        <span class="sr-only">Menu</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="">Administracion de aulas</a>
                </div>

                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse navbar-ex1-collapse">
                    <ul class="nav navbar-nav side-nav">
                        <li><a href="Estadisticas.xx"><i class="fa fa-dashboard"></i> Estadisticas</a></li>
                        <li class="active"><a href="#"><i class="fa fa-bar-chart-o"></i> Llenar aula</a></li>
                        <li><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                        <li><a href="Bloques.xx"><i class="fa fa-font"></i> Bloques</a></li>
                        <li><a href="Documentos.xx"><i class="fa fa-desktop"></i> Documentos</a></li>
                        <li><a href="Configuracion.xx"><i class="fa fa-wrench"></i> Configuracion</a></li>
                        <li><a href="Archivos.xx"><i class="fa fa-file"></i> Archivos</a></li>
                        <li class="dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-caret-square-o-down"></i> Sesion<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="">Dropdown Item</a></li>
                                <li><a href="">Another Item</a></li>
                                <li><a href="">Third Item</a></li>
                                <li><a href="">Last Item</a></li>
                            </ul>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <!--Usuario-->
                        <li class="dropdown user-dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> OIMA <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#"><i class="fa fa-user"></i> Perfil</a></li>
                                <li><a href="#"><i class="fa fa-gear"></i> Configuracion</a></li>
                                <li class="divider"></li>
                                <li><a href="#"><i class="fa fa-power-off"></i> Cerrar sesi&oacute;n</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper" style="padding:  0 0 0 0;">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-info">
                            <div class="panel-heading">
                                <form class="form-horizontal" role="form">
                                    <div class="form-group">
                                        <label for="edificio" class="col-sm-1 control-label">Edificio</label>
                                        <div class="col-sm-2">
                                            <select class="form-control" id="edificio">
                                                <c:forEach items="${listaAulas}" var="a"><option value="${a.edificio}">${a.edificio}</option></c:forEach>
                                                </select>
                                            </div>
                                            <label for="aula" class="col-sm-1 control-label">Aula</label>
                                            <div class="col-sm-2">
                                                <select class="form-control" id="aula">
                                                </select>
                                            </div>
                                            <!--<span id="idAula" value="1"></span>-->
                                        </div>
                                    </form>
                                </div>
                                <div class="panel-body" style="padding:  0 0 0 0;">
                                    <div id="tableContainer">
                                    ${render}
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!-- /.row -->
            </div>
        </div><!-- /#wrapper -->

        <div id="dialog" title="Seleccione una acción para el grupo 114588" idH="" tipoH="">
            <div class="col-xs-12 text-center">
                <button type="button" class="btn btn-warning" id="cambiarPopup"><span class="glyphicon glyphicon-pencil"></span> Cambiar</button>
                <button type="button" class="btn btn-danger" id="removerPopup"><span class="glyphicon glyphicon-trash"></span> Remover</button>
                <div class="form-group">
                </div>
                <button type="button" class="btn btn-default" id="cancelarPopup"><span class="glyphicon glyphicon-remove"></span> Cancelar</button>
            </div>
        </div>

        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/llenarAulas.js"></script>
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <!--<link rel="stylesheet" href="http://code.jquery.com/ui/1.9.1/themes/base/jquery-ui.css" />-->
        <!--<script src="/resources/demos/external/jquery.bgiframe-2.1.2.js"></script>-->
        <!--<script src="http://code.jquery.com/ui/1.9.1/jquery-ui.js"></script>-->
    </body>
</html>
