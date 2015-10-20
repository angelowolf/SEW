/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Votante.VotanteDAO;
import Modelo.Negocio.Votante;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Angelo
 */
@Namespace(value = "/")
@Action(value = "buscar", results = {
    @Result(name = "success", location = "/buscarVotanteSinVotar.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class BuscarAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(BuscarAction.class);
    private String txt_buscar;

    @Override
    public String execute() {
        try {
            DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotanteDAO DAOVotante = d.getVotanteDAO();
            Map<String, Object> sesion = ActionContext.getContext().getSession();
            List<Votante> votantes;
            if (txt_buscar != null && !txt_buscar.isEmpty()) {
                votantes = DAOVotante.buscarVotante(txt_buscar);
                sesion.put("votantes_busqueda", votantes);
                sesion.put("txt_buscar", txt_buscar);
            }
        } catch (Exception e) {
            logger.error("Error al buscar el votante.", e);
            return ERROR;
        }
        return SUCCESS;
    }

    public String getTxt_buscar() {
        return txt_buscar;
    }

    public void setTxt_buscar(String txt_buscar) {
        this.txt_buscar = txt_buscar;
    }
}
