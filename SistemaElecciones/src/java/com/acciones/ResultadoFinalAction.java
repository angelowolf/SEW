/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.MesaResultado.MesaResultadoDAO;
import DAO.MyException;
import Modelo.Negocio.MesaResultado;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author angelo
 */
@Results({
    @Result(name = "success", location = "/resultadosFinales.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})

public class ResultadoFinalAction extends ActionSupport {

    private int total_oficial, total_a, total_b, total_blanco, total_nulo;
    private static final Logger logger = Logger.getLogger(ResultadoFinalAction.class);
    private List<MesaResultado> resultados;

    @Override
    @Action(value = "/ResultadoFinal")
    public String execute() {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            MesaResultadoDAO dao = d.getMesaResultadoDAO();
            resultados = dao.getResultados();
            for (MesaResultado resultado : resultados) {
                total_oficial += resultado.getCnt_oficial();
                total_a += resultado.getCnt_a();
                total_b += resultado.getCnt_b();
                total_blanco += resultado.getCnt_blanco();
                total_nulo += resultado.getCnt_nulo();
            }
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al cargar resultados finales.", e);
            return ERROR;
        }
    }

    public int getTotal_oficial() {
        return total_oficial;
    }

    public int getTotal_a() {
        return total_a;
    }

    public int getTotal_b() {
        return total_b;
    }

    public int getTotal_blanco() {
        return total_blanco;
    }

    public int getTotal_nulo() {
        return total_nulo;
    }

    public List<MesaResultado> getResultados() {
        return resultados;
    }
}
