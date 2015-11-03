/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.Candidato.CandidatoDAO;
import DAO.Cliente.*;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.Usuario.UsuarioDAO;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import Modelo.Negocio.Cliente;
import Modelo.IUsuario;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.Mesa;
import Modelo.Negocio.VotosXMesaXCandidato;
import java.time.temporal.Temporal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author angelo
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Candidato> candidatos;
        List<Mesa> mesas;
        List<String> totales;
        List<ResultadoCadaMesa> resultadaDeCadaMesa = new ArrayList<>();
        
        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        VotosXMesaXCandidatoDAO daoVMC = d.getVotosXMesaXCandidato();
        CandidatoDAO daoCandidato = d.getCandidato();
        candidatos = daoCandidato.getCandidatos();

        MesaDAO daoMesa = d.getMesaDAO();
        mesas = daoMesa.getMesas();

        for (Mesa cadaMesa : mesas) {
            List<VotosXMesaXCandidato> votosPorMesa = daoVMC.getResultados(cadaMesa.getNumeroMesa());
            ResultadoCadaMesa rcm = new ResultadoCadaMesa();
            rcm.setNumeroMesa(cadaMesa.getNumeroMesa());
            rcm.setResultado(votosPorMesa);
            resultadaDeCadaMesa.add(rcm);
        }
        
        for (ResultadoCadaMesa resultadaDeCadaMesa1 : resultadaDeCadaMesa) {
            for (VotosXMesaXCandidato vmc2 : resultadaDeCadaMesa1.getResultado()) {
                System.out.println(vmc2.toString());
        }
        }
        
    }

}
