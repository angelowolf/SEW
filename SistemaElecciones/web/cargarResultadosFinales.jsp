<%-- 
    Document   : cargarResultadosFinales
    Created on : 04-ago-2014, 18:22:44
    Author     : Angelo
--%>
<%@page import="Modelo.Negocio.Mesa"%>
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
        <title>Carga De Votos</title>
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
        <div class="container" style="padding-top: 60px;"> 
            <div class="form-group col-md-8 col-md-offset-2">
                <s:actionerror theme="bootstrap"/>
                <s:actionmessage theme="bootstrap"/>
                <s:fielderror theme="bootstrap"/>
                <s:form action="cargar_resultados" method="post" validate="true"enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
                    <div class="col-md-4">
                        <s:textfield name="num_mesa" label="Numero Mesa"/>
                    </div>
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <s:iterator value="candidatos" var="cadaCandidato">
                                    <th><s:property value="#cadaCandidato.nombre"/></th>
                                </s:iterator>     
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <s:iterator value="candidatos" var="cadaCandidato">
                                    <td><s:textfield name="%{#cadaCandidato.idCandidato}" value="" /></td>
                                </s:iterator>                               
                            </tr>
                        </tbody>
                    </table>
                    <s:submit value="Cargar" cssClass="btn btn-primary col-md-offset-11"/>
                </s:form>
            </div>
        </div>
    </body>
    <html>