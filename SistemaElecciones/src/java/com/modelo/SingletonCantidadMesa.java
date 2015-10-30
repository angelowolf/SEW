/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.modelo;

import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import Modelo.Negocio.Mesa;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author a3
 */
public class SingletonCantidadMesa {

    private static SingletonCantidadMesa instancia;
    private List<Mesa> cantidadMesas;

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
        obtenerMesas();
    }

    /**
     * Obtiene las mesas desde la base de datos. Puede lanzar MyException si se
     * produce algun error al intentar obtener las mesas desde la base de datos.
     */
    private void obtenerMesas() {

        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        MesaDAO dao = d.getMesaDAO();
        this.cantidadMesas = dao.getMesas();
    }

    /**
     * Constante de cantidad de mesas.
     *
     * @return La cantidad de mesas.
     */
    public List<Mesa> getMesas() {
        return cantidadMesas;
    }

}
