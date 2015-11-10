/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mesa;

import DAO.MYSQL.MYSQLDAOFactory;
import Modelo.Negocio.Mesa;
import Modelo.Negocio.MesaCantidad;
import Modelo.Negocio.MesaCantidadTotal;
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

    @Override
    public List<MesaCantidadTotal> getMesasCantidadVotosRealizadosYTotales() {
        String sql = "SELECT m.numeromesa,"
                + " cast(sum(case when votorealizado = 1 then 1 else 0 end) as signed) as cantidad,"
                + " count(*) as total "
                + "FROM mesa m "
                + "LEFT JOIN votante v1 ON m.numeromesa = v1.numeromesa "
                + "GROUP BY m.numeromesa";
        List<MesaCantidadTotal> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, MesaCantidadTotal.class, null, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<MesaCantidad> getMesasCantidadesVotosTotales() {
        String sql = "select numeromesa, cast(sum(cantidad) as signed) as cantidad from cantidad_votos_por_mesa_candidato"
                + " group by numeromesa";
        List<MesaCantidad> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, MesaCantidad.class, null, MYSQLDAOFactory.getConnection());
        return lista;
    }

}
