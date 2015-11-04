/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mesa;

import Modelo.Negocio.Mesa;
import Modelo.Negocio.MesaCantidad;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class MesaDAOSQLServer implements MesaDAO {

    @Override
    public List<Mesa> getMesas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MesaCantidad> getMesasCantidadVotosRealizados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MesaCantidad> getMesasCantidadVotantes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MesaCantidad> getMesasCantidadesVotosTotales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
