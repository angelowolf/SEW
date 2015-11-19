
<%@page import="Modelo.Negocio.Usuario"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    HttpSession sesion = request.getSession();
    Usuario userLogin = (Usuario) sesion.getAttribute("user");

    if (userLogin == null || userLogin.isAdministrador() == false) {
        response.sendRedirect("/SistemaElecciones/index.jsp");
    }
%>
<fieldset>
    <legend>
        Formulario Candidato
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
        <%--<s:push value="candidato">--%>
        <s:hidden name="candidato.idCandidato"/>
        <s:textfield name="candidato.nombre" label="Nombre" placeholder="Ingrese el nombre del candidato" />
        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
        <%--</s:push>--%>            
    </s:form>
</div>