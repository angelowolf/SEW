/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.MyException;
import Modelo.Negocio.Candidato;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Angelo
 */
@Results({
    @Result(name = "success", location = "/cargarResultadosFinales.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class FormularioCargarResultadosAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(FormularioCargarResultadosAction.class);
    private List<Candidato> candidatos;
    private Map<String, String[]> parametros;
    private final Map<String, Object> application = ActionContext.getContext().getApplication();

    @Override
    @Action(value = "/formularioResultado")
    public String execute() {
        try {
            candidatos = (List<Candidato>) application.get("candidatos");
            String s[] = {""};
            parametros = new HashMap<String, String[]>();
            for (Candidato cadaCandidato : candidatos) {
                parametros.put("" + cadaCandidato.getIdCandidato(), s);
            }
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error rediriguir al formulario de carga resultados.", e);
            return ERROR;
        }
    }

    public Map<String, String[]> getParametros() {
        return parametros;
    }
}
