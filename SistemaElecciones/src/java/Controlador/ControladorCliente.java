/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Cliente.ClienteDAO;
import DAO.DAOFactory;
import DAO.MyException;
import DAO.Usuario.UsuarioDAO;
import Modelo.Negocio.Cliente;
import Modelo.Negocio.Usuario;

/**
 *
 * @author angelo
 */
public class ControladorCliente {

    public static boolean crearCliente(String apellido, String nombre, String email, String nick, String clave) throws MyException {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            ClienteDAO daoCliente = d.getClienteDAO();
            Usuario u = new Usuario(nick, Encriptar.encriptaEnMD5(clave));
            Cliente c = new Cliente(0, nombre, apellido, email, u);
            return daoCliente.insertarCliente(c);
        } catch (MyException e) {
            throw e;
        }
    }

    public static boolean isNickDisponible(String nick) {
        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UsuarioDAO dao = d.getUsuarioDAO();
        Modelo.Negocio.Usuario u = dao.getUsuario(nick);
        return u == null;
    }
}
