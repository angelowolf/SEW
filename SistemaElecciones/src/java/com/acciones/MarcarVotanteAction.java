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
@Action(value = "MarcarVotante", results = {
    @Result(name = "success", location = "/marcarPartidoVotantes.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class MarcarVotanteAction extends ActionSupport {

    private int mesa;
    private static final Logger logger = Logger.getLogger(MarcarVotanteAction.class);
    private List<Votante> votantes;

    @Override
    public String execute() {
        try {
            DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotanteDAO DAOVotante = d.getVotanteDAO();
            Map<String, Object> sesion = ActionContext.getContext().getSession();
            votantes = DAOVotante.getVotantes(mesa);
            sesion.put("votantes", votantes);
            sesion.put("mesa", mesa);
        } catch (Exception e) {
            logger.error("Error al marcar un voto.", e);
            return ERROR;
        }
        return SUCCESS;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
}
