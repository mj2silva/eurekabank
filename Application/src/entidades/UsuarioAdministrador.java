/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import datos.EmpleadoDAL;

/**
 *
 * @author manue
 */
public class UsuarioAdministrador extends Usuario {
    
    public UsuarioAdministrador(int id, String login, String password, String tipo) {
        super(id, login, password, "admin");
        this.persona = EmpleadoDAL.obtenerEmpleado(id);
    }
}
