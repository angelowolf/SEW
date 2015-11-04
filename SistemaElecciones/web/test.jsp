<%-- 
    Document   : test
    Created on : 19-abr-2015, 18:48:52
    Author     : angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html lang=''>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/Chart.min.label.js"></script>
        <script type="text/javascript" src="js/ScriptTorta.js"></script>
    </head>
    <body>
        
        <s:iterator value="parametros" var="parametro">
        <li><s:property value="#parametro.key" />:<s:property value="#parametro.value[0]" /></li>
        </s:iterator>
    </body>
</html>
