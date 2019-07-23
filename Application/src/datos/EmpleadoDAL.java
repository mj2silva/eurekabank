/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author manue
 */
public class EmpleadoDAL {
    private static Connection cn = null;
    private static Statement st = null;
    private static ResultSet rs = null;
    private static PreparedStatement ps = null;
    private static Empleado empleado;
    
    public static Empleado obtenerEmpleado(int usuaId) {
        try {
            cn = Conexion.establecerConexion();
            st = cn.createStatement();
            String sql = "select * from empleado where usuaId = " + usuaId;
            rs = st.executeQuery(sql);
            if(rs.next()) {
                int codigo = rs.getInt(1);
                String paterno = rs.getString(2);
                String materno = rs.getString(3);
                String nombre = rs.getString(4);
                String ciudad = rs.getString(5);
                String direccion = rs.getString(6);
                String email = rs.getString(7);
                empleado = new Empleado(codigo, paterno, materno, nombre, ciudad, direccion, email);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }
        
        return empleado;
    }
}
