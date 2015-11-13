<%@taglib uri="/struts-tags" prefix="s"%>
<%@taglib prefix="sb" uri="/struts-bootstrap-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="form-group">
    <s:actionmessage theme="bootstrap"/>
    <fieldset>
        <legend>
            Mesas
        </legend>
    </fieldset>     
    <div class=" col-md-12">
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
</div