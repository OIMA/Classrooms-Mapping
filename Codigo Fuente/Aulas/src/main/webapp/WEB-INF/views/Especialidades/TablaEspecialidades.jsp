<%-- 
    Document   : TablaEspecialidades
    Created on : Nov 2, 2013, 12:14:45 PM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../../config/configuration.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabla especialidades</title>
    </head>
    <body>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Grupo</th>
                    <th>Materia</th>
                    <th>Aulas</th>
                    <th>Forzado</th>
                    <th>Total horas</th>
                    <th>Por acomodar</th>
                    <th>Forzado</th>
                    <th>Porcentaje</th>
                    <th>%</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Grupo</td>
                    <td>Materia</td>
                    <td>Aulas</td>
                    <td>Forzado</td>
                    <td>Total horas</td>
                    <td>Por acomodar</td>
                    <td>Forzado</td>
                    <td>Porcentaje</td>
                    <td>%</td>
                </tr>
            </tbody>
        </table>
    </body>
    <%@include file="../../config/bootstrapConf.jsp" %>
    <script type="text/javascript" src="js/controlTablas.js"></script>
    <link rel="stylesheet" type="text/css" href="css/tablas.css" />
</html>
