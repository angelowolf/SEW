/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.SQLServer;

import DAO.Cliente.ClienteDAO;
import DAO.MesaResultado.MesaResultadoDAO;
import DAO.MotorBD;
import DAO.Usuario.UsuarioDAO;
import DAO.Votante.VotanteDAO;
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
    public MesaResultadoDAO getMesaResultadoDAO() {
        return new DAO.MesaResultado.MesaResultadoDAOSQLServer();
    }

    @Override
    public ClienteDAO getClienteDAO() {
        return new DAO.Cliente.ClienteDAOSQLServer();
    }

}
