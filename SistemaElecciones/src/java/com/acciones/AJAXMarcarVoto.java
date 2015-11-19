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
public class AJAXMarcarVoto extends ActionSupport {

    private static final Logger logger = Logger.getLogger(AJAXMarcarVoto.class);
    int idVotante;

    @Override
    public String execute() {
        try {
            DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotanteDAO DAOVotante = d.getVotanteDAO();
            Votante v = DAOVotante.getVotante(idVotante);
            v.conmutar();
            DAOVotante.actualizarVoto(v);
        } catch (Exception e) {
            logger.error("Error al cargar voto de votante.", e);
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
