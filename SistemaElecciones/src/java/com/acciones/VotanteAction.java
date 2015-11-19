/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Votante.VotanteDAO;
import Modelo.Negocio.Votante;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author angelo
 */
public class VotanteAction extends ActionSupport {

    DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private static final Logger logger = Logger.getLogger(VotanteAction.class);
    public String txt_buscar;
    public List<Votante> votantes;
    private int mesa;

    public String buscar() {
        try {
            VotanteDAO DAOVotante = d.getVotanteDAO();
            if (txt_buscar != null && !txt_buscar.isEmpty()) {
                votantes = DAOVotante.buscarVotante(txt_buscar);
            }
        } catch (Exception e) {
            logger.error("Error al buscar el votante.", e);
            return ERROR;
        }
        return SUCCESS;
    }

    public String listarVotantesSinVotar() {
        try {
            VotanteDAO DAOVotante = d.getVotanteDAO();
            votantes = DAOVotante.getVotantesSinVotar(mesa);
        } catch (Exception e) {
            logger.error("Error al obtener los votantes sin realizar el voto.", e);
            return ERROR;
        }
        return SUCCESS;
    }

    public String listarVotantes() {
        try {
            VotanteDAO DAOVotante = d.getVotanteDAO();
            votantes = DAOVotante.getVotantes(mesa);
        } catch (Exception e) {
            logger.error("Error al obtener los votantes.", e);
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

    public List<Votante> getVotantes() {
        return votantes;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

}
