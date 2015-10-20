/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MesaResultado;

import DAO.MYSQL.MYSQLDAOFactory;
import DAO.MyException;
import java.util.List;
import Modelo.Negocio.MesaResultado;

/**
 *
 * @author Angelo
 */
public class MesaResultadoDAOMYSQL implements MesaResultadoDAO {

    @Override
    public List<MesaResultado> getResultados() throws MyException {
        String sql = "SELECT * from mesa_resultado";
        Object[] parametros = {};
        try {
            List<MesaResultado> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, MesaResultado.class, parametros, MYSQLDAOFactory.getConnection());
            return lista;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public boolean cargarResultados(MesaResultado m) throws MyException {
        String sql = "UPDATE mesa_resultado SET cnt_oficial = ?, cnt_a = ?, cnt_b = ?, cnt_blanco = ?, cnt_nulo = ? WHERE num_mesa = ? ";
        Object[] parametros = {m.getCnt_oficial(), m.getCnt_a(), m.getCnt_b(), m.getCnt_blanco(), m.getCnt_nulo(), m.getNum_mesa()};
        try {
            return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
        } catch (MyException e) {
            throw e;
        }
    }

}
