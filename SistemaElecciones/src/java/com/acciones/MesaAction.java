/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acciones;

import Controlador.ControladorMesa;
import DAO.DAOFactory;
import DAO.MyException;
import Modelo.Negocio.Mesa;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author angelo
 */
public class MesaAction extends ActionSupport implements ModelDriven<Mesa> {

    private Mesa mesa = new Mesa();
    private List<Mesa> mesaLista = new ArrayList<>();
    private final DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private final DAO.Mesa.MesaDAO daoMesa = d.getMesaDAO();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();
    private final Map<String, Object> application = ActionContext.getContext().getApplication();

    private boolean validar() {
        if (mesa.getNumeroMesa() <= 0) {
            addFieldError("mesa.numeroMesa", "Ingrese un numero de mesa.");
            return false;
        }
        return true;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        Mesa m = daoMesa.getMesa(mesa.getNumeroMesa());
        if (m == null) {
            ControladorMesa.crear(d, mesa);
            application.put("mesas", daoMesa.getMesas());
            sesion.put("mensaje", "Mesa Agregada.");
        } else {
            addFieldError("mesa.numeroMesa", "El numero de mesa ya esta ingresado.");
            return INPUT;
        }
        return SUCCESS;
    }

    public String list() {
        mesaLista = daoMesa.getMesas();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        try {
            ControladorMesa.eliminar(d, Integer.parseInt(request.getParameter("numeroMesa")));
            sesion.put("mensaje", "Mesa Eliminada.");
        } catch (MyException e) {
            sesion.put("mensaje", "No se puede eliminar la mesa ya que esta es utilizada por el sistema, debera eliminar los votantes asociadas a ella.");
        }
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        mesa = daoMesa.getMesa(Integer.parseInt(request.getParameter("numeroMesa")));
        return SUCCESS;
    }

    @Override
    public Mesa getModel() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public void setMesaLista(List<Mesa> mesaLista) {
        this.mesaLista = mesaLista;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public List<Mesa> getMesaLista() {
        return mesaLista;
    }

}
