/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import Modelo.Negocio.VotosXMesaXCandidato;
import java.util.List;

/**
 *
 * @author Angelo
 */
public class ResultadoCadaMesa {

    int numeroMesa;
    List<VotosXMesaXCandidato> resultado;

    public ResultadoCadaMesa() {
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public List<VotosXMesaXCandidato> getResultado() {
        return resultado;
    }

    public void setResultado(List<VotosXMesaXCandidato> resultado) {
        this.resultado = resultado;
    }

}
