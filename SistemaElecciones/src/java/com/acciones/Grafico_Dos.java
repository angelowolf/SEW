/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.VotosXMesaXCandidato;
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
    VotosXMesaXCandidatoDAO dm = d.getVotosXMesaXCandidato();
    CandidatoDAO daoCandidato = d.getCandidato();
    VotosXMesaXCandidatoDAO daoVMC = d.getVotosXMesaXCandidato();

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
        List<Total> totales = new ArrayList<Total>();
        List<Candidato> candidatos = daoCandidato.getCandidatos();
        for (Candidato cadaCandidato : candidatos) {
            List<VotosXMesaXCandidato> votosPorCandidato = daoVMC.getResultadosPorCandidato(cadaCandidato.getIdCandidato());
            int total = 0;
            for (VotosXMesaXCandidato cadaVotoPorCandidato : votosPorCandidato) {
                total += cadaVotoPorCandidato.getCantidad();
            }
            Total t = new Total();
            t.setTotal(total);
            t.setLabel(cadaCandidato.getNombre());
            totales.add(t);
        }
        totales.sort(null);

        return totales;
    }
}
