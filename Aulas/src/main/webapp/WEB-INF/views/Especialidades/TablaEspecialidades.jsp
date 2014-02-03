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
        <h1>Tabla de especialidades</h1>
        <div id="tablaEspecialidades">
            <table class="table table-condensed">
                <tr class="success">
                    <td><h4>Id</h4></td>
                    <td><h4>Nombre especialidad</h4></td>
                    <td><h4>Eliminar...</h4></td>
                    <td><h4>Editar...</h4></td>
                </tr>
                <c:forEach items="${tabla}" var="t">
                    <tr class="fila">
                        <td>${t.idEspecialidad}</td>
                        <td>${t.nombreEspecialidad}</td>
                        <td><button class="btn btn-danger delete" idButton="${t.idEspecialidad}"><span class="glyphicon glyphicon-trash"> Eliminar</span></button></td>
                        <td><button class="btn btn-warning" idButton="${t.idEspecialidad}"><span class="glyphicon glyphicon-edit"> Editar</span></button></td>
                    </tr>
                </c:forEach>
            </table>    
        </div>
    </body>
    <%@include file="../../config/bootstrapConf.jsp" %>
    <script type="text/javascript" src="js/controlTablas.js"></script>
    <link rel="stylesheet" type="text/css" href="css/tablas.css" />
</html>
