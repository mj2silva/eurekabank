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
public class UsuarioEmpleado extends Usuario {
    public UsuarioEmpleado(int id, String login, String password, String tipo) {
        super(id, login, password, "empleado");
        this.persona = EmpleadoDAL.obtenerEmpleado(id);
    }
    
}
