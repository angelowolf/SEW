
<%@taglib uri="/struts-tags" prefix="s" %>
<div class="form-group">
    <fieldset>
        <legend>
            Votantes Sin Votar-Mesa <s:property value="mesa" />
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
                    </tr>
                </s:iterator>
            </tbody>
        </table>
    </div>
</div>  