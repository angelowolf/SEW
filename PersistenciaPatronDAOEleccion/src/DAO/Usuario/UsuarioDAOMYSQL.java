/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import DAO.MYSQL.MYSQLDAOFactory;
import java.util.List;
import Modelo.Usuario;
import Modelo.UsuarioReal;

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
    public boolean addUsuario(Usuario u) {
        String sql = "INSERT into usuario(nick,clave,habilitado) VALUES(?,?,1)";
        Object[] parametros = {u.getNick(), u.getClave()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public boolean habilitar(Usuario u) {
        String sql = "UPDATE usuario set habilitado = 0 WHERE id_usuario = ?";
        Object[] parametros = {u.getId_usuario()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public boolean eliminar(Usuario u) {
        String sql = "DELTE FROM usuario where id_usuario = ?";
        Object[] parametros = {u.getId_usuario()};
        return MYSQLDAOFactory.getGestorConsultasSQL().executeUpdate(sql, parametros, MYSQLDAOFactory.getConnection()) != 0;
    }

    @Override
    public Usuario getUsuario(int id_usuario) {
        String sql = "SELECT * FROM usuario where id_usuario = ?";
        Object[] parametros = {id_usuario};
        List<Usuario> lista = MYSQLDAOFactory.getGestorConsultasSQL().executeQuery(sql, UsuarioReal.class, parametros, MYSQLDAOFactory.getConnection());
        if (!lista.isEmpty()) {
            return lista.get(0);
        }
        return null;
    }
}
