package com.modelo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Angelo
 */
public class Resultado {

    public double resultado_escrutado;
    public double resultado_restante;

    public Resultado() {
    }

    public Resultado(double resultado_escrutado, double resultado_total) {
        this.resultado_escrutado = resultado_escrutado;
        this.resultado_restante = resultado_total;
    }

    public double getResultado_escrutado() {
        return resultado_escrutado;
    }

    public void setResultado_escrutado(double resultado_escrutado) {
        this.resultado_escrutado = resultado_escrutado;
    }

    public double getResultado_restante() {
        return resultado_restante;
    }

    public void setResultado_restante(double resultado_restante) {
        this.resultado_restante = resultado_restante;
    }

}
