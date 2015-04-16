<%-- 
    Document   : VisualizarAula
    Created on : Mar 6, 2014, 2:21:10 PM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ver aula</title>
        <link type="text/css" href="css/bootstrap.css" rel="stylesheet"/>
        <link type="text/css" href="css/bootstrap-theme.css" rel="stylesheet"/>
        <link type="text/css" href="css/sb-admin.css" rel="stylesheet"/>
        <link type="text/css" href="css/jquery-ui.css" rel="stylesheet"/>
        <link type="text/css" href="font-awesome/css/font-awesome.min.css" rel="stylesheet"/>
        <link type="text/css" href="css/tablas.css" rel="stylesheet" />

    </head>
    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-6 column">
                            <h1>Hola mundo, esta es una prueba</h1>
                        </div>
                        <div class="col-md-6 column">
                            <p></p>
                        </div>
                    </div>
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div id="tableContainer">
                                ${render}
                            </div>
                            <button id="boton">Descargar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript" src="js/jQuery.js" ></script>
        <script type="text/javascript" src="js/bootstrap.js"></script>
        <!--<script type="text/javascript" src="js/llenarAulas.js"></script>-->
        <script type="text/javascript" src="js/jquery-ui.js"></script>
        <!--<script type="text/javascript" src="js/jsPDF/jspdf.js"></script>-->
        <!--<script type="text/javascript" src="js/jsPDF/jquery/jquery-1.7.1.min.js"></script>-->
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
