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
import Modelo.Negocio.MesaCantidadTotal;
import Modelo.Negocio.VotosXMesaXCandidato;
import com.modelo.MesaParticipacion;
import com.modelo.ResultadoCadaMesa;
import com.modelo.Total;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author angelo
 */
public class ResultadoAction extends ActionSupport {

    private List<Candidato> candidatos;
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
     private static final Logger logger = Logger.getLogger(ResultadoAction.class);
    private List<Total> totales;
    private List<Mesa> mesas;
    private List<ResultadoCadaMesa> resultadaDeCadaMesa;
    private Map<Integer, MesaParticipacion> mesasParticipaciones;

    public String resultadoFinal() {
        try {
            resultadaDeCadaMesa = new ArrayList<>();
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            VotosXMesaXCandidatoDAO daoVMC = d.getVotosXMesaXCandidato();
            CandidatoDAO daoCandidato = d.getCandidato();
            MesaDAO daoMesa = d.getMesaDAO();
            mesas = daoMesa.getMesas();
            candidatos = daoCandidato.getCandidatos();
            mesasParticipaciones = new HashMap<>();

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

            totales = new ArrayList<>();
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
            List<MesaCantidadTotal> mesasCantidadTotalVotante = daoMesa.getMesasCantidadVotosRealizadosYTotales();
            for (MesaCantidadTotal cadaMesa : mesasCantidadTotalVotante) {
                MesaParticipacion m = mesasParticipaciones.get(cadaMesa.getNumeroMesa());
                m.setTotal(cadaMesa.getTotal());
                m.calcular();
            }
            String mensaje = (String) sesion.get("mensaje");
            addActionMessage(mensaje);
            sesion.put("mensaje", "");

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
