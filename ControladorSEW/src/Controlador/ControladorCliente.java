package Controlador;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Soporte.Encriptar;
import DAO.Cliente.ClienteDAO;
import DAO.DAOFactory;
import DAO.MyException;
import Modelo.Negocio.Cliente;
import Modelo.Negocio.Usuario;

/**
 *
 * @author angelo
 */
public class ControladorCliente {

    public static boolean crearCliente(DAOFactory d, String apellido, String nombre, String email, String nick, String clave) throws MyException {
        try {
            Usuario u = new Usuario(nick, Encriptar.encriptaEnMD5(clave));
            Cliente c = new Cliente(0, nombre, apellido, email, u);
            return crear(d, c);
        } catch (MyException e) {
            throw e;
        }
    }

    public static boolean crearCliente(DAOFactory d, Cliente c) throws MyException {
        try {
            c.getUsuario().setClave(Soporte.Encriptar.encriptaEnMD5(c.getUsuario().getClave()));
            return crear(d, c);
        } catch (MyException e) {
            throw e;
        }
    }

    private static boolean crear(DAOFactory d, Cliente c) {
        try {
            ClienteDAO daoCliente = d.getClienteDAO();
            return daoCliente.insertarCliente(c);
        } catch (MyException e) {
            throw e;
        }
    }

    public static boolean modificarCliente(DAOFactory d, String apellido, String nombre, String email, String nick, String clave) throws MyException {
        try {
            Usuario u = new Usuario(nick, Encriptar.encriptaEnMD5(clave));
            Cliente c = new Cliente(0, nombre, apellido, email, u);
            return modificar(d, c);
        } catch (MyException e) {
            throw e;
        }
    }

    public static boolean modificarCliente(DAOFactory d, Cliente c) throws MyException {
        try {
            return modificar(d, c);
        } catch (MyException e) {
            throw e;
        }
    }

    private static boolean modificar(DAOFactory d, Cliente c) {
        try {
            ClienteDAO dao = d.getClienteDAO();
            return dao.updateCliente(c);
        } catch (MyException e) {
            throw e;
        }
    }

}
