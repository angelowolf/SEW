/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import Modelo.Negocio.MesaCantidad;
import Modelo.Negocio.MesaCantidadTotal;
import com.google.gson.Gson;
import com.modelo.MesaParticipacion;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author angelo
 */
@Results({
    @Result(name = "error", location = "/error.jsp")
})
public class CargaTablaAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CargaTablaAction.class);

    @Override
    @Action(value = "tabla-participacion")
    public String execute() {
        System.out.println("entra");
        HttpServletResponse response = ServletActionContext.getResponse();
        Map<Integer, MesaParticipacion> mesasParticipaciones = getTotales();
        Gson gson = new Gson();
        List<MesaParticipacion> lista = new ArrayList<MesaParticipacion>(mesasParticipaciones.values());
        String jsonString = gson.toJson(lista);
        try {
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            logger.error("Error al crear tabla-particiapacion.", e);
            return ERROR;
        }
        return null;
    }

    private Map<Integer, MesaParticipacion> getTotales() {
        Map<Integer, MesaParticipacion> mesasParticipaciones = new HashMap<Integer, MesaParticipacion>();
        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        MesaDAO daoMesa = d.getMesaDAO();
        List<MesaCantidadTotal> mesasCantidadVotosRealizados = daoMesa.getMesasCantidadVotosRealizadosYTotales();
        for (MesaCantidadTotal cadaMesa : mesasCantidadVotosRealizados) {
            MesaParticipacion m = new MesaParticipacion();
            m.setNumeroMesa(cadaMesa.getNumeroMesa());
            m.setCantidad(cadaMesa.getCantidad());
            m.setTotal(cadaMesa.getTotal());
            m.calcular();
            mesasParticipaciones.put(cadaMesa.getNumeroMesa(), m);
        }
        return mesasParticipaciones;
    }
}
