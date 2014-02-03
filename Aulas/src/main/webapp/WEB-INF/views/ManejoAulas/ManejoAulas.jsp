<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Administraci&oacute;n de aulas</title>
    </head>

    <body>
        <div id="mainContainer">
            <!-- Modal -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel">Modal title</h4>
                        </div>
                        <div class="modal-body">
                            ...
                            daghiudasn
                            a duhadf ads
                            af ih
                            adsf aosd
                            vad
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary">Save changes</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->
        </div>

        <div id="tableContainer">
            <table class="table table-responsive table-bordered" id="tablaHorarioAula">
                <tr id="title">
                    <td class="nombreFila" id="horas">Horas</td>
                    <td><span >Lunes</span></td>
                    <td><span>Martes</span></td>
                    <td><span>Mi&eacute;rcoles</span></td>
                    <td><span>Jueves</span></td>
                    <td><span>Viernes</span></td>
                </tr>
                <tr>
                    <td class="nombreFila">7:00 - 8:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">8:00 - 9:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">9:00 - 10:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">10:00 - 11:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">11:00 - 12:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">12:00 - 13:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">13:00 - 14:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">14:00 - 15:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">15:00 - 16:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">16:00 - 17:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">17:00 - 18:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">18:00 - 19:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
                <tr>
                    <td class="nombreFila">20:00 - 21:00</td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                    <td class="editable"></td>
                </tr>
            </table>
        </div>
        <%@include file="../../config/bootstrapConf.jsp" %>
        <link rel="stylesheet" type="text/css" href="css/tablas.css" />
        <script type="text/javascript" src="js/controlTablas.js"></script>
    </body>
</html>