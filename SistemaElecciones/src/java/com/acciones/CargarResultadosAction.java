/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MyException;
import Modelo.Negocio.Candidato;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.VotosXMesaXCandidato;
import java.util.List;
import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.*;

/**
 *
 * @author angelo
 */
@Results({
    @Result(name = "success", type = "redirect", location = "/ResultadoFinal"),
    @Result(name = "input", location = "/cargarResultadosFinales.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class CargarResultadosAction extends ActionSupport {

    private DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private static final Logger logger = Logger.getLogger(CargarResultadosAction.class);
    private int num_mesa;
    private List<Candidato> candidatos;

    @Override
    @Action(value = "/cargar_resultados")
    public String execute() {
        try {

            VotosXMesaXCandidatoDAO dao = d.getVotosXMesaXCandidato();
            VotosXMesaXCandidato mr = new VotosXMesaXCandidato();
            //dao.cargarResultados(mr);
            CandidatoDAO candidatoDAO = d.getCandidato();
            candidatos = candidatoDAO.getCandidatos();
            return INPUT;
        } catch (MyException e) {
            logger.error("Error al cargar resultados.", e);
            return ERROR;
        }
    }

    @Override
    public void validate() {
        CandidatoDAO candidatoDAO = d.getCandidato();
        candidatos = candidatoDAO.getCandidatos();
        if (num_mesa <= 0) {
            addFieldError("num_mesa", "El numero debe ser mayor a 0.");
        }        
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

}
