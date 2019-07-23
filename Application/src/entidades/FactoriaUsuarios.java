/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import datos.EmpleadoDAL;

/**
 *
 * @author SERIN
 */
public class FactoriaUsuarios {
    public static Usuario getUsuario(String tipo, int id, String login, String password){
        
        
        if (tipo.equals("admin")||tipo.equals("empleado")) {
            return new UsuarioEmpleado(id, login, password, tipo);
        }
        else {
            return new UsuarioCliente(id, login, password, tipo);
        }
    }
}
