<%-- 
    Document   : Estadisticas
    Created on : Feb 4, 2014, 9:58:32 AM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
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
                        <li><a href="LlenarAula.xx"><i class="fa fa-bar-chart-o"></i> Llenar aula</a></li>
                        <li><a href="Tablas.xx"><i class="fa fa-table"></i> Tablas</a></li>
                        <li><a href="Formularios.xx"><i class="fa fa-edit"></i> Formularios</a></li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right navbar-user">
                        <!--Usuario-->
                        <li class="dropdown user-dropdown">
                            <a href="" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${nombreUsuario} <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="Perfil.xx"><i class="fa fa-user"></i> Perfil</a></li>
                                <li class="divider"></li>
                                <li><a href="<c:url value="/j_spring_security_logout" />"><i class="fa fa-power-off"></i> Cerrar sesi&oacute;n</a></li>
                            </ul>
                        </li><!--Fin de Usuario-->
                    </ul>
                </div><!-- /.navbar-collapse -->
            </nav>

            <div id="page-wrapper">
                <h1 class="">Estad&iacute;sticas.</h1>
                <div class="container">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="col-md-4 column">
                                <h3>
                                    Información relevante
                                </h3>
                                <table class="table table-condensed table-striped">
                                    <thead>
                                        <tr>

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
                                        <tr class="">
                                            <td>
                                                Numero de aulas llenas
                                            </td>
                                            <td>
                                                ${numeroAulasLlenas}
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-xs btn-default" id="botonAulas">ver</button>
                                            </td>
                                        </tr>
                                        <tr class="">
                                            <td>
                                                Numero total de grupos
                                            </td>
                                            <td>
                                                ${numeroGrupos}
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-xs btn-default" id="botonTotalGrupos">Ver</button>
                                            </td>
                                        </tr>
                                        <tr class="">
                                            <td>
                                                Numero de materias
                                            </td>
                                            <td>
                                                ${numeroMaterias}
                                            </td>
                                            <td>
                                                <button type="button" class="btn btn-xs btn-default" id="botonMaterias">Ver</button>
                                            </td>
                                        </tr>
                                        <tr>
                                            <td>
                                                Grupos por acomodar
                                            </td>
                                            <td>
                                                ${numeroGruposSinAula}
                                            </td>
                                            <td>
                                                <!--<button type="button" class="btn btn-xs btn-default" id="botonGruposPorAcomodar">Ver</button>-->
                                            </td>
                                        </tr>
                                        <tr class="">

                                            <td>
                                                Numero Total de profesores
                                            </td>
                                            <td>
                                                ${numeroProfesores}
                                            </td>
                                            <td>
                                                <!--<button type="button" class="btn btn-xs btn-default" id="botonProfesores">Ver</button>-->
                                            </td>
                                        </tr>
                                        <tr class="">

                                            <td>
                                                Grupos acomodados
                                            </td>
                                            <td>
                                                ${numeroGruposAcomodados}
                                            </td>
                                            <td>
                                                <!--<button type="button" class="btn btn-xs btn-default" id="botonGruposAcomodados">ver</button>-->
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="row clearfix">
                                <div class="col-md-7 column" id="totalGrupos">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Ver grupos 
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            <table class="table table-hover">
                                                <thead>
                                                    <tr>
                                                        <th>Grupo</th>
                                                        <th>Materia</th>
                                                        <th>Aulas</th>
                                                        <th>Forzado</th>
                                                        <th>Porcentaje</th>
                                                        <th>%</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${todoGrupos}" var="g">
                                                        <tr>
                                                            <td>${g.clave}</td>
                                                            <td>${g.materia}</td>
                                                            <td>${g.aulas}</td>
                                                            <td>${g.forzado}</td>
                                                            <td><div class="progress">
                                                                    <div class="progress-bar progress-bar-${g.color}" style="width: ${g.porciento}%;">
                                                                    </div>
                                                                </div></td>
                                                            <td>${g.porciento}</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="panel-footer">

                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7 column" id="aulas">
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
                                <div class="col-md-7 column" id="materias">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Aqui van las materias
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            <table class="table table-responsive">
                                                <thead>
                                                    <tr>
                                                        <th>Nombre</th>
                                                        <th>No_grupos</th>
                                                        <th>Porcentaje acomodados</th>
                                                        <th>%</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach items="${listaMaterias}" var="mat">
                                                        <tr>
                                                            <td>${mat.nombre}</td>
                                                            <td>${mat.noGrupos}</td>
                                                            <td><div class="progress">
                                                                    <div class="progress-bar progress-bar-${mat.color}" style="width: ${mat.porcentaje}%;">
                                                                    </div>
                                                                </div></td>
                                                            <td>${mat.porcentaje}%</td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                        <div class="panel-footer">
                                            Esta lista te muestra el porcentaje en el que están llenas las aulas
                                        </div>
                                    </div>
                                </div>
<!--                                <div class="col-md-7 column" id="gruposPorAcomodar">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Aqui van los grupos por acomodar
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            ${listaGruposPorAcomodar}
                                        </div>
                                        <div class="panel-footer">
                                            Esta lista te muestra el porcentaje en el que están llenas las aulas
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7 column" id="gruposAcomodados">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Aqui van los Grupos acomodados
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            ${listaGruposAcomodados}
                                        </div>
                                        <div class="panel-footer">
                                            Esta lista te muestra el porcentaje en el que están llenas las aulas
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-7 column" id="profesores">
                                    <div class="panel panel-default">
                                        <div class="panel-heading">
                                            <h3 class="panel-title">
                                                Aqui van los profesores
                                            </h3>
                                        </div>
                                        <div class="panel-body">
                                            ${listaProfesores}
                                        </div>
                                        <div class="panel-footer">
                                            Esta lista te muestra el porcentaje en el que están llenas las aulas
                                        </div>
                                    </div>
                                </div>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="hiddenDiv"></div>
        </div><!-- /#wrapper -->

        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <script type="text/javascript" src="js/estadisticas.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.standard_fonts_metrics.js"></script> 
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.split_text_to_size.js"></script>               
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.from_html.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.addimage.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.javascript.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.sillysvgrenderer.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.cell.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.PLUGINTEMPLATE.js"></script>
        <script type="text/javascript" src="js/jsPDF/jspdf.plugin.ie_below_9_shim.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/Deflate/deflate.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/Deflate/adler32cs.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/FileSaver.js/FileSaver.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/FileSaver.js/FileSaver.min.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/Blob.js/BlobBuilder.js"></script>
        <script type="text/javascript" src="js/jsPDF/libs/Blob.js/Blob.js"></script>
        <script type="text/javascript" src="js/Reportes.js"></script>
    </body>
</html>
