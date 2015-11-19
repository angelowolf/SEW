
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>

<div class="form-group" >
    <fieldset>
        <legend>
            Cargar Voto-Mesa <s:property value="mesa" />
        </legend>       
    </fieldset>
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
                                <INPUT type=checkbox id="<s:property value="#cadaVotante.idVotante"/>" checked onclick="funcion_cargar_voto(this.id)"> Seleccione si voto<br>
                            </s:if>
                            <s:else>
                                <INPUT type=checkbox id="<s:property value="#cadaVotante.idVotante"/>" onclick="funcion_cargar_voto(this.id)"> Seleccione si voto<br>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>