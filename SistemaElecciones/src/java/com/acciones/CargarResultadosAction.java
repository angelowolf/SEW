/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.MesaResultado.MesaResultadoDAO;
import DAO.MyException;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.MesaResultado;
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

    private static final Logger logger = Logger.getLogger(CargarResultadosAction.class);
    private int num_mesa, cnt_oficial, cnt_blanco, cnt_null, cnt_a, cnt_b;

    @Override
    @Action(value = "/cargar_resultados")
    public String execute() {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            MesaResultadoDAO dao = d.getMesaResultadoDAO();
            MesaResultado mr = new MesaResultado(0, cnt_oficial, num_mesa, cnt_a, cnt_b, cnt_blanco, cnt_null);
            dao.cargarResultados(mr);
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al cargar resultados.", e);
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (num_mesa <= 0) {
            addFieldError("num_mesa", "El numero debe ser mayor a 0.");
        }
        if (cnt_oficial < 0) {
            addFieldError("cnt_oficial", "El numero debe ser mayor a 0.");
        }
        if (cnt_a < 0) {
            addFieldError("cnt_a", "El numero debe ser mayor a 0.");
        }
        if (cnt_b < 0) {
            addFieldError("cnt_b", "El numero debe ser mayor a 0.");
        }
        if (cnt_blanco < 0) {
            addFieldError("cnt_blanco", "El numero debe ser mayor a 0.");
        }
        if (cnt_null < 0) {
            addFieldError("cnt_null", "El numero debe ser mayor a 0.");
        }

    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public void setCnt_oficial(int cnt_oficial) {
        this.cnt_oficial = cnt_oficial;
    }

    public void setCnt_blanco(int cnt_blanco) {
        this.cnt_blanco = cnt_blanco;
    }

    public void setCnt_null(int cnt_null) {
        this.cnt_null = cnt_null;
    }

    public void setCnt_a(int cnt_a) {
        this.cnt_a = cnt_a;
    }

    public void setCnt_b(int cnt_b) {
        this.cnt_b = cnt_b;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public int getCnt_oficial() {
        return cnt_oficial;
    }

    public int getCnt_blanco() {
        return cnt_blanco;
    }

    public int getCnt_null() {
        return cnt_null;
    }

    public int getCnt_a() {
        return cnt_a;
    }

    public int getCnt_b() {
        return cnt_b;
    }

}
