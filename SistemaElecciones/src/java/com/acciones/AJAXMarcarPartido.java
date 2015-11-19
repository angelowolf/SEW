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

/**
 *
 * @author Angelo
 */
public class AJAXMarcarPartido extends ActionSupport {

    private static final Logger logger = Logger.getLogger(AJAXMarcarVoto.class);
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

    public int getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(int idVotante) {
        this.idVotante = idVotante;
    }

}
