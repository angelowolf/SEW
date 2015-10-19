/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.MYSQL;

import DAO.MyException;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

/**
 *
 * @author Angelo
 */
public class SingletonPoolConnectionMYSQL {

    private static SingletonPoolConnectionMYSQL spc_instancia;
    private BasicDataSource bds;

    public static SingletonPoolConnectionMYSQL getInstancia() throws MyException {
        if (spc_instancia == null) {
            spc_instancia = new SingletonPoolConnectionMYSQL();
        }
        return spc_instancia;
    }

    private SingletonPoolConnectionMYSQL() throws MyException {
        this.crearPool();
    }

    private void crearPool() throws MyException {
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream("C:/datasource_config_MYSQL.properties"));
            bds = BasicDataSourceFactory.createDataSource(propiedades);
        } catch (Exception e) {
            throw new MyException("Error al crear conexion de MYSQL.", e);
        }
    }

    public Connection getConnection() throws MyException {
        try {
            return bds.getConnection();
        } catch (SQLException e) {
            throw new MyException("Error al devolver conexion del pool", e);
        }
    }
}
