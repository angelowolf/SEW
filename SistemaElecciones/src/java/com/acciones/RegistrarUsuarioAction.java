/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.acciones;

import Controlador.Encriptar;
import DAO.Cliente.ClienteDAO;
import DAO.DAOFactory;
import DAO.MyException;
import DAO.Usuario.UsuarioDAO;
import com.opensymphony.xwork2.ActionSupport;
import Modelo.Negocio.Usuario;
import com.opensymphony.xwork2.validator.annotations.EmailValidator;
import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import org.apache.log4j.Logger;
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

    private static final Logger logger = Logger.getLogger(RegistrarUsuarioAction.class);
    private String nick, clave, clave2, nombre, apellido, email;

    @Override
    @Action(value = "/registrar_usuario")
    public String execute() {
        try {
            if (Controlador.ControladorCliente.crearCliente(apellido, nombre, email, nick, clave)) {
                addActionMessage("Cliente registrado con Exito!.");
                return SUCCESS;
            } else {
                addActionError("Error al crear el Cliente.");
                return INPUT;
            }
        } catch (MyException e) {
            logger.error("Error al iniciar sesion.", e);
            return ERROR;
        }
    }

    @Override
    public void validate() {
        if (nick.trim().isEmpty()) {
            addFieldError("nick", "Ingrese un nombre de usuario.");
        } else {
            if (nick.trim().length() < 6) {
                addFieldError("nick", "EL nick debe tener 6 caracteres como minimo.");
            } else {
                if (!Controlador.ControladorCliente.isNickDisponible(nick)) {
                    addFieldError("nick", "El nick elegido ya esta en uso, elija otro!.");
                }
            }
        }
        if (clave.trim().isEmpty()) {
            addFieldError("clave", "Ingrese una contraseña.");
        } else {
            if (clave.trim().length() < 6) {
                addFieldError("clave", "La contraseña debe tener 6 caracteres como minimo.");
            } else {
                if (clave.compareTo(clave2) != 0) {
                    addFieldError("Clave2", "Las contraseñas no soniguales.");
                }
            }
        }
//
//        if (nombre.trim().isEmpty()) {
//            addFieldError("nombre", "Ingrese un nombre.");
//        }
//        if (apellido.trim().isEmpty()) {
//            addFieldError("apellido", "Ingrese un apellido.");
//        }

    }

    public void setClave2(String clave2) {
        this.clave2 = clave2;
    }

    public String getNombre() {
        return nombre;
    }

    @RequiredStringValidator(message = "Ingrese el nombre.")
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @RequiredStringValidator(message = "Ingrese el apellido.")
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    @RequiredStringValidator(message = "Ingrese el E-Mail.")
    @EmailValidator(message = "El correro ingresado no es valido.")
    public void setEmail(String email) {
        this.email = email;
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

}
