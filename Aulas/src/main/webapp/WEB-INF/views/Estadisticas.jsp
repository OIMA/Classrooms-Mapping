<%-- 
    Document   : Estadisticas
    Created on : Feb 4, 2014, 9:58:32 AM
    Author     : OIMA
--%>

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
        <!--<link rel="stylesheet" href="css/tablas.css" type="text/css" />-->

    </head>

    <body>
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
                        <li class="active"><a href="#"><i class="fa fa-dashboard"></i> Estadisticas</a></li>
                        <li><a href="LlenarAula.xx?idAulaString=1"><i class="fa fa-bar-chart-o"></i> Llenar aula</a></li>
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

            <div id="page-wrapper">
                <h1>Estad&iacute;sticas!</h1>
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="row clearfix">
                                <div class="col-md-7 column">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Análisis de disponibilidad de Aulas 
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            ${listaBarrasPorAula}
                                        </div>
                                        <div class="panel-footer">
                                            Esta lista te muestra el porcentaje en el que están llenas las aulas
                                        </div>
                                    </div>




                                </div>
                                <div class="col-md-4 column">
                                    <h3>
                                        Información relevante
                                    </h3>
                                    <table class="table table-condensed table-striped">
                                        <thead>
                                            <tr>
                                                <th>
                                                    #
                                                </th>
                                                <th>
                                                    Dato
                                                </th>
                                                <th>
                                                    Cantidad
                                                </th>
                                                <th>
                                                    Boton
                                                </th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <tr>
                                                <td>
                                                    1
                                                </td>
                                                <td>
                                                    Grupos sin aula
                                                </td>
                                                <td>
                                                    85
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-xs btn-default">Ver</button>
                                                </td>
                                            </tr>
                                            <tr class="active">
                                                <td>
                                                    2
                                                </td>
                                                <td>
                                                    Numero de materias
                                                </td>
                                                <td>
                                                    50
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-xs btn-default">Ver</button>
                                                </td>
                                            </tr>
                                            <tr class="success">
                                                <td>
                                                    3
                                                </td>
                                                <td>
                                                    Numero total de grupos
                                                </td>
                                                <td>
                                                    123
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-xs btn-default">Ver</button>
                                                </td>
                                            </tr>
                                            <tr class="warning">
                                                <td>
                                                    4
                                                </td>
                                                <td>
                                                    Numero Total de profesores
                                                </td>
                                                <td>
                                                    47
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-xs btn-default">Ver</button>
                                                </td>
                                            </tr>
                                            <tr class="danger">
                                                <td>
                                                    5
                                                </td>
                                                <td>
                                                    Numero de aulas llenas
                                                </td>
                                                <td>
                                                    4
                                                </td>
                                                <td>
                                                    <button type="button" class="btn btn-xs btn-default">ver</button>
                                                </td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div><!-- /#wrapper -->
        
        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/estadisticas.js"></script>
    </body>
</html>
