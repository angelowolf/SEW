/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Candidato;

import DAO.MYSQL.MYSQLDAOFactory;
import Modelo.Negocio.Candidato;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class CandidatoDAOMYSQL implements CandidatoDAO {

    @Override
    public List<Candidato> getCandidatos() {
        String sql = "SELECT * FROM candidato";
        List<Candidato> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Candidato.class, null, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public Candidato getCandidato(int idCandidato) {
        String sql = "SELECT * FROM candidato where idCandidato = ?";
        Object[] parametros = {idCandidato};
        List<Candidato> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Candidato.class, parametros, MYSQLDAOFactory.getConnection());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

    @Override
    public int insertarCandidato(Candidato candidato) {
        String sql = "Insert INTO candidato(nombre) values(?)";
        Object[] parametros = {candidato.getNombre()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

    @Override
    public void modificarCandidato(Candidato candidato) {
        String sql = "update candidato set nombre = ? where idCandidato = ?";
        Object[] parametros = {candidato.getNombre(), candidato.getIdCandidato()};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

    @Override
    public void eliminarCandidato(int idCandidato) {
        String sql = "delete from candidato  where idCandidato = ?";
        Object[] parametros = {idCandidato};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

}
