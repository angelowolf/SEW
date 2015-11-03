/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import java.io.Serializable;

/**
 *
 * @author ang_2
 */
public class VotosXMesaXCandidato implements Serializable {

    private int idCandidato, numeroMesa, cantidad;

    public VotosXMesaXCandidato() {
    }

    public VotosXMesaXCandidato(int idCandidato, int numeroMesa, int cantidad) {
        this.idCandidato = idCandidato;
        this.numeroMesa = numeroMesa;
        this.cantidad = cantidad;
    }

    public int getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(int idCandidato) {
        this.idCandidato = idCandidato;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "VotosXMesaXCandidato{" + "idCandidato=" + idCandidato + ", numeroMesa=" + numeroMesa + ", cantidad=" + cantidad + '}';
    }

}
