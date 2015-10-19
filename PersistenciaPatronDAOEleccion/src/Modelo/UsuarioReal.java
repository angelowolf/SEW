/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author angelo
 */
public class UsuarioReal implements Usuario {

    private int id_usuario;
    private String nick, clave;
    private boolean habilitado;

    public UsuarioReal(int id_usuario, String nick, String clave, boolean habilitado) {
        this.id_usuario = id_usuario;
        this.nick = nick;
        this.clave = clave;
        this.habilitado = habilitado;
    }

    public UsuarioReal() {
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public String getNick() {
        return nick;
    }

    public String getClave() {
        return clave;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    @Override
    public String toString() {
        return "UsuarioReal{" + "id_usuario=" + id_usuario + ", nick=" + nick + ", clave=" + clave + ", habilitado=" + habilitado + '}';
    }

}
