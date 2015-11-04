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
public interface MesaDAO {

    public List<Mesa> getMesas();

    public List<MesaCantidad> getMesasCantidadVotosRealizados();

    public List<MesaCantidad> getMesasCantidadVotantes();

    public List<MesaCantidad> getMesasCantidadesVotosTotales();
}
