<%-- 
    Document   : candidatos
    Created on : 10/11/2015, 00:01:19
    Author     : angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="display" uri="http://displaytag.sf.net"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.css" type="text/css"/>
        <link rel="stylesheet" href="css/bootstrap.min.css.css" type="text/css"/>
        <script src="js/bootstrap.min.js" type="text/javascript"/>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="content">
            <a href="AltaModificacion.jsp">Nuevo</a>
            <!--            <div class="pagination pagination-right">
                            <a href="#">Primero</a> 
                            <a href="#">Anterior</a>  {0} 
                            <a href="{3}">Siguiente</a> 
                            <a href="{4}">Ultimo</a>
                        </div>
            
                        <div class="pagination pagination-right">
            
                            <ul>
                                <li class="active"><a href="#">Primero</a></li> 
                                <li class="active"><a href="#">Anterior</a></li> {0} 
                                <li><a href="{3}">Siguiente</a></li>
                                <li><a href="{4}">Ultimo</a></li>
                            </ul>
                        </div>-->
      
            <table class="table">
                <tr>
                    <th>id</th>
                    <th>nombre</th>                    
                </tr>
                <s:iterator value="candidatoLista" status="candidatoStatus">
                    <tr>
                        <td><s:property value="idCandidato"/></td>
                    <dt><s:property value="nombre"/></td>
                    <td>
                        <s:url id="editURL" action="editarCandidato">
                            <s:param name="idCandidato" value="%{idCandidato}"/>
                        </s:url>
                        <s:a href="%{editURL}">Editar</s:a>
                        </td>
                        <td>
                        <s:url id="deleteURL" action="eliminarCandidato">
                            <s:param name="idCandidato" value="%{idCandidato}"/>
                        </s:url>
                        <s:a href="%{deleteURL}">Eliminar</s:a>
                        </td>
                        </tr>
                </s:iterator>                            
            </table>


        </div>
    </body>
</html>
