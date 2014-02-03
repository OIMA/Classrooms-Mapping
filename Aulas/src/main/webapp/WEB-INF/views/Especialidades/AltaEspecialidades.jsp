<%-- 
    Document   : AltaEspecialidades
    Created on : Oct 31, 2013, 12:41:06 PM
    Author     : OIMA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@include file="../../config/configuration.jsp"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta especialidades</title>
    </head>
    <body>
        <div>
            <!--h1>Dar de alta una especialidad ${prueba.nombreEspecialidad}</h1-->
            <form:form method="post" action="guardarEspecialidad.xx" commandName="especialidad">
                <table>
                    <tr>
                        <td>
                            <label for="nombre_especialidad">Nombre especialidad:</label>
                        </td>
                        <td>
                            <form:input path="nombreEspecialidad" type="text" name="nombre_especialidad" id="nombreEspecialidad"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input type="button" class="boton_regresar" value="Regresar"/>
                        </td>
                        <td>
                            <input type="submit" id="botonAltaEspecialidad" value="Insertar"/>
                        </td>
                    </tr>
                </table>
            </form:form>
            <!--
            <c:forEach items="${consEsp}" var="esp">
                ${esp.idEspecialidad}<br/>
                ${esp.nombreEspecialidad}<br/>
            </c:forEach>
            
            ${consEsp2.nombreEspecialidad}-->
        </div>
    </body>
</html>
