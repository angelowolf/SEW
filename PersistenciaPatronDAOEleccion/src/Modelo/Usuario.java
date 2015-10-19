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
public interface Usuario {

    public void setId_usuario(int id_usuario);

    public void setNick(String nick);

    public void setClave(String clave);

    public void setHabilitado(boolean habilitado);

    public int getId_usuario();

    public String getNick();

    public String getClave();

    public boolean isHabilitado();
}
