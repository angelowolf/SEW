/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO.Cliente;

import Modelo.Negocio.Cliente;
import java.util.List;

/**
 *
 * @author Angelo
 */
public interface ClienteDAO {

    public Cliente getCliente(int id_cliente);

    public boolean updateCliente(Cliente c);
    
    public boolean insertarCliente(Cliente c);

    public List<Cliente> getClientes();

    public void eliminarCLiente(int idCliente);

}
