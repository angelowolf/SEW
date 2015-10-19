/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author ang_2
 */
public class MesaResultado implements Serializable {

    private int id_mesaResultado, cnt_oficial, num_mesa, cnt_a, cnt_b, cnt_blanco, cnt_nulo;

    public int getId_mesaResultado() {
        return id_mesaResultado;
    }

    public void setId_mesaResultado(int id_mesaResultado) {
        this.id_mesaResultado = id_mesaResultado;
    }

    public int getCnt_oficial() {
        return cnt_oficial;
    }

    public void setCnt_oficial(int cnt_oficial) {
        this.cnt_oficial = cnt_oficial;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public int getCnt_a() {
        return cnt_a;
    }

    public void setCnt_a(int cnt_a) {
        this.cnt_a = cnt_a;
    }

    public int getCnt_b() {
        return cnt_b;
    }

    public void setCnt_b(int cnt_b) {
        this.cnt_b = cnt_b;
    }

    public int getCnt_blanco() {
        return cnt_blanco;
    }

    public void setCnt_blanco(int cnt_blanco) {
        this.cnt_blanco = cnt_blanco;
    }

    public int getCnt_nulo() {
        return cnt_nulo;
    }

    public void setCnt_nulo(int cnt_nulo) {
        this.cnt_nulo = cnt_nulo;
    }

    public MesaResultado(int id_mesaResultado, int cnt_oficial, int num_mesa, int cnt_a, int cnt_b, int cnt_blanco, int cnt_nulo) {
        this.id_mesaResultado = id_mesaResultado;
        this.cnt_oficial = cnt_oficial;
        this.num_mesa = num_mesa;
        this.cnt_a = cnt_a;
        this.cnt_b = cnt_b;
        this.cnt_blanco = cnt_blanco;
        this.cnt_nulo = cnt_nulo;
    }

}
