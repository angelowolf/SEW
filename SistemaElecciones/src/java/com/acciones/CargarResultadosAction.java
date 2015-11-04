/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MyException;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.VotosXMesaXCandidato;
import java.util.Map;
import org.apache.log4j.Logger;

import org.apache.struts2.convention.annotation.*;
import org.apache.struts2.interceptor.ParameterAware;

/**
 *
 * @author angelo
 */
@Results({
    @Result(name = "success", type = "redirect", location = "/ResultadoFinal"),
    @Result(name = "input", location = "/cargarResultadosFinales.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class CargarResultadosAction extends ActionSupport implements ParameterAware {

    private DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private static final Logger logger = Logger.getLogger(CargarResultadosAction.class);
    private Map<String, String[]> parametros;
    private int num_mesa;

    @Override
    @Action(value = "/cargar_resultados")
    public String execute() {
        try {

            VotosXMesaXCandidatoDAO dao = d.getVotosXMesaXCandidato();
            VotosXMesaXCandidato mr = new VotosXMesaXCandidato();
            for (Map.Entry<String, String[]> entrySet : parametros.entrySet()) {
                String key = entrySet.getKey();
                String[] value = entrySet.getValue();
                if (key.compareTo("num_mesa") != 0) {
                    int i = Integer.parseInt(value[0]);
                    mr.setCantidad(i);
                    mr.setNumeroMesa(num_mesa);
                    mr.setIdCandidato(Integer.parseInt(key));
                    System.out.println(mr.toString());
                    boolean b = dao.cargarResultados(mr);
                    System.out.println(b);
                }
            }
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al cargar resultados.", e);
            return ERROR;
        }
    }

    @Override
    public void validate() {

        for (Map.Entry<String, String[]> entrySet : parametros.entrySet()) {
            String key = entrySet.getKey();
            String[] value = entrySet.getValue();
            try {
                int i = Integer.parseInt(value[0]);
                if (key.compareTo("num_mesa") == 0) {
                    if (i < 0) {
                        addFieldError("" + key, "Seleccione una mesa.");
                    }
                } else {
                    if (i < 0) {
                        addFieldError("" + key, "El valor ingresado debe ser mayor a 0.");
                    }
                }
            } catch (NumberFormatException e) {
                addFieldError("" + key, "Ingrese un número.");
            } catch (NullPointerException e) {
                System.out.println(e.toString());
                addFieldError("" + key, "Este campo no puede estar vacio.");
            }
        }
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    @Override
    public void setParameters(Map<String, String[]> maps) {
        this.parametros = maps;
    }

    public Map<String, String[]> getParametros() {
        return parametros;
    }

}
