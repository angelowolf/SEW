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
    public boolean actualizarPartido(Votante votante, int mesa) {
        String sql = "UPDATE mesa";
        sql += " SET pertenecePartido = ? WHERE id = ?";
        Object[] parametros = {votante.int_partido(), votante.getId()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public boolean actualizarVoto(Votante votante, int mesa) {
        String sql = "UPDATE mesa";
        sql += " SET votorealizado = ? WHERE id = ?";
        Object[] parametros = {votante.int_votoRealizado(), votante.getId()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public List<Votante> getVotantes(int mesa) {
        String sql = "SELECT * from mesa where mesa = ?";
        Object[] parametros = {mesa};
        List<Votante> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<Votante> getVotantesSinVotar(int mesa) {
        String sql = "SELECT * FROM mesa where votoRealizado = 0 and mesa = ?";
        Object[] parametros = {mesa};
        List<Votante> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<Votante> buscarVotante(String txt_buscar) {
        String temp = "%" + txt_buscar + "%";
        Object[] parametros = {temp};
        List<Votante> lista;
        String sql = "Select * from mesa where nombre like ? ";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Votante.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public long getCantidadSinVotar() {
        Object[] parametros = {};
        List<Cantidad> lista;
        String sql = "Select count(id) as id from mesa where votoRealizado = 0 ";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Cantidad.class, parametros, MYSQLDAOFactory.getConnection());
        return lista.get(0).getId();
    }

    @Override
    public long getCantidadVotantes() {
        Object[] parametros = {};
        List<Cantidad> lista;
        String sql = "Select count(id) as id from mesa";
        lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Cantidad.class, parametros, MYSQLDAOFactory.getConnection());
        return lista.get(0).getId();
    }

}
