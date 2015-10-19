/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import DAO.DAOFactory;
import DAO.Usuario.UsuarioDAO;

/**
 *
 * @author angelo
 */
public class UsuarioProxy implements Usuario {

    private Usuario usuarioReal;
    private int id_usuario;

    private Usuario getSujetoReal() {
        if (usuarioReal == null) {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO dao = d.getUsuarioDAO();
            usuarioReal = dao.getUsuario(id_usuario);
        }
        return usuarioReal;
    }

    @Override
    public String getNick() {
        return getSujetoReal().getNick();
    }

    @Override
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public void setNick(String nick) {
        getSujetoReal().setNick(nick);
    }

    @Override
    public void setClave(String clave) {
        getSujetoReal().setClave(clave);
    }

    @Override
    public void setHabilitado(boolean habilitado) {
        getSujetoReal().setHabilitado(habilitado);
    }

    @Override
    public int getId_usuario() {
        return getSujetoReal().getId_usuario();
    }

    @Override
    public String getClave() {
        return getSujetoReal().getClave();
    }

    @Override
    public boolean isHabilitado() {
        return getSujetoReal().isHabilitado();
    }

}
