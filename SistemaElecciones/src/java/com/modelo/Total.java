/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

/**
 *
 * @author Angelo
 */
public class Total implements Comparable<Total> {
    private int total;
    private String label;

    public Total(int total, String label) {
        this.total = total;
        this.label = label;
    }
    
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public int compareTo(Total o) {
        if (o.total >= this.total) return -1;
        else return 1;
    }
}
