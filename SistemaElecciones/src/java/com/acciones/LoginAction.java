/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import Controlador.ControladorUsuario;
import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.MyException;
import Modelo.Negocio.Usuario;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.log4j.Logger;

/**
 *
 * @author Angelo
 */
public class LoginAction extends ActionSupport {

    private static final Logger logger = Logger.getLogger(LoginAction.class);
    private String username;
    private String password;
    private DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private final Map<String, Object> application = ActionContext.getContext().getApplication();

    @Override
    public String execute() {
        try {
            if (ControladorUsuario.iniciarSesion(d, username, password)) {
                if (ControladorUsuario.isHabilitado(d, username)) {
                    Usuario usuario = ControladorUsuario.getUsuario(d, username);
                    sesion.put("user", usuario);
                } else {
                    addFieldError("", "Usuario no habilitado");
                }
            } else {
                addFieldError("", "Usuario o Contraseña incorrectos.");
                return INPUT;
            }
        } catch (Exception e) {
            logger.error("Error al iniciar sesion.", e);
            return ERROR;
        }
        try {
            if (application.get("mesas") == null) {
                MesaDAO mesaDAO = d.getMesaDAO();
                application.put("mesas", mesaDAO.getMesas());
            }
            if (application.get("candidatos") == null) {
                CandidatoDAO candidatoDAO = d.getCandidato();
                application.put("candidatos", candidatoDAO.getCandidatos());
            }
        } catch (MyException e) {
            logger.error("Error al obtener cantidad de mesas", e);
            return ERROR;
        }

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (password.trim().isEmpty()) {
            addFieldError("password", "Ingrese una clave.");
        }
        if (username.trim().isEmpty()) {
            addFieldError("username", "Ingrese el usuario.");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
