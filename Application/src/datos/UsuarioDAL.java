/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.FactoriaUsuarios;
import entidades.Usuario;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author manue
 */
public class UsuarioDAL {
    private static Connection cn = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Usuario usuario;
    
    public static boolean verificarUsuario(String login, String password) {
        boolean verificado = false;
        
        try {
            cn = Conexion.establecerConexion();
            st = cn.createStatement();
            String sql = "select fn_verificarusuario(" + login + "," + password + ")";
            rs = st.executeQuery(sql);
            if(rs.next()) {
                if (rs.getInt(1) == 1) {
                    verificado = true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(UsuarioDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return verificado;
    }
    
    public static Usuario crearUsuario(String login, String password) {
        usuario = null;
        if (verificarUsuario(login, password)) {
            try {
                String tipo = "";
                cn = Conexion.establecerConexion();
                st = cn.createStatement();
                String sql = "{call sp_obtenertipo(?)}";
                ps = cn.prepareStatement(sql);
                ps.setString(1, login);
                
                rs = ps.executeQuery();
                if(rs.next()) {
                    tipo = rs.getString(1);
                }
                
                usuario = FactoriaUsuarios.getUsuario(tipo);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(UsuarioDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return usuario;
    }
}
