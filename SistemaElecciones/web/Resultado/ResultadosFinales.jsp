<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="form-group">
    <div class="col-md-12">
        <s:actionmessage theme="bootstrap"/>
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th>N°Mesa</th>
                        <s:iterator value="candidatos" var="cadaCandidato">
                        <th><s:property value="#cadaCandidato.nombre"/></th>
                        </s:iterator>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="resultadaDeCadaMesa" var="cadaMesa">
                    <tr>
                        <td><s:property value="#cadaMesa.numeroMesa"/></td>
                        <s:iterator value="#cadaMesa.resultado" var="resultado">
                            <td><s:property value="#resultado.cantidad"/></td>    
                        </s:iterator>
                    </tr>
                </s:iterator>
                <tr>
                    <td>Total</td>
                    <s:iterator value="totales" var="cadaTotal">
                        <td><s:property value="#cadaTotal.total"/></td>
                    </s:iterator>
                </tr>
            </tbody>
        </table>
    </div>
    <div class="col-md-9">
        <div id="chartContainer" style="height: 300px; width: 100%;"></div>
    </div>
    <div class="col-md-3">
        <table class="table table-condensed">
            <thead>
                <tr>
                    <th>N°Mesa</th>
                    <th>Participacion</th>
                </tr>
            </thead>
            <tbody>
                <s:iterator value="mesasParticipaciones" var="cadaMesa">
                    <tr>
                        <td><s:property value="#cadaMesa.value.numeroMesa"/></td>
                        <td><s:property value="#cadaMesa.value.participacion"/>%</td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>