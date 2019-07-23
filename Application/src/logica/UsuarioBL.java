/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.UsuarioDAL;
import entidades.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author manue
 */
public class UsuarioBL {
    public Usuario iniciarSesion(String login, String password) throws Exception {
        Usuario usuario;
        
        if (!UsuarioDAL.verificarUsuario(login, password)) {
            throw new Exception("Password o contraseña incorrectos");
        } else {
            usuario = UsuarioDAL.crearUsuario(login, password);
            return usuario;
        }
    }
}
