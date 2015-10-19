/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;

/**
 *
 * @author Angelo
 */
public abstract class MotorBD extends DAOFactory {

    private static final GestorConsultasSQL gestorConsultasSQL = new GestorConsultasSQL();

    public static Connection getConnection() {
        return null;
    }

    public static GestorConsultasSQL getGestorConsultasSQL() {
        return gestorConsultasSQL;
    }
}
