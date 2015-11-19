<%@page import="Modelo.Negocio.Usuario"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%><%
    HttpSession sesion = request.getSession();
    Usuario userLogin = (Usuario) sesion.getAttribute("user");

    if (userLogin == null || userLogin.isAdministrador() == false) {
        response.sendRedirect("/SistemaElecciones/index.jsp");
    }
%>

<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Usuarios
        </legend>
    </fieldset>     
    <div class=" col-md-12">
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>
                        IdCliente
                    </th>    
                    <th>
                        Nombre
                    </th>   
                    <th>
                        Apellido
                    </th>    
                    <th>
                        Email
                    </th>    
                    <th>
                        Nick
                    </th>    
                    <th>
                        Administrador
                    </th>
                    <th>
                        Habilitado
                    </th>    
                    <th>
                        Funciones
                    </th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="clienteLista">
                    <tr>
                        <td><s:property value="idCliente"/></td>
                        <td><s:property value="nombre"/></td>
                        <td><s:property value="apellido"/></td>
                        <td><s:property value="email"/></td>
                        <td><s:property value="usuario.nick"/></td>
                        <td><s:property value="usuario.administrador"/></td>
                        <td><s:property value="usuario.habilitado"/></td>     
                        <td>
                            <s:form action="administrador" id="administradorURL" style="display:inline-block;">
                                <s:hidden name="idCliente" value="%{idCliente}"/>
                                <s:submit value="Admin" action="%{administradorURL}" cssClass="btn btn-warning"/>
                            </s:form>
                            <s:form action="habilitar" id="habilitarURL" style="display:inline-block;">
                                <s:hidden name="idCliente" value="%{idCliente}"/>
                                <s:submit value="H/D" action="%{habilitarURL}" cssClass="btn btn-success"/>
                            </s:form>
                            <s:form action="editar" id="editURL" style="display:inline-block;">
                                <s:hidden name="idCliente" value="%{idCliente}"/>
                                <s:submit value="Editar" action="%{editURL}" cssClass="btn btn-info"/>
                            </s:form>

                            <s:form action="eliminar" id="deleteURL" style="display:inline-block;">
                                <s:hidden name="idCliente" value="%{idCliente}"/>
                                <s:submit value="Eliminar" action="%{deleteURL}" cssClass="btn btn-danger"/>
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>  
            </tbody>
        </table>
    </div>
</div