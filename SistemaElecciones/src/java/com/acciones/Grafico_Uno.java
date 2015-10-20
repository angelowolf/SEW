/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.DAOFactory;
import DAO.Votante.VotanteDAO;
import com.modelo.Resultado;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Angelo
 */
@Namespace(value = "/")
@Action(value = "Grafico_Uno", results = {
    @Result(name = "success", location = "/test.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class Grafico_Uno extends ActionSupport {

    private static final Logger logger = Logger.getLogger(CargarVotosAction.class);
    private static final long serialVersionUID = 1L;
    DAO.DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    VotanteDAO DAOVotante = d.getVotanteDAO();

    @Override
    public String execute() {
        HttpServletResponse response = ServletActionContext.getResponse();
        List<Resultado> listaResultados = getResultados();
        Gson gson = new Gson();
        String jsonString = gson.toJson(listaResultados);
        try {
            response.getWriter().write(jsonString);
        } catch (Exception e) {
            logger.error("Error al crear grafico.", e);
            return ERROR;
        }
        return null;
    }

    private List<Resultado> getResultados() {

        List<Resultado> listaResultados = new ArrayList<Resultado>();
        int cantidad_no_voto = (int) DAOVotante.getCantidadSinVotar();
        int cantidad_total = (int) DAOVotante.getCantidadVotantes();

        Resultado resultado = new Resultado();
        resultado.setResultado_restante(cantidad_no_voto);
        resultado.setResultado_escrutado(cantidad_total - cantidad_no_voto);
        listaResultados.add(resultado);

        return listaResultados;
    }
}
