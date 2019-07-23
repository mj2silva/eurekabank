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
    private String email;

    public Cliente(String telefono, String email, int codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String usuaID, String password) {
        super(codigo, paterno, materno, nombre, ciudad, direccion, usuaID, password);
        this.telefono = telefono;
        this.email = email;
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
