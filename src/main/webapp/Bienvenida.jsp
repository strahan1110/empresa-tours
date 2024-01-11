<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.*,java.util.*,dao.AgenciaViajes" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            AgenciaViajes obj=new AgenciaViajes();
         %>
         <h2 class="alert-default-info">Lista de Cliente</h2>
         <table class="table table-hover">
             <thead>
             <tr class="bg-dark"><th>Codigo<th>Nombre <th>Apellido
             </thead>    
          <%
            for(Clientes x:obj.lisCliente()){
            out.print("<tr><td>"+x.getId_cli()+"<td>"+x.getNom_clie()+"<td>"+x.getApe_cli()+"<td>");
            %>
            <a href="control?opc=1&cod=<%=x.getId_cli()%>">ver</a>
            <%
              }  
              
          %>  
         </table>
    </body>
</html>
