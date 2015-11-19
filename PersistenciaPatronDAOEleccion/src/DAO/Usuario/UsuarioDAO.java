/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Usuario;

import Modelo.IUsuario;
import Modelo.Negocio.Usuario;

/**
 *
 * @author Angelo
 */
public interface UsuarioDAO {

    public Usuario getUsuario(String nick);

    public Usuario getUsuario(int id_usuario);

    public int addUsuario(IUsuario u);

    public boolean habilitar(IUsuario u);

    public boolean eliminar(int idUsuario);

    public void modificar(IUsuario u);

    public void administrador(IUsuario u);

}
