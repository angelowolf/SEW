<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="form-group" >
    <div class="form-group col-md-12 ">
        <s:form action="cargarResultadoFinales" method="post" validate="true"enctype="multipart/form-data" theme="bootstrap" cssClass="form-horizontal">
            <div class="col-md-4">
                <s:label value="Numero Mesa"/><s:select headerKey="-1" headerValue="Seleccione una mesa" name="num_mesa" list="#application.mesas"/>
            </div>
            <table class="table table-striped">
                <thead>
                    <tr>
                        <s:iterator value="#application.candidatos" var="cadaCandidato">
                            <th><s:property value="#cadaCandidato.nombre"/></th>
                            </s:iterator>     
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <s:iterator value="parametros" var="parametro">
                            <s:if test="%{#parametro.key!='num_mesa'}">
                                <td><s:textfield name="%{#parametro.key}" value="%{#parametro.value[0]}"/></td>
                            </s:if>
                        </s:iterator>                             
                    </tr>
                </tbody>
            </table>
            <s:submit value="Cargar" cssClass="btn btn-primary col-md-offset-11"/>
        </s:form>
    </div>
</div>