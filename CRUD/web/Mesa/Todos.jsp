<%-- 
    Document   : Todos
    Created on : 12/11/2015, 15:50:06
    Author     : angelo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mesas</title>
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css" integrity="sha384-aUGj/X2zp5rLCbBxumKTCw2Z50WgIr1vs/PFN4praOTvYXWlVyh2UtNUU0KAUhAX" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js" integrity="sha512-K1qjQ+NcF2TYO/eI3M6v8EiNYZfA95pQumfvcVrTHtwQVDG+aHRqLi/ETn2uB+1JqwYqVG3LIvdm9lj6imS/pQ==" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="form-group">
            <s:actionmessage theme="bootstrap"/>
            <a href="AltaModificacion.jsp"class="pull-left col-md-offset-10">Nueva Mesa</a>
            <div class=" col-md-10 col-md-offset-1">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                Numero
                            </th>    
                            <th>
                                Funciones
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="mesaLista">
                            <tr>
                                <td><s:property value="numeroMesa"/></td>
                                <td>
                                    <s:form action="eliminar" id="deleteURL">
                                        <s:hidden name="numeroMesa" value="%{numeroMesa}"/>
                                        <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>  
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
