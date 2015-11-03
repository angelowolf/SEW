/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Negocio;

import Modelo.IUsuario;
import Modelo.Proxy.UsuarioProxy;

/**
 *
 * @author Angelo
 */
public class Cliente {

    private int idCliente;
    private String nombre, apellido;
    private IUsuario usuario;

    public Cliente() {
        this.iniciarUsuario();
    }

    public Cliente(int id_cliente, String nombre, String apellido) {
        this.idCliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.iniciarUsuario();

    }

    public Cliente(int id_cliente, String nombre, String apellido, IUsuario u) {
        this.idCliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.iniciarUsuario();
    }

    private void iniciarUsuario() {
        this.usuario = new UsuarioProxy();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public IUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(IUsuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + idCliente + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario.toString() + '}';
    }

}
