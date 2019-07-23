/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author SERIN
 */
public abstract class Usuario {
    protected int id;
    protected String login;
    protected String password;
    protected String usuaTipo;
    protected Persona persona;

    public Usuario(int id, String login, String password, String usuaTipo) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.usuaTipo = usuaTipo;
    }

    public Usuario() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuaTipo() {
        return usuaTipo;
    }

    public void setUsuaTipo(String usuaTipo) {
        this.usuaTipo = usuaTipo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    
    
    
     
}
