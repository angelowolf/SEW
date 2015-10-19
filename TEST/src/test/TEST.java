/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.DAOFactory;
import DAO.Usuario.UsuarioDAO;
import Modelo.Usuario;

/**
 *
 * @author angelo
 */
public class TEST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente c = new Cliente();
        c.setId_cliente(123);
        c.setId_usuario(1);
        Usuario u = c.getUsuario();
        if (u == null) {
            System.out.println("es nulo");
        } else {
            System.out.println("no es nulo");
        }

//        u.getNick();
        System.out.println(u.getNick());
    }

}
