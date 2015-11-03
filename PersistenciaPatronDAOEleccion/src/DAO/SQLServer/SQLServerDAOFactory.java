/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.SQLServer;

import DAO.Candidato.CandidatoDAO;
import DAO.Cliente.ClienteDAO;
import DAO.Mesa.MesaDAO;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MotorBD;
import DAO.Usuario.UsuarioDAO;
import DAO.Votante.VotanteDAO;
import Modelo.Negocio.Candidato;
import java.sql.Connection;

/**
 *
 * @author Angelo
 */
public class SQLServerDAOFactory extends MotorBD {

    public static Connection getConnection() {
        return SingletonPoolConnectionSQLServer.getInstancia().getConnection();
    }

    @Override
    public VotanteDAO getVotanteDAO() {
        return new DAO.Votante.VotanteDAOSQLServer();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new DAO.Usuario.UsuarioDAOSQLServer();
    }

    @Override
    public VotosXMesaXCandidatoDAO getVotosXMesaXCandidato() {
        return new DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoSQLServer();
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new DAO.Cliente.ClienteDAOSQLServer();
    }

    @Override
    public MesaDAO getMesaDAO() {
        return new DAO.Mesa.MesaDAOSQLServer();
    }

    @Override
    public CandidatoDAO getCandidato() {
        return new DAO.Candidato.CandidatoDAOSQLServer();
    }

}
