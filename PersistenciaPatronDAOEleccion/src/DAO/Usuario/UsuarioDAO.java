/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import java.util.List;
import Modelo.Usuario;

/**
 *
 * @author Angelo
 */
public interface UsuarioDAO {

    public Usuario getUsuario(String nick);

    public Usuario getUsuario(int id_usuario);

    public boolean addUsuario(Usuario u);

    public boolean habilitar(Usuario u);

    public boolean eliminar(Usuario u);

}
