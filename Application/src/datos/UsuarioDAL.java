/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.FactoriaUsuarios;
import entidades.Usuario;
import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;

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
            String sql = "select fn_verificarusuario('" + login + "','" + password + "')";
            rs = st.executeQuery(sql);
            if(rs.next()) {
                if (rs.getInt(1) == 1) {
                    verificado = true;
                }
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }
        
        return verificado;
    }
    
    public static Usuario crearUsuario(String login, String password) {
        usuario = null;
        if (verificarUsuario(login, password)) {
            try {
                String tipo = "";
                int id = 0;
                cn = Conexion.establecerConexion();
                st = cn.createStatement();
                String sql = "{call sp_obtenerusuario(?, ?)}";
                ps = cn.prepareStatement(sql);
                ps.setString(1, login);
                ps.setString(2, password);
                
                rs = ps.executeQuery();
                if(rs.next()) {
                    id = rs.getInt(1);
                    tipo = rs.getString(4);
                }
                
                usuario = FactoriaUsuarios.getUsuario(tipo, id, login, password);
            } catch (ClassNotFoundException | SQLException ex) {
                showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
            }
        }
        return usuario;
    }
}
