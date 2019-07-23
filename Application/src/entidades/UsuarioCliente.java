/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import datos.ClienteDAL;
import java.sql.SQLException;

/**
 *
 * @author manue
 */
public class UsuarioCliente extends Usuario {

    public UsuarioCliente(int id, String login, String password, String usuaTipo) throws SQLException {
        super(id, login, password, "cliente");
        this.persona = ClienteDAL.obtenerCliente(id);
    }
    
}