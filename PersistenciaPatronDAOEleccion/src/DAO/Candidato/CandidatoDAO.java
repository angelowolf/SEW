/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Candidato;

import Modelo.Negocio.Candidato;
import java.util.List;

/**
 *
 * @author Angelo
 */
public interface CandidatoDAO {

    public List<Candidato> getCandidatos();

    public Candidato getCandidato(int idCandidato);

    public void insertarCandidato(Candidato candidato);

    public void modificarCandidato(Candidato candidato);

    public void eliminarCandidato(int studentId);
}
