/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MYSQL;

import DAO.Candidato.CandidatoDAO;
import DAO.Cliente.ClienteDAO;
import DAO.Mesa.MesaDAO;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.MotorBD;
import DAO.Usuario.UsuarioDAO;
import DAO.Votante.VotanteDAO;
import java.sql.Connection;

/**
 *
 * @author Angelo
 */
public class MYSQLDAOFactory extends MotorBD {

    public static Connection getConnection() {
        return SingletonPoolConnectionMYSQL.getInstancia().getConnection();
    }

    @Override
    public VotanteDAO getVotanteDAO() {
        return new DAO.Votante.VotanteDAOMYSQL();
    }

    @Override
    public UsuarioDAO getUsuarioDAO() {
        return new DAO.Usuario.UsuarioDAOMYSQL();
    }

    @Override
    public VotosXMesaXCandidatoDAO getVotosXMesaXCandidato() {
        return new DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoMYSQL();
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new DAO.Cliente.ClienteDAOMYSQL();
    }

    @Override
    public MesaDAO getMesaDAO() {
        return new DAO.Mesa.MesaDAOMYSQL();
    }

    @Override
    public CandidatoDAO getCandidato() {
        return new DAO.Candidato.CandidatoDAOMYSQL();
    }

}
