/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

/**
 *
 * @author Angelo
 */
public class Candidato {

    private int idCandidato;
    private String nombre;

    public Candidato() {
    }

    public Candidato(int idCandidato, String nombre) {
        this.idCandidato = idCandidato;
        this.nombre = nombre;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
