/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.MyException;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.Mesa;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
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
    private List<Mesa> mesasTodas;

    @Override
    @Action(value = "/formularioResultado")
    public String execute() {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            CandidatoDAO candidatoDAO = d.getCandidato();
            candidatos = candidatoDAO.getCandidatos();
            MesaDAO mesaDAO = d.getMesaDAO();
            mesasTodas = mesaDAO.getMesas();
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al el formulario de carga resultados.", e);
            return ERROR;
        }
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public List<Mesa> getMesas() {
        return mesasTodas;
    }

}
