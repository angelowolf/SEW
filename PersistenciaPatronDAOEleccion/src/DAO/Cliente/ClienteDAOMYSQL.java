/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cliente;

import DAO.DAOFactory;
import DAO.MYSQL.MYSQLDAOFactory;
import DAO.MyException;
import Modelo.Negocio.Cliente;
import Modelo.Proxy.UsuarioProxy;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String sql = "select * from Cliente where idCliente = ? ";
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
                cliente.setIdCliente(filas.getInt("idCliente"));
                cliente.setNombre(filas.getString("nombre"));
                cliente.setEmail(filas.getString("email"));
                UsuarioProxy u = new UsuarioProxy();
                u.setIdUsuario(filas.getInt("idUsuario"));
                cliente.setUsuario(u);
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

    @Override
    public boolean updateCliente(Cliente c) {
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, email = ? where idCliente = ?";
        Object[] parametros = {c.getNombre(), c.getApellido(), c.getEmail(), c.getIdCliente()};
        try {
            return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
        } catch (MyException e) {
            throw e;
        }
    }

    @Override
    public boolean insertarCliente(Cliente c) {
        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        DAO.Usuario.UsuarioDAO daoUsuario = d.getUsuarioDAO();
        int fk = daoUsuario.addUsuario(c.getUsuario());
        String sql = "INSERT INTO cliente(nombre,apellido,idusuario,email) values (?,?,?,?)";
        Object[] parametros = {c.getNombre(), c.getApellido(), fk, c.getEmail()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public List<Cliente> getClientes() {
        Cliente cliente;
        List<Cliente> list = new ArrayList<>();
        Connection conexion = null;
        PreparedStatement sentencia = null;
        try {
            ResultSet filas;
            String sql = "select * from Cliente";
            conexion = MYSQLDAOFactory.getConnection();
            sentencia = conexion.prepareStatement(sql);

            filas = sentencia.executeQuery();

            while (filas.next()) {
                cliente = new Cliente();
                cliente.setApellido(filas.getString("apellido"));
                cliente.setIdCliente(filas.getInt("idCliente"));
                cliente.setNombre(filas.getString("nombre"));
                cliente.setEmail(filas.getString("email"));
                UsuarioProxy u = new UsuarioProxy();
                u.setIdUsuario(filas.getInt("idUsuario"));
                cliente.setUsuario(u);
                list.add(cliente);
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
        return list;
    }

    @Override
    public void eliminarCLiente(int idCliente) {
        String sql = "delete from cliente where idCliente = ?";
        Object[] parametros = {idCliente};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }
}
