
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="form-group">
    <fieldset>
        <legend>
            Marcar Partido-Mesa  <s:property value="mesa" />
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
                        Pertenece Al Partido
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
                            <s:if test="%{#cadaVotante.pertenecePartido}">
                                <INPUT type=checkbox id="<s:property value="#cadaVotante.idVotante"/>" checked onclick="funcion_marcar_partido(this.id)"> Seleccione si pertenece al partido<br>
                            </s:if>
                            <s:else>
                                <INPUT type=checkbox id="<s:property value="#cadaVotante.idVotante"/>" onclick="funcion_marcar_partido(this.id)"> Seleccione si pertenece al partido<br>
                            </s:else>
                        </td>
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>       
        