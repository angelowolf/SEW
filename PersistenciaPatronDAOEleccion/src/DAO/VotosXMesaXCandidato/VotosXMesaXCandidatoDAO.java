/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.VotosXMesaXCandidato;

import java.util.List;
import Modelo.Negocio.VotosXMesaXCandidato;

/**
 *
 * @author Angelo
 */
public interface VotosXMesaXCandidatoDAO {

    public List<VotosXMesaXCandidato> getResultados();

    public boolean cargarResultados(VotosXMesaXCandidato m);

    public List<VotosXMesaXCandidato> getResultados(int numeroMesa);
    
    public List<VotosXMesaXCandidato> getResultadosPorCandidato(int idCandidato);
}
