/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Votante;

import java.util.List;
import Modelo.Negocio.Votante;

/**
 *
 * @author Angelo
 */
public interface VotanteDAO {

    public boolean actualizarPartido(Votante votante, int mesa);

    public boolean actualizarVoto(Votante votante, int mesa);

    public List<Votante> getVotantes(int mesa);

    public List<Votante> getVotantesSinVotar(int mesa);

    public List<Votante> buscarVotante(String txt_buscar);

    public long getCantidadSinVotar();

    public long getCantidadVotantes();
}
