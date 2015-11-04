/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MyException;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.Mesa;
import Modelo.Negocio.MesaCantidad;
import Modelo.Negocio.VotosXMesaXCandidato;
import com.modelo.MesaParticipacion;
import com.modelo.ResultadoCadaMesa;
import com.modelo.Total;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    private List<Candidato> candidatos;

    private static final Logger logger = Logger.getLogger(ResultadoFinalAction.class);
    private List<Total> totales;
    private List<Mesa> mesas;
    private List<ResultadoCadaMesa> resultadaDeCadaMesa;
    private Map<Integer, MesaParticipacion> mesasParticipaciones;

    @Override
    @Action(value = "/ResultadoFinal")

    public String execute() {
        try {
            resultadaDeCadaMesa = new ArrayList<ResultadoCadaMesa>();
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotosXMesaXCandidatoDAO daoVMC = d.getVotosXMesaXCandidato();
            CandidatoDAO daoCandidato = d.getCandidato();
            MesaDAO daoMesa = d.getMesaDAO();
            mesas = daoMesa.getMesas();
            candidatos = daoCandidato.getCandidatos();
            mesasParticipaciones = new HashMap<Integer, MesaParticipacion>();

            for (Mesa cadaMesa : mesas) {
                List<VotosXMesaXCandidato> votosPorMesa = daoVMC.getResultados(cadaMesa.getNumeroMesa());
                ResultadoCadaMesa rcm = new ResultadoCadaMesa();
                rcm.setNumeroMesa(cadaMesa.getNumeroMesa());
                rcm.setResultado(votosPorMesa);
                resultadaDeCadaMesa.add(rcm);
                //inicializar 
                MesaParticipacion m = new MesaParticipacion();
                m.setNumeroMesa(cadaMesa.getNumeroMesa());
                mesasParticipaciones.put(cadaMesa.getNumeroMesa(), m);
            }

            totales = new ArrayList<Total>();
            for (Candidato cadaCandidato : candidatos) {
                List<VotosXMesaXCandidato> votosPorCandidato = daoVMC.getResultadosPorCandidato(cadaCandidato.getIdCandidato());
                int total = 0;
                for (VotosXMesaXCandidato cadaVotoPorCandidato : votosPorCandidato) {
                    total += cadaVotoPorCandidato.getCantidad();
                }
                Total t = new Total();
                t.setTotal(total);
                totales.add(t);
            }

            List<MesaCantidad> mesasTotales = daoMesa.getMesasCantidadesVotosTotales();
            for (MesaCantidad cadaMesa : mesasTotales) {
                MesaParticipacion m = mesasParticipaciones.get(cadaMesa.getNumeroMesa());
                m.setCantidad(cadaMesa.getCantidad());
            }
            List<MesaCantidad> mesasCantidadTotalVotante = daoMesa.getMesasCantidadVotantes();
            for (MesaCantidad cadaMesa : mesasCantidadTotalVotante) {
                MesaParticipacion m = mesasParticipaciones.get(cadaMesa.getNumeroMesa());
                m.setTotal(cadaMesa.getCantidad());
                m.calcular();
            }

//            List<MesaCantidad> mesasCantidadVotosRealizados = daoMesa.getMesasCantidadVotosRealizados();
//            for (MesaCantidad cadaMesa : mesasCantidadVotosRealizados) {
//                MesaParticipacion m = new MesaParticipacion();
//                m.setNumeroMesa(cadaMesa.getNumeroMesa());
//                m.setCantidad(cadaMesa.getCantidad());
//                mesasParticipaciones.put(cadaMesa.getNumeroMesa(), m);
//            }
//            List<MesaCantidad> mesasCantidadTotal = daoMesa.getMesasCantidadVotantes();
//            for (MesaCantidad cadaMesa : mesasCantidadTotal) {
//                MesaParticipacion m = mesasParticipaciones.get(cadaMesa.getNumeroMesa());
//                if (m == null) {
//                    m = new MesaParticipacion();
//                    m.setNumeroMesa(cadaMesa.getNumeroMesa());
//                    m.setTotal(cadaMesa.getCantidad());
//                    m.calcular();
//                    mesasParticipaciones.put(m.getNumeroMesa(), m);
//                } else {
//                    m.setTotal(cadaMesa.getCantidad());
//                    m.calcular();
//                }
//            }
            return SUCCESS;
        } catch (MyException e) {
            logger.error("Error al cargar resultados finales.", e);
            return ERROR;
        }
    }

    public Map<Integer, MesaParticipacion> getMesasParticipaciones() {
        return mesasParticipaciones;
    }

    public List<Candidato> getCandidatos() {
        return candidatos;
    }

    public List<ResultadoCadaMesa> getResultadaDeCadaMesa() {
        return resultadaDeCadaMesa;
    }

    public List<Total> getTotales() {
        return totales;
    }

}
