/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import DAO.MYSQL.MYSQLDAOFactory;
import Modelo.IUsuario;
import java.util.List;
;
import Modelo.Negocio.Usuario;

/**
 *
 * @author Angelo
 */


public class UsuarioDAOMYSQL implements UsuarioDAO {

    @Override
    public Usuario getUsuario(String nick) {
        String sql = "SELECT * FROM usuario where nick = ?";
        Object[] parametros = {nick};
        List<Usuario> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Usuario.class, parametros, MYSQLDAOFactory.getConnection());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

    @Override
    public int addUsuario(IUsuario u) {
        String sql = "INSERT into usuario(nick,clave,administrador, habilitado) VALUES(?,?,0,0)";
        Object[] parametros = {u.getNick(), u.getClave()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }

    @Override
    public boolean habilitar(IUsuario u) {
        String sql = "UPDATE usuario set habilitado = ? WHERE idUsuario = ?";
        Object[] parametros = {u.intHabilitado(), u.getIdUsuario()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public Usuario getUsuario(int id_usuario) {
        String sql = "SELECT * FROM usuario where idUsuario = ?";
        Object[] parametros = {id_usuario};
        List<Usuario> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, Usuario.class, parametros, MYSQLDAOFactory.getConnection());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }

    @Override
    public boolean eliminar(int idUsuario) {
        String sql = "DELETE FROM usuario where idUsuario = ?";
        Object[] parametros = {idUsuario};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public void modificar(IUsuario u) {
        String sql = "UPDATE usuario set habilitado = ?, nick = ?, clave = ?, administrador = ? WHERE idUsuario = ?";
        Object[] parametros = {u.intHabilitado(), u.getNick(), u.getClass(), u.intAdministrador(), u.getIdUsuario()};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());

    }

    @Override
    public void administrador(IUsuario u) {
        String sql = "UPDATE usuario set administrador = ? WHERE idUsuario = ?";
        Object[] parametros = {u.intAdministrador(), u.getIdUsuario()};
        MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection());
    }
}
