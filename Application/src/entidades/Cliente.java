/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SERIN
 */
public class Cliente extends Usuario implements Comparable<Cliente> {
    private String dni;
    private String telefono;
    private String email;
    
    public Cliente()
    {
        this("00","NAP","NAM","NN","00000000","NC","ND","000000","NE");
    }
    
    public Cliente(String codigo, String paterno, String materno, String nombre, 
            String dni, String ciudad, String direccion, String telefono, String email)
    {
        super.codigo=codigo;
        super.paterno=paterno;
        super.materno=materno;
        super.nombre=nombre;
        this.dni=dni;
        super.ciudad=ciudad;
        super.direccion=direccion;
        this.telefono=telefono;
        this.email=email;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    @Override
    public int compareTo(Cliente cliente) {
        return this.getCodigo().compareTo(cliente.getCodigo());
    }        
    
    @Override
    public String getCodigo() {
        return codigo;
    }

    @Override
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String getPaterno() {
        return paterno;
    }

    @Override
    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    @Override
    public String getMaterno() {
        return materno;
    }

    @Override
    public void setMaterno(String materno) {
        this.materno = materno;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getCiudad() {
        return ciudad;
    }

    @Override
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    @Override
    public String getDireccion() {
        return direccion;
    }

    @Override
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
