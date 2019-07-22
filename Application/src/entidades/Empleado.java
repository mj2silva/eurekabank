/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SERIN
 */
public class Empleado extends Usuario implements Comparable<Empleado> {
    public Empleado(String codigo, String paterno,String materno,
            String nombre,String ciudad,String direccion) {
        super.codigo = codigo;
        super.paterno=paterno;
        super.materno=materno;
        super.nombre=nombre;
        super.ciudad=ciudad;
        super.direccion=direccion;
    }

    public Empleado() {
        this("00", "NM","NP","NN","NC","ND");
    }

    @Override
    public int compareTo(Empleado empleado) {
        return this.getCodigo().compareTo(empleado.getCodigo());
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