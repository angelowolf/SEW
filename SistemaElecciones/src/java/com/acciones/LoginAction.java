/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.MyException;
import Modelo.Negocio.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import javax.print.attribute.standard.Compression;
import org.apache.log4j.Logger;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

/**
 *
 * @author Angelo
 */
@Namespace(value = "/")
@Action(value = "login", results = {
    @Result(name = "success", location = "/resultadosEnVivo.jsp"),
    @Result(name = "error", location = "/error.jsp"),
    @Result(name = "none", location = "/index.jsp")})
public class LoginAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(LoginAction.class);
    private String mensaje;
    private String username;
    private String password;

    @Override
    public String execute() {
        try {
            Map<String, Object> sesion = ActionContext.getContext().getSession();
            Usuario user = new Usuario("cazador1992", "counter1.5");
//        um = new UsuarioManager();
//        ////
//        um.guardarNuevoUsuario(user);
//        ////
//        Usuario user = um.buscarUsuarioPorID(username);
//        if (user == null) {
//            mensaje = "Contraseña y/o Usuario incorrectos";
//            return NONE;
//        }
            if (user.getNick().equals(username) && user.getClave().equals(password)) {
                sesion.put("user", user);
            } else {
                mensaje = "Contraseña y/o Usuario incorrectos";
                return NONE;
            }
        } catch (Exception e) {
            logger.error("Error al iniciar sesion.", e);
            return ERROR;
        }
        try {
            com.modelo.SingletonCantidadMesa.getInstancia().getCantidadMesas();
        } catch (MyException e) {
            logger.error("Error al obtener cantidad de mesas", e);
            return ERROR;
        }

        return SUCCESS;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
