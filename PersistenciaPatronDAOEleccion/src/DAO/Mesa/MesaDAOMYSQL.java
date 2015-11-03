/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mesa;

import DAO.MYSQL.MYSQLDAOFactory;
import Modelo.Negocio.Mesa;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class MesaDAOMYSQL implements MesaDAO {

    @Override
    public List<Mesa> getMesas() {
        String sql = "SELECT numeroMesa FROM mesa";
        Object[] parametros = {};
        List<Mesa> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Mesa.class, parametros, MYSQLDAOFactory.getConnection());
        return lista;
    }

}
