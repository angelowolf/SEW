/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DAO.Candidato.CandidatoDAO;
import DAO.Cliente.ClienteDAO;
import DAO.MYSQL.MYSQLDAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.SQLServer.SQLServerDAOFactory;
import DAO.VotosXMesaXCandidato.VotosXMesaXCandidatoDAO;
import DAO.Usuario.UsuarioDAO;
import DAO.Votante.VotanteDAO;

/**
 *
 * @author Angelo
 */
public abstract class DAOFactory {

    public static final int SQLServer = 1;
    public static final int MYSQL = 2;

    public abstract VotanteDAO getVotanteDAO();

    public abstract UsuarioDAO getUsuarioDAO();

    public abstract VotosXMesaXCandidatoDAO getVotosXMesaXCandidato();

    public abstract ClienteDAO getClienteDAO();

    public abstract CandidatoDAO getCandidato();

    public abstract MesaDAO getMesaDAO();

    /**
     * Devuelve una clase concreta de DAOFactory.
     *
     * @param intFactory 1 = SQLServer 2 = MYSQL
     * @return Un objeto de la clase pedida.
     */
    public static DAOFactory getDAOFactory(int intFactory) {

        switch (intFactory) {
            case SQLServer:
                return new SQLServerDAOFactory();
            case MYSQL:
                return new MYSQLDAOFactory();
            default:
                return null;
        }

    }

}
