/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import DAO.Candidato.CandidatoDAO;
import DAO.DAOFactory;
import DAO.Mesa.MesaDAO;
import DAO.MyException;
import Modelo.Negocio.Candidato;
import Modelo.Negocio.Usuario;
import com.modelo.SingletonCantidadMesa;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;
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
    private DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private Map<String, Object> sesion = ActionContext.getContext().getSession();
    private Map<String, Object> application = ActionContext.getContext().getApplication();

    @Override
    public String execute() {
        try {
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
