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
public interface IUsuario {

    public void setIdUsuario(int id_usuario);

    public void setNick(String nick);

    public void setClave(String clave);

    public void setHabilitado(boolean habilitado);

    public int getIdUsuario();

    public String getNick();

    public String getClave();

    public boolean isHabilitado();

    public String toString();
}
