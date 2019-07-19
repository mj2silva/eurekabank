/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author Jairo Navez
 */
public class Empleado extends Persona implements Comparable<Empleado> {

    public Empleado(String codigo, String paterno,String materno,
            String nombre,String ciudad,String direccion,String usuaID,String password) {
        super.codigo = codigo;
        super.paterno=paterno;
        super.materno=materno;
        super.nombre=nombre;
        super.ciudad=ciudad;
        super.direccion=direccion;
        this.usuaID=usuaID;
        this.password=password;
    }

    public Empleado() {
        this("00", "NM","NP","NN","NC","ND","NU","00");
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

    @Override
    public String getUsuaID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUsuaID(String usuaID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}