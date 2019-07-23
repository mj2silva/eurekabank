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
    protected int codigo;
    protected String paterno;
    protected String materno;
    protected String nombre;
    protected String ciudad;
    protected String direccion;
    protected String usuaID;

    public Persona(){
        this(0,"NP","NM","NN","NC","ND","NI","NP");
    }
    
    public Persona(int codigo, String paterno, String materno, String nombre, String ciudad, String direccion, String usuaID, String password) {
        this.codigo = codigo;
        this.paterno = paterno;
        this.materno = materno;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.usuaID=usuaID;
    }
        
}
