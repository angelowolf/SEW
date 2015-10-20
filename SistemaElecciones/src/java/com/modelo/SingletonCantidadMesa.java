/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author a3
 */
public class SingletonCantidadMesa {

    private static SingletonCantidadMesa instancia;
    private int cantidadMesas;

    /**
     * Instancia UNICA de la constante "CANTIDAD DE MESAS".
     *
     * @return La instancia de la clase.
     */
    public static SingletonCantidadMesa getInstancia() {
        if (instancia == null) {
            instancia = new SingletonCantidadMesa();
        }
        return instancia;
    }

    /**
     * Constructor PRIVADO de la clase.
     */
    private SingletonCantidadMesa() {
        obtenerCantidad();
    }

    /**
     * Obtiene del archivo "CantidadMesas.txt" la constante de la cantidad de
     * mesas que se utilizara. Puede lanzar FileNotFoundException si el archivo
     * no existe, InputMismatchException si el valor que se encuentra en el
     * archivo no es un numero.
     */
    private void obtenerCantidad() {
        try {
            String fileName = "C:/CantidadMesas.txt";
            File f = new File(fileName);
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                this.cantidadMesas = sc.nextInt();
            }
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe " + e.getMessage() + " " + e.toString());
        } catch (InputMismatchException e) {
            System.out.println("Error al obtener el valor del archivo. El documento no contiene un numero" + " " + e.toString());
        }
    }

    /**
     * Constante de cantidad de mesas.
     *
     * @return La cantidad de mesas.
     */
    public int getCantidadMesas() {
        return cantidadMesas;
    }

}
