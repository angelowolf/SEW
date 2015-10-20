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

    private int id;
    private String nombre;
    private int dni;
    private boolean votoRealizado;
    private boolean pertenecePartido;
    private int mesa;

    public Votante() {
    }

    @Override
    public String toString() {
        return "Votante{" + "id=" + id + ", nombre=" + nombre + ", dni=" + dni + ", votoRealizado=" + votoRealizado + ", pertenecePartido=" + pertenecePartido + ", mesa=" + mesa + '}';
    }

    public Votante(int id, String nombre, int dni, boolean votoRealizado, boolean pertenecePartido, int mesa) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.votoRealizado = votoRealizado;
        this.pertenecePartido = pertenecePartido;
        this.mesa = mesa;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public boolean isPertenecePartido() {
        return pertenecePartido;
    }

    public void setPertenecePartido(boolean pertenecePartido) {
        this.pertenecePartido = pertenecePartido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if (votoRealizado) {
            votoRealizado = false;
        } else {
            votoRealizado = true;
        }
    }

    public void conmutarPartido() {
        if (pertenecePartido) {
            pertenecePartido = false;
        } else {
            pertenecePartido = true;
        }
    }
}
