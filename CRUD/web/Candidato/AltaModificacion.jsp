<%-- 
    Document   : candidato
    Created on : 10/11/2015, 01:56:37
    Author     : angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <s:form action="guardarOModificarCandidato">
        <%--<s:push value="candidato">--%>
        <s:hidden name="candidato.idCandidato"/>
        <s:textfield name="candidato.nombre" label="Nombre candidato" />
        <s:submit/>
        <%--</s:push>--%>            
    </s:form>
</body>
</html>
