/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.DAOFactory;
import DAO.Usuario.UsuarioDAO;
import Modelo.IUsuario;
import Modelo.Negocio.Cliente;
import Modelo.Negocio.Usuario;

/**
 *
 * @author angelo
 */
public class ControladorUsuario {

    public static boolean isNickDisponible(DAOFactory d, Cliente c) {
        UsuarioDAO dao = d.getUsuarioDAO();
        Modelo.Negocio.Usuario u = dao.getUsuario(c.getUsuario().getNick());
        if (u == null) {
            return true;
        } else {
            if (u.getIdUsuario() == c.getUsuario().getIdUsuario()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNickDisponible(DAOFactory d, String nick) {
        UsuarioDAO dao = d.getUsuarioDAO();
        Modelo.Negocio.Usuario u = dao.getUsuario(nick);
        return u == null;
    }

    public static void eliminar(DAOFactory d, int idUsuario) {
        UsuarioDAO dao = d.getUsuarioDAO();
        dao.eliminar(idUsuario);
    }

    public static void habilitarDeshabilitar(DAOFactory d, IUsuario usuario) {
        usuario.conmutar();
        UsuarioDAO dao = d.getUsuarioDAO();
        dao.habilitar(usuario);
    }

    public static boolean iniciarSesion(DAOFactory d, String username, String password) {
        UsuarioDAO dao = d.getUsuarioDAO();
        Usuario usuario = dao.getUsuario(username);
        String claveMD5 = Soporte.Encriptar.encriptaEnMD5(password);
        return usuario != null && usuario.getNick().equals(username) && usuario.getClave().equals(claveMD5);
    }
}
