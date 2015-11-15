/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Mesa;

import Modelo.Negocio.Mesa;
import Modelo.Negocio.MesaCantidad;
import Modelo.Negocio.MesaCantidadTotal;
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
    public List<MesaCantidadTotal> getMesasCantidadVotosRealizadosYTotales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MesaCantidad> getMesasCantidadesVotosTotales() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertarMesa(Mesa mesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mesa getMesa(int numeroMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminarMesa(int numeroMesa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
