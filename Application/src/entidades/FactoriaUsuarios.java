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
public class FactoriaUsuarios {
    public static Usuario getUsuario(String usuaTipo){
        if (usuaTipo.equals("Admin")||usuaTipo.equals("Empleado")) {
            return new UsuarioEmpleado();
        }
        else {
            return new UsuarioCliente();
        }
    }
}
