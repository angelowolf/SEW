/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cliente;

import DAO.MYSQL.MYSQLDAOFactory;
import DAO.MyException;
import Modelo.Negocio.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Angelo
 */
public class ClienteDAOMYSQL implements ClienteDAO {

    @Override
    public Cliente getCliente(int id_cliente) throws MyException {
        Cliente cliente = new Cliente();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            ResultSet filas;
            String sql = "select * from Cliente where id_cliente = ? ";
            Object[] parametros = {id_cliente};
            conexion = MYSQLDAOFactory.getConnection();
            sentencia = conexion.prepareStatement(sql);

            if (parametros != null) {
                for (int i = 1; i < parametros.length + 1; i++) {
                    sentencia.setObject(i, parametros[i - 1]);
                }
            }
            
            filas = sentencia.executeQuery();
            
            while (filas.next()) {
                cliente.setApellido(filas.getString("apellido"));
                cliente.setId_cliente(filas.getInt("id_cliente"));
                cliente.setNombre(filas.getString("nombre"));
                cliente.getUsuario().setId_usuario(filas.getInt("id_usuario"));
            }
            filas.close();
        } catch (SQLException ex) {
            throw new MyException("Error al obtener el Cliente.", ex);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    throw new MyException("Error de SQL.Al cerrar sentencia.", e);
                }
            }
            if (conexion != null) {
                try {
                    conexion.close();
                } catch (SQLException e) {
                    throw new MyException("Error de SQL.Al cerrar conexion.", e);
                }
            }
        }
        return cliente;
    }

}
