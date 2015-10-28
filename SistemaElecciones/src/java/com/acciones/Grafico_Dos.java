/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.MesaResultado.MesaResultadoDAO;
import Modelo.Negocio.MesaResultado;
import com.google.gson.Gson;
import com.modelo.Total;
import static com.opensymphony.xwork2.Action.ERROR;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author Angelo
 */
@Results({
    @Result(name = "error", location = "/error.jsp")
})
public class Grafico_Dos extends ActionSupport {
    private static final Logger logger = Logger.getLogger(Grafico_Dos.class);
    DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    MesaResultadoDAO dm = d.getMesaResultadoDAO();
    
    @Override
    @Action(value = "Grafico_Dos")
    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        List<Total> listaTotales = getTotales();
        Gson gson = new Gson();
        String jsonString = gson.toJson(listaTotales);
        try {
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            logger.error("Error al crear gráfico 2.", e);
            return ERROR;
        }
        return null;
    }

    private List<Total> getTotales() {
        List<Total> listaTotales = new ArrayList<Total>();
        
        List<MesaResultado> listaMesa = dm.getResultados();
        
        int cant_a = 0;
        int cant_b = 0;
        int cant_blanco = 0;
        int cant_nulo = 0;
        int cant_oficial = 0;
        
        for (MesaResultado mesa : listaMesa) {
            cant_a += mesa.getCnt_a();
            cant_b += mesa.getCnt_b();
            cant_blanco += mesa.getCnt_blanco();
            cant_nulo += mesa.getCnt_nulo();
            cant_oficial += mesa.getCnt_oficial();
        }
        
        listaTotales.add(new Total(cant_a, "Candidato A"));
        listaTotales.add(new Total(cant_b, "Candidato B"));
        listaTotales.add(new Total(cant_blanco, "Blanco"));
        listaTotales.add(new Total(cant_nulo, "Nulo"));
        listaTotales.add(new Total(cant_oficial, "Candidato Oficial"));
        
        listaTotales.sort(null);
        
        return listaTotales;
    }
}
