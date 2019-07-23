/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author manue
 */
public class UsuarioCliente extends Usuario {
    
    private Cliente cliente;

    public UsuarioCliente() {
        this.cliente = null;
    }
    
    public UsuarioCliente(int id, String login, String password, String tipo, Cliente cliente) {
        super(id, login, password, tipo);
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
}