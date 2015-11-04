/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author angelo
 */
public class MesaParticipacion {

    private int numeroMesa;
    private long cantidad,total;
    private float participacion;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public float getParticipacion() {
        return participacion;
    }

    public void setParticipacion(float participacion) {
        this.participacion = participacion;
    }

    public void calcular() {
        this.participacion = (this.cantidad * 100) / this.total;
    }

}
