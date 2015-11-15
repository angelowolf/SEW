<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<fieldset>
    <legend>
        Formulario Usuario
    </legend>
</fieldset>
<div class="form-group col-md-6 col-md-offset-2">   
    <s:form action="guardarOModificar" validate="true" enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">

        <s:hidden name="cliente.idCliente"/>
        <s:hidden name="cliente.usuario.idUsuario"/>
        <s:textfield name="cliente.nombre" label="Nombre" placeholder="Ingrese el nombre"/>
        <s:textfield name="cliente.apellido" label="Apellido" placeholder="Ingrese el apellido"/>
        <s:textfield name="cliente.email" label="Email"  placeholder="Ingrese el email"/>
        <s:textfield name="cliente.usuario.nick" label="Usuario"  placeholder="Ingrese el nombre de usuario"/>
        <s:textfield name="cliente.usuario.clave" label="Contraseña"  placeholder="Ingrese la contraseña"/>

        <s:submit value="Confirmar" cssClass="btn btn-success col-md-offset-9 col-md-3"/>
    </s:form>
</div>