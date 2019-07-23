/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SERIN
 */
public class Empleado extends Persona{
    
    private Asignado asignado;

    public Empleado(Asignado asignado, int codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String email) {
        super(codigo, paterno, materno, nombre, ciudad, direccion, email);
        this.asignado = asignado;
        super.setTipo("empleado");
    }

    public Empleado(int codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String email) {
        super(codigo, paterno, materno, nombre, ciudad, direccion, email);
        super.setTipo("empleado");
    }

    public Asignado getAsignado() {
        return asignado;
    }

    public void setAsignado(Asignado asignado) {
        this.asignado = asignado;
    }
    
}