/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.VotosXMesaXCandidato;

import DAO.MYSQL.MYSQLDAOFactory;
import DAO.MyException;
import java.util.List;
import Modelo.Negocio.VotosXMesaXCandidato;

/**
 *
 * @author Angelo
 */
public class VotosXMesaXCandidatoMYSQL implements VotosXMesaXCandidatoDAO {

    @Override
    public List<VotosXMesaXCandidato> getResultados() throws MyException {
        String sql = "SELECT * from cantidad_votos_por_mesa_candidato";
        try {
            List<VotosXMesaXCandidato> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, VotosXMesaXCandidato.class, null, MYSQLDAOFactory.getConnection());
            return lista;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public boolean cargarResultados(VotosXMesaXCandidato m) throws MyException {
        String sql = "UPDATE cantidad_votos_por_mesa_candidato SET cantidad = ? WHERE numeroMesa = ? and idCandidato = ? ";
        Object[] parametros = {m.getCantidad(), m.getNumeroMesa(), m.getIdCandidato()};
        try {
            return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public List<VotosXMesaXCandidato> getResultados(int numeroMesa) {
        String sql = "SELECT * from cantidad_votos_por_mesa_candidato where numeroMesa = ?";
        Object[] parametros = {numeroMesa};
        try {
            List<VotosXMesaXCandidato> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, VotosXMesaXCandidato.class, parametros, MYSQLDAOFactory.getConnection());
            return lista;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public List<VotosXMesaXCandidato> getResultadosPorCandidato(int idCandidato) {
        String sql = "SELECT * from cantidad_votos_por_mesa_candidato where idCandidato = ?";
        Object[] parametros = {idCandidato};
        try {
            List<VotosXMesaXCandidato> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, VotosXMesaXCandidato.class, parametros, MYSQLDAOFactory.getConnection());
            return lista;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public void insertar(int idCandidato, int numeroMesa) {
        String sql = "insert into cantidad_votos_por_mesa_candidato(idCandidato, numeroMesa, cantidad) values(?,?,?)";
        Object[] parametros = {idCandidato, numeroMesa, 0};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

    @Override
    public void eliminarNumeroMesa(int numeroMesa) {
        String sql = "delete from cantidad_votos_por_mesa_candidato where numeroMesa = ?";
        Object[] parametros = {numeroMesa};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

    @Override
    public void eliminarIdCandidato(int idCandidato) {
        String sql = "delete from cantidad_votos_por_mesa_candidato where idCandidato = ?";
        Object[] parametros = {idCandidato};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

}
