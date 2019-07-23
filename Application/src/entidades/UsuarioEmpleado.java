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
public class UsuarioEmpleado extends Usuario {

    private Empleado empleado;

    public UsuarioEmpleado() {
        this.empleado = null;
    }
    
    
    public UsuarioEmpleado(int id, String login, String password, String tipo, Empleado empleado) {
        super(id, login, password, tipo);
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
    
}
