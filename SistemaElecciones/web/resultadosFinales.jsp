<%-- 
    Document   : resultadosFinales
    Created on : 04-ago-2014, 18:22:27
    Author     : Angelo
--%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Negocio.Mesa"%>
<%@page import="Modelo.Negocio.Usuario"%>
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
        <script type="text/javascript" src="js/canvasjs.min.js"></script>
        <script type="text/javascript" src="js/GraficoBarraResultadoFinal.js"></script>
        <title>Carga De Votos</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/stylesMenuDesplegable.css">

    </head>
    <body>        
        <div class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li><a id="mnuResultadoEnVivo" href="resultadosEnVivo.jsp">Resultado En Vivo</a></li>
                    <li><s:url action="ResultadoFinal.action" var="urlRF" ></s:url>
                        <a href="<s:property value="#urlRF" />" >Resultados Finales</a></li>
                    <li><a id="mnuCargarResultadosFinales" href="cargarResultadosFinales.jsp">Cargar Resultados Finales</a></li>                     
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
        <div class="container" style="padding-top: 60px;"> 
            <table class="table table-condensed">
                <thead>
                    <tr>
                        <th>N°Mesa</th>
                        <th>Candidato Oficial</th>
                        <th>Candidato A</th>
                        <th>Candidato B</th>
                        <th>Votos Blancos</th>
                        <th>Votos Nulos</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="resultados" var="cadaResultado">
                        <tr>
                            <td><s:property value="#cadaResultado.num_mesa"/></td>
                            <td><s:property value="#cadaResultado.cnt_oficial"/></td>
                            <td><s:property value="#cadaResultado.cnt_a"/></td>
                            <td><s:property value="#cadaResultado.cnt_b"/></td>
                            <td><s:property value="#cadaResultado.cnt_blanco"/></td>
                            <td><s:property value="#cadaResultado.cnt_nulo"/></td>
                        </tr>
                    </s:iterator>
                    <tr>
                        <td>Total</td>
                        <td><s:property value="total_oficial"/></td>
                        <td><s:property value="total_a"/></td>
                        <td><s:property value="total_b"/></td>
                        <td><s:property value="total_blanco"/></td>
                        <td><s:property value="total_nulo"/></td>
                    </tr>
                </tbody>
            </table>

            <div id="chartContainer" style="height: 300px; width: 100%;"></div>

        </div>
    </div>
</body>
<html>