/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Cliente;
import entidades.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author manue
 */
public class ClienteDAL {
    
    private static Connection cn = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Cliente cliente;

    public static Persona obtenerCliente(int usuaId) {
        try {
            cn = Conexion.establecerConexion();
            st = cn.createStatement();
            String sql = "select * from cliente where usuaId = " + usuaId;
            rs = st.executeQuery(sql);
            if(rs.next()) {
                int codigo = rs.getInt(1);
                String paterno = rs.getString(2);
                String materno = rs.getString(3);
                String nombre = rs.getString(4);
                String dni = rs.getString(5);
                String ciudad = rs.getString(6);
                String direccion = rs.getString(6);
                String telefono = rs.getString(7);
                String email = rs.getString(8);
                cliente = new Cliente(telefono, codigo, paterno, materno, nombre, dni, ciudad, direccion, email);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }
        
        return cliente;
    }
    
    public static ArrayList<Cliente> buscarCliente(String busqueda) {
        ArrayList<Cliente> arrayClientes = new ArrayList<>();
        
        try {
            cn = Conexion.establecerConexion();
            String sql = "{call sp_buscarcliente(?)}";
            ps = cn.prepareStatement(sql);
            ps.setString(1, busqueda);
            rs = ps.executeQuery();
            while(rs.next()) {
                int codigo = rs.getInt(1);
                String paterno = rs.getString(2);
                String materno = rs.getString(3);
                String nombre = rs.getString(4);
                String dni = rs.getString(5);
                String ciudad = rs.getString(6);
                String direccion = rs.getString(6);
                String telefono = rs.getString(7);
                String email = rs.getString(8);
                arrayClientes.add(new Cliente(telefono, codigo, paterno, materno, nombre, dni, ciudad, direccion, email));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }
        
        return arrayClientes;
    }
    
}
