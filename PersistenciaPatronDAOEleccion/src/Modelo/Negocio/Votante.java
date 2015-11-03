/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import java.io.Serializable;

/**
 *
 * @author Angelo
 */
public class Votante implements Serializable {

    private int idVotante;
    private String nombre;
    private int dni;
    private boolean votoRealizado;
    private boolean pertenecePartido;
    private int numeroMesa;

    public Votante() {
    }

    @Override
    public String toString() {
        return "Votante{" + "id=" + idVotante + ", nombre=" + nombre + ", dni=" + dni + ", votoRealizado=" + votoRealizado + ", pertenecePartido=" + pertenecePartido + ", mesa=" + numeroMesa + '}';
    }

    public Votante(int idVotante, String nombre, int dni, boolean votoRealizado, boolean pertenecePartido, int numeroMesa) {
        this.idVotante = idVotante;
        this.nombre = nombre;
        this.dni = dni;
        this.votoRealizado = votoRealizado;
        this.pertenecePartido = pertenecePartido;
        this.numeroMesa = numeroMesa;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public boolean isPertenecePartido() {
        return pertenecePartido;
    }

    public void setPertenecePartido(boolean pertenecePartido) {
        this.pertenecePartido = pertenecePartido;
    }

    public int int_partido() {
        if (pertenecePartido) {
            return 1;
        } else {
            return 0;
        }
    }

    public int int_votoRealizado() {
        if (votoRealizado) {
            return 1;
        } else {
            return 0;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public boolean isVotoRealizado() {
        return votoRealizado;
    }

    public void setVotoRealizado(boolean votoRealizado) {
        this.votoRealizado = votoRealizado;
    }

    public void conmutar() {
        votoRealizado = !votoRealizado;
    }

    public void conmutarPartido() {
        pertenecePartido = !pertenecePartido;
    }

    public int getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(int idVotante) {
        this.idVotante = idVotante;
    }
}
