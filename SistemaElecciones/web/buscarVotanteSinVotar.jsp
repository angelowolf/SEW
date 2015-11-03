<%-- 
    Document   : buscarVotanteSinVotar
    Created on : 04-ago-2014, 18:23:58
    Author     : Angelo
--%>
<%@page import="Modelo.Negocio.Mesa"%>
<%@page import="Modelo.Negocio.Votante"%>
<%@page import="Modelo.Negocio.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="com.modelo.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%
    HttpSession sesion = request.getSession();
    Usuario userLogin = (Usuario) sesion.getAttribute("user");

    if (userLogin == null) {
        response.sendRedirect("/SistemaElecciones/index.jsp");
    }
%>

<!doctype html>
<html lang=''>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <title>Busqueda Votante</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.css">
        <link rel="stylesheet" href="css/stylesMenuDesplegable.css">

    </head>
    <body>        
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li><a id="mnuResultadoEnVivo" href="resultadosEnVivo.jsp">Resultado En Vivo</a></li>
                    <li><s:url action="ResultadoFinal.action" var="urlRF" ></s:url>
                        <a href="<s:property value="#urlRF" />" >Resultados Finales</a></li>
                    <li><s:url action="formularioResultado" var="urlRF" ></s:url>
                        <a href="<s:property value="#urlRF" />" >Cargar Resultados Finales</a></li>
                    <li class='dropdown'>
                        <a class="dropdown-toggle" data-toggle="dropdown" id="mnuCargarVotosRealizados" href="#">Cargar Votos Realizados<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <%
                                List<Mesa> lista = SingletonCantidadMesa.getInstancia().getMesas();
                                for (Mesa m : lista) {
                            %>
                            <li>                                    
                                <s:url action="CargarVotos.action" var="urlTag" >
                                    <s:param name="mesa"><%out.print(m.getNumeroMesa());%></s:param>
                                </s:url>
                                <a href="<s:property value="#urlTag" />" >Mesa <%out.print(m.getNumeroMesa());%></a>
                            </li>
                            <%
                                }%>             
                        </ul>
                    </li>  
                    <li class='dropdown'>
                        <a class="dropdown-toggle" data-toggle="dropdown" id="mnuVotantesSinVotar" href="#">Votantes Sin Votar<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href='buscarVotanteSinVotar.jsp'><span>Buscar</span></a>
                            </li>                            
                            <%
                                for (Mesa m : lista) {%>
                            <li>                                    
                                <s:url action="VotanteSinVotar.action" var="urlTag" >
                                    <s:param name="mesa"><%out.print(m.getNumeroMesa());%></s:param>
                                </s:url>
                                <a href="<s:property value="#urlTag" />" >Mesa <%out.print(m.getNumeroMesa());%></a>
                            </li>
                            <%
                                }%>                               
                        </ul>
                    </li> 
                    <li class='dropdown'>
                        <a class="dropdown-toggle" data-toggle="dropdown" id="mnuMarcarPartidoVotantes" href="#">Marcar Partido Votantes<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <%
                                for (Mesa m : lista) {%>
                            <li>                                    
                                <s:url action="MarcarVotante.action" var="urlTag" >
                                    <s:param name="mesa"><%out.print(m.getNumeroMesa());%></s:param>
                                </s:url>
                                <a href="<s:property value="#urlTag" />" >Mesa <%out.print(m.getNumeroMesa());%></a>
                            </li>
                            <%
                                }%>        
                        </ul>
                    </li> 
                </ul>   
            </div>
        </div>          
        <div class="container form-group" style="padding-top: 60px;"> 
            <div class="col-md-offset-2 col-md-10">
                <s:form id="form_buscar_votante" action="buscar">
                    <div class="form-group">
                        <label>Nombre</label>
                        <input name="txt_buscar" id="txt_buscar" placeholder="A buscar" type="text" value="<%
                            String name = (String) sesion.getAttribute("txt_buscar");
                            if (name != null) {
                                out.print(name);
                            }%>">
                        <input type="submit" class="btn-success btn-sm" value="Buscar">
                    </div>
                </s:form>
            </div>           
            <div class="col-md-11">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>
                                Nombre y Apellido
                            </th>
                            <th >
                                DNI
                            </th>
                            <th>
                                Voto Realizado
                            </th>
                        </tr>
                    </thead>
                    <tbody>                        
                        <%                            List<Votante> lista2 = (List) sesion.getAttribute("votantes_busqueda");
                            if (lista2 != null) {
                                for (Votante votante : lista2) {
                        %>
                        <tr>
                            <td>
                                <%
                                    out.print(votante.getNombre());%>
                            </td>
                            <td>
                                <% out.print(votante.getDni());
                                %>
                            </td>
                            <td>
                                <%
                                    if (votante.isVotoRealizado()) {
                                %>Voto Realizado<%
                                } else {
                                %>Voto No Realizado<%
                                    }%>
                            </td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>            
            </div>
        </div>
    </body>
    <html>
