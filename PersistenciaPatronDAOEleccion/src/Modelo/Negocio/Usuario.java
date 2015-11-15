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

    private int idUsuario;
    private String nick, clave;
    private boolean habilitado;

    public Usuario(int id_usuario, String nick, String clave, boolean habilitado) {
        this.idUsuario = id_usuario;
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
    public void setIdUsuario(int id_usuario) {
        this.idUsuario = id_usuario;
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
    public int getIdUsuario() {
        return idUsuario;
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
        return "UsuarioReal{" + "id_usuario=" + idUsuario + ", nick=" + nick + ", clave=" + clave + ", habilitado=" + habilitado + '}';
    }

    @Override
    public void conmutar() {
        habilitado = !habilitado;
    }

    @Override
    public int intHabilitado() {
        if (habilitado) {
            return 1;
        } else {
            return 0;
        }
    }

}
