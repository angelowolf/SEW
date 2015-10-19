/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MYSQL;

import DAO.MesaResultado.MesaResultadoDAO;
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
    public MesaResultadoDAO getMesaResultadoDAO() {
        return new DAO.MesaResultado.MesaResultadoDAOMYSQL();
    }

}
