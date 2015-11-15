/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Action;

import Controlador.ControladorCliente;
import Controlador.ControladorUsuario;
import DAO.DAOFactory;
import Modelo.Negocio.Cliente;
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
public class ClienteAction extends ActionSupport implements ModelDriven<Cliente> {

    private Cliente cliente = new Cliente();
    private List<Cliente> clienteLista = new ArrayList<>();
    private final DAOFactory d = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
    private final DAO.Cliente.ClienteDAO daoCliente = d.getClienteDAO();
    private final Map<String, Object> sesion = ActionContext.getContext().getSession();

    @Override
    public Cliente getModel() {
        return cliente;
    }

    private boolean validar() {
        boolean flag = true;
        if (cliente.getNombre().trim().isEmpty()) {
            addFieldError("cliente.nombre", "Ingrese un nombre.");
            flag = false;
        }
        if (cliente.getApellido().trim().isEmpty()) {
            addFieldError("cliente.apellido", "Ingrese un apellido.");
            flag = false;
        }
        if (cliente.getEmail().trim().isEmpty()) {
            addFieldError("cliente.email", "Ingrese un email.");
            flag = false;
        }
        if (cliente.getUsuario().getNick().trim().isEmpty()) {
            addFieldError("cliente.usuario.nick", "Ingrese un nick.");
            flag = false;
        } else {
            if (!ControladorUsuario.isNickDisponible(d, cliente)) {
                addFieldError("cliente.usuario.nick", "Nick no disponible.");
                flag = false;
            }
        }
        if (cliente.getUsuario().getClave().trim().isEmpty()) {
            addFieldError("cliente.usuario.clave", "Ingrese una clave.");
            flag = false;
        }
        return flag;
    }

    public String guardarOModificar() {
        if (!validar()) {
            return INPUT;
        }
        if (cliente.getIdCliente() != 0) {
            ControladorCliente.modificarCliente(d, cliente);
            sesion.put("mensaje", "Usuario Modificado.");
        } else {
            ControladorCliente.crearCliente(d, cliente);
            sesion.put("mensaje", "Usuario Agregado.");
        }
        return SUCCESS;
    }

    public String list() {
        clienteLista = daoCliente.getClientes();
        String mensaje = (String) sesion.get("mensaje");
        addActionMessage(mensaje);
        sesion.put("mensaje", "");
        return SUCCESS;
    }

    public String eliminar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Cliente c = daoCliente.getCliente(Integer.parseInt(request.getParameter("idCliente")));
        daoCliente.eliminarCLiente(c.getIdCliente());
        Controlador.ControladorUsuario.eliminar(d, c.getUsuario().getIdUsuario());
        sesion.put("mensaje", "Cliente Eliminado.");
        return SUCCESS;
    }

    public String habilitar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        Cliente cliente = daoCliente.getCliente(Integer.parseInt(request.getParameter("idCliente")));
        ControladorUsuario.habilitarDeshabilitar(d, cliente.getUsuario());
        sesion.put("mensaje", "Modificacion realizada.");
        return SUCCESS;
    }

    public String editar() {
        HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
        cliente = daoCliente.getCliente(Integer.parseInt(request.getParameter("idCliente")));
        return SUCCESS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente candidato) {
        this.cliente = candidato;
    }

    public List<Cliente> getClienteLista() {
        return clienteLista;
    }

    public void setClienteLista(List<Cliente> clienteLista) {
        this.clienteLista = clienteLista;
    }

}
