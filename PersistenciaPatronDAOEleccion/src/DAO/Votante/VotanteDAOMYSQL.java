/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Votante;

import DAO.MYSQL.MYSQLDAOFactory;
import java.util.List;
import Modelo.Cantidad;
import Modelo.Negocio.Votante;

/**
 *
 * @author Angelo
 */
public class VotanteDAOMYSQL implements VotanteDAO {

    @Override
    public boolean actualizarPartido(Votante votante) {
        String sql = "UPDATE votante";
        sql += " SET pertenecePartido = ? WHERE idVotante = ?";
        Object[] parametros = {votante.int_partido(), votante.getIdVotante()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public boolean actualizarVoto(Votante votante) {
        String sql = "UPDATE votante";
        sql += " SET votorealizado = ? WHERE idVotante = ?";
        Object[] parametros = {votante.int_votoRealizado(), votante.getIdVotante()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public List<Votante> getVotantes(int numeroMesa) {
        String sql = "SELECT * from votante where numeroMesa = ?";
        Object[] parametros = {numeroMesa};
        List<Votante> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<Votante> getVotantesSinVotar(int numeroMesa) {
        String sql = "SELECT * FROM votante where votoRealizado = 0 and numeroMesa = ?";
        Object[] parametros = {numeroMesa};
        List<Votante> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<Votante> buscarVotante(String txt_buscar) {
        String temp = "%" + txt_buscar + "%";
        Object[] parametros = {temp};
        List<Votante> lista;
        String sql = "Select * from votante where nombre like ? ";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public long getCantidadSinVotar() {
        Object[] parametros = {};
        List<Cantidad> lista;
        String sql = "Select count(idVotante) as id from votante where votoRealizado = 0 ";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Cantidad.class, parametros, MYSQLDAOFactory.getConnection());
        return lista.get(0).getId();
    }

    @Override
    public long getCantidadVotantes() {
        Object[] parametros = {};
        List<Cantidad> lista;
        String sql = "Select count(idVotante) as id from votante";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Cantidad.class, parametros, MYSQLDAOFactory.getConnection());
        return lista.get(0).getId();
    }

    @Override
    public Votante getVotante(int idVotante) {
        String sql = "Select * from votante where idVotante = ?";
        Object[] parametros = {idVotante};
        List<Votante> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

}
