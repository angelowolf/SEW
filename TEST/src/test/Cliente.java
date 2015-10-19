/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import Modelo.Usuario;
import Modelo.UsuarioProxy;

/**
 *
 * @author angelo
 */
public class Cliente {

    private Usuario usuario;
    private int id_usuario, id_cliente;

    public Cliente() {
        usuario = new UsuarioProxy();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
        usuario.setId_usuario(id_usuario);
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

}
