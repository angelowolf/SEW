/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Votante.VotanteDAO;
import Modelo.Negocio.Votante;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.log4j.Logger;

/**
 *
 * @author Angelo
 */
@Namespace(value = "/")
@Action(value = "CargarVotos", results = {
    @Result(name = "success", location = "/cargarVotosRealizados.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class CargarVotosAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CargarVotosAction.class);
    private int mesa;
    private List<Votante> votantes;
    private int i;
    DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    VotanteDAO DAOVotante = d.getVotanteDAO();

    @Override
    public String execute() {
        try {
            Map<String, Object> sesion = ActionContext.getContext().getSession();
            votantes = DAOVotante.getVotantes(mesa);
            sesion.put("votantes", votantes);
            sesion.put("mesa", mesa);
        } catch (Exception e) {
            logger.error("Error al cargar los votantes.", e);
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

    public List<Votante> getVotantes() {
        return votantes;
    }

    public void setVotantes(List<Votante> votantes) {
        this.votantes = votantes;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

}