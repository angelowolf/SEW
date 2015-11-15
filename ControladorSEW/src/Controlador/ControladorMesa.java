/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.Mesa;
import java.util.List;

/**
 *
 * @author angelo
 */
public class ControladorMesa {

    public static void crear(DAOFactory d, Mesa m) {
        CandidatoDAO candidatoDAO = d.getCandidato();
        MesaDAO mesaDAO = d.getMesaDAO();
        DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO vmcDAO = d.getVotosXMesaXCandidato();
        mesaDAO.insertarMesa(m);
//        Crear en la tabla para los resultados...
        List<Candidato> lista = candidatoDAO.getCandidatos();
        for (Candidato cadaCandidato : lista) {
            vmcDAO.insertar(cadaCandidato.getIdCandidato(), m.getNumeroMesa());
        }
    }

    public static void eliminar(DAOFactory d, int numeroMesa) {
        MesaDAO mesaDAO = d.getMesaDAO();
        DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO vmcDAO = d.getVotosXMesaXCandidato();
        vmcDAO.eliminarNumeroMesa(numeroMesa);
        mesaDAO.eliminarMesa(numeroMesa);
    }
}
