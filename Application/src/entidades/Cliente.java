/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SERIN
 */
public class Cliente extends Persona{
    private String telefono;
    private String dni;

    public Cliente(String telefono, int codigo, String paterno, String materno, String nombre, String dni, String ciudad, String direccion, String email) {
        super(codigo, paterno, materno, nombre, ciudad, direccion, email);
        this.telefono = telefono;
        this.dni = dni;
        super.setTipo("cliente");
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
    
    
    
}
