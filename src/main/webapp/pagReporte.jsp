
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dao.AgenciaViajes,modelo.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reporte del Servicio</h1>
        <%
            String cliente=(String)request.getAttribute("cli");
            String fin=(String)request.getAttribute("fin");
            String ini=(String)request.getAttribute("ini");
            String idcli=(String)request.getAttribute("icli");
            String idtour=(String)request.getAttribute("tour");
            String placa=(String)request.getAttribute("placa");
            String guia=(String)request.getAttribute("guia");
            String desc=(String)request.getAttribute("desc");
        %>
        <h1>Registrar Servicios</h1>
            <input type="text" name="tour" value="<%=idtour%>">
            <input type="text" name="id" value="<%=idcli%>">
            <label>Cliente: </label>
            <input type="text" value="<%=cliente%>" readonly><br>
            <label>Placa del Bus</label>
            <input type="text" value="<%=placa%>" readonly><br>
            <label>Nombre de Guia</label>
            <input type="text" value="<%=guia%>" readonly><br>
            <label>Fecha de Inicio</label>
            <input type="text" value="<%=ini%>" readonly><br>
            <label>Fecha de Finalización</label>
            <input type="text" value="<%=fin%>" readonly><br>
            <label id="tour">Tour</label>
            <input type="text" value="<%=desc%>" readonly>
        <br>
        <label id="pago">Metodo de Pago</label>
        <input type="text" value="<%=%>">
    </body>
</html>
