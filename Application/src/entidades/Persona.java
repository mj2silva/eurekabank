/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jairo Navez
 */
public abstract class Persona {
    protected String codigo;
    protected String paterno;
    protected String materno;
    protected String nombre;
    protected String ciudad;
    protected String direccion;
    protected String usuaID;
    protected String password;

    public Persona(){
        this("NC","NP","NM","NN","NC","ND","NI","NP");
    }
    
    public Persona(String codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String usuaID, String password) {
        this.codigo = codigo;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.usuaID=usuaID;
    }

    public abstract String getCodigo();

    public abstract void setCodigo(String codigo);

    public abstract String getPaterno();

    public abstract void setPaterno(String paterno);

    public abstract String getMaterno();

    public abstract void setMaterno(String materno);

    public abstract String getNombre();

    public abstract void setNombre(String nombre);

    public abstract String getCiudad();

    public abstract void setCiudad(String ciudad);

    public abstract String getDireccion();

    public abstract void setDireccion(String direccion);
    
    public abstract String getUsuaID();
    
    public abstract void setUsuaID(String usuaID);
    
    public abstract String getPassword();
    
    public abstract void setPassword(String password);
    
        
}
