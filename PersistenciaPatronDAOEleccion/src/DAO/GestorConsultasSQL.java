package DAO;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;

/**
 *
 * @author Angelo Wolf
 * @param <T>
 */
public class GestorConsultasSQL<T> {

    /**
     * Realiza una consulta a la base de datos, y devuelve el resultado de la
     * misma.
     *
     * @param sql Consulta SQL.
     * @param clase Objeto que representa sobre que tratara la consulta.
     * @param parametros Los parametros que puede tener la consulta SQL.
     * @param conexion La conexion a la BD ya iniciada.
     * @return Una lista con los objetos que representen la consulta-
     * @throws MyException
     */
    public List<T> executeQuery(String sql, Class clase, Object[] parametros, Connection conexion) throws MyException {
        List<T> listaDeObjetos = new ArrayList<>();
        PreparedStatement sentencia = null;
        try {
            ResultSet filas;
            sentencia = conexion.prepareStatement(sql);
            if (parametros != null) {
                for (int i = 1; i < parametros.length + 1; i++) {
                    sentencia.setObject(i, parametros[i - 1]);
                }
            }

            filas = sentencia.executeQuery();
            while (filas.next()) {
                T objeto = (T) Class.forName(clase.getName()).newInstance();
                Method[] metodos = objeto.getClass().getDeclaredMethods();
                for (Method metodo : metodos) {
                    if (metodo.getName().startsWith("set")) {
                        metodo.invoke(objeto, filas.getObject(metodo.getName().substring(3)));
                    }
                }
                listaDeObjetos.add(objeto);
            }
            filas.close();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SecurityException | IllegalArgumentException | InvocationTargetException e) {
            throw new MyException("Error al seleccionar registros.", e);
        } catch (SQLNonTransientConnectionException e) {
            throw new MyException("El servidor no esta iniciado.", e);
        } catch (SQLException e) {
            throw new MyException("Error de SQL.", e);
        } finally {
            if (sentencia != null) {
                try {
                    sentencia.close();
                } catch (SQLException e) {
                    throw new MyException("Error de SQL. AL cerrar sentencia", e);
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
        return listaDeObjetos;
    }

    /**
     * Realiza una insercion, modificacion, eliminacion de un registro en la
     * base de datos.
     *
     * @param sql Consulta SQL.
     * @param parametros Los parametros que puede tener la consulta SQL.
     * @param conexion La conexion a la BD ya iniciada.
     * @return 0 para una consulta que no devuelve nada, o la cantidad de filas
     * manipuladas por la consulta.
     * @see PreparedStatement
     * @throws MyException
     */
    public int executeUpdate(String sql, Object[] parametros, Connection conexion) throws MyException {

        int filasAfectadas = 0;
        PreparedStatement sentencia = null;
        try {
            sentencia = conexion.prepareStatement(sql);

            if (parametros != null) {
                for (int i = 1; i < parametros.length + 1; i++) {
                    sentencia.setObject(i, parametros[i - 1]);
                }
            }
            filasAfectadas = sentencia.executeUpdate();
        } catch (SQLException e) {
            throw new MyException("Error de SQL.", e);
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
        return filasAfectadas;
    }
}
