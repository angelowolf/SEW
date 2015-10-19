/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MesaResultado;

import java.util.List;
import Modelo.MesaResultado;

/**
 *
 * @author Angelo
 */
public interface MesaResultadoDAO {

    public List<MesaResultado> getResultados();

    public boolean cargarResultados(MesaResultado m);
}
