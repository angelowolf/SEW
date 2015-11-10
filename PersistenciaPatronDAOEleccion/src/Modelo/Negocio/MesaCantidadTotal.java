/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

/**
 *
 * @author angelo
 */
public class MesaCantidadTotal {
    private int numeroMesa;
    private long cantidad, total;

    public MesaCantidadTotal() {
    }

    public MesaCantidadTotal(int numeroMesa, long cantidad, long total) {
        this.numeroMesa = numeroMesa;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    
    
}
