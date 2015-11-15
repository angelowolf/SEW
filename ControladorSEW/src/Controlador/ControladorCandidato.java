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
public class ControladorCandidato {

    public static void crear(DAOFactory d, Candidato c) {
        CandidatoDAO candidatoDAO = d.getCandidato();
        MesaDAO mesaDAO = d.getMesaDAO();
        DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO vmcDAO = d.getVotosXMesaXCandidato();
        int idCandidato = candidatoDAO.insertarCandidato(c);
        c.setIdCandidato(idCandidato);
//        Crear en la tabla para los resultados...
        List<Mesa> lista = mesaDAO.getMesas();
        for (Mesa cadaMesa : lista) {
            vmcDAO.insertar(c.getIdCandidato(), cadaMesa.getNumeroMesa());
        }
    }

    public static void eliminar(DAOFactory d, int idCandidato) {
        CandidatoDAO candidatoDAO = d.getCandidato();
        DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO vmcDAO = d.getVotosXMesaXCandidato();
        vmcDAO.eliminarIdCandidato(idCandidato);
        candidatoDAO.eliminarCandidato(idCandidato);
    }
}
