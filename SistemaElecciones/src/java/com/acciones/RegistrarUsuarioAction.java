/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.acciones;

import Controlador.Encriptar;
import DAO.DAOFactory;
import DAO.MyException;
import DAO.Usuario.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.Usuario;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

/**
 *
 * @author angelo
 */
@Results({
    @Result(name = "success", location = "/index.jsp"),
    @Result(name = "input", location = "/RegistrarUsuario.jsp"),
    @Result(name = "error", location = "/error.jsp")
})
public class RegistrarUsuarioAction extends ActionSupport {

    private String nick, clave;

    @Override
    @Action(value = "/registrar_usuario")
    public String execute() {
        try {
            DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
            UsuarioDAO dao = d.getUsuarioDAO();

            Usuario u = new Usuario();
            u.setNick(nick);
            u.setClave(Encriptar.encriptaEnMD5(clave));
            dao.addUsuario(u);

            return SUCCESS;
        } catch (MyException e) {
            return ERROR;
        }
    }

    private boolean isNickDisponible() {
        DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        UsuarioDAO dao = d.getUsuarioDAO();
        Modelo.Negocio.Usuario u = dao.getUsuario(nick);
        return u == null;
    }

    @Override
    public void validate() {
        if (nick.trim().isEmpty()) {
            addFieldError("nick", "Ingrese un nombre de usuario.");
        } else {
            if (nick.trim().length() < 6) {
                addFieldError("nick", "EL nick debe tener 6 caracteres como minimo.");
            } else {
                if (!isNickDisponible()) {
                    addFieldError("nick", "El nick elegido ya esta en uso, elija otro!.");
                }
            }
        }
        if (clave.trim().isEmpty()) {
            addFieldError("clave", "Ingrese una contraseña.");
        } else {
            if (clave.trim().length() < 6) {
                addFieldError("clave", "La contraseña debe tener 6 caracteres como minimo.");
            }
        }
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNick() {
        return nick;
    }

    public String getClave() {
        return clave;
    }

}
