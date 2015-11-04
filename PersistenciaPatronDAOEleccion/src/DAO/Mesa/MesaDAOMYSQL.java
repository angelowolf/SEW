/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mesa;

import DAO.MYSQL.MYSQLDAOFactory;
import Modelo.Negocio.Mesa;
import Modelo.Negocio.MesaCantidad;
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
    public List<MesaCantidad> getMesasCantidadVotosRealizados() {
        String sql = "select votante.numeroMesa, count(idVotante) as cantidad from votante where votante.votoRealizado = 1 group by votante.numeroMesa";
        List<MesaCantidad> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, MesaCantidad.class, null, MYSQLDAOFactory.getConnection());
        return lista;
    }

    @Override
    public List<MesaCantidad> getMesasCantidadVotantes() {
        String sql = "select votante.numeroMesa, count(idVotante) as cantidad from votante group by votante.numeroMesa";
        List<MesaCantidad> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, MesaCantidad.class, null, MYSQLDAOFactory.getConnection());
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
