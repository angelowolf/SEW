<%@page import="Modelo.Negocio.Votante"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<%
    HttpSession sesion = request.getSession();
%>

<div class="form-group">
    <div class="col-md-offset-2 col-md-10">
        <s:form id="form_buscar_votante" action="buscarVotante">
            <div class="form-group">
                <label>Nombre</label>
                <input name="txt_buscar" id="txt_buscar" placeholder="A buscar" type="text" value="<s:property value="txt_buscar" />">
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
                <s:iterator value="votantes" var="cadaVotante"> 
                    <tr>
                        <td>
                            <s:property value="#cadaVotante.nombre"/>
                        </td>
                        <td>
                            <s:property value="#cadaVotante.dni"/>
                        </td>
                        <td>
                            <s:if test="%{#cadaVotante.votoRealizado}">
                                Voto Realizado
                            </s:if>
                            <s:else>
                                Voto Realizado
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>            
    </div>
</div>