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

    public Cliente(String telefono, int codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String email) {
        super(codigo, paterno, materno, nombre, ciudad, direccion, email);
        this.telefono = telefono;
        super.setTipo("cliente");
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
