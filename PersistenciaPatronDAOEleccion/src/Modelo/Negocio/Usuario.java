/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.IUsuario;

/**
 *
 * @author angelo
 */
public class Usuario implements IUsuario {

    private int id_usuario;
    private String nick, clave;
    private boolean habilitado;

    public Usuario(int id_usuario, String nick, String clave, boolean habilitado) {
        this.id_usuario = id_usuario;
        this.nick = nick;
        this.clave = clave;
        this.habilitado = habilitado;
    }

    public Usuario() {
    }

    public Usuario(String nick, String clave) {
        this.nick = nick;
        this.clave = clave;
    }

    @Override
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public void setNick(String nick) {
        this.nick = nick;
    }

    @Override
    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    @Override
    public int getId_usuario() {
        return id_usuario;
    }

    @Override
    public String getNick() {
        return nick;
    }

    @Override
    public String getClave() {
        return clave;
    }

    @Override
    public boolean isHabilitado() {
        return habilitado;
    }

    @Override
    public String toString() {
        return "UsuarioReal{" + "id_usuario=" + id_usuario + ", nick=" + nick + ", clave=" + clave + ", habilitado=" + habilitado + '}';
    }

}
