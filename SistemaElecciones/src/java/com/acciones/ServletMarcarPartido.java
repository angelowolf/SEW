/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Votante.VotanteDAO;
import Modelo.Negocio.Votante;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Angelo
 */
@Namespace(value = "/")
@Action(value = "ServletMarcarPartido", results = {
    @Result(name = "success", location = "/marcarPartidoVotantes.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class ServletMarcarPartido extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CargarVotosAction.class);
    int idVotante;

    @Override
    public String execute() {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotanteDAO votanteDAO = d.getVotanteDAO();
            Votante v = votanteDAO.getVotante(idVotante);
            v.conmutarPartido();
            votanteDAO.actualizarPartido(v);
        } catch (Exception e) {
            logger.error("Error al marcar partido.", e);
            return ERROR;
        }
        return null;
    }

    public int getNumeroCheckBox() {
        return idVotante;
    }

    public void setNumeroCheckBox(int numeroCheckBox) {
        this.idVotante = numeroCheckBox;
    }
//    public int getIdVotante() {
//        return idVotante;
//    }
//
//    public void setIdVotante(int idVotante) {
//        this.idVotante = idVotante;
//    }

}
