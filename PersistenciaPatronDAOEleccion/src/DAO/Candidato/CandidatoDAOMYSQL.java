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

}
