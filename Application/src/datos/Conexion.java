/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import presentacion.Login;

/**
 *
 * @author User
 */
public class Conexion {

    public static Connection establecerConexion()
            throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/eurekabank";
        String user = "root";
        String password = "12345";
        return DriverManager.getConnection(url, user, password);
    }
    
    public static String Conectar() {
        String mensaje;
        try {
        Connection cn = establecerConexion();
        mensaje="Conexión exitosa! \n"+cn.toString();
        //showMessageDialog(null, mensaje, "Exito", 1);
        //Principal MP = new Principal();
        //MP.setVisible(true);
        }catch(SQLException | ClassNotFoundException e) {
            mensaje="Conexión fallida!"+e.getMessage();
            showMessageDialog(null, mensaje, "Error", 0);
            System.exit(0);
        }
        return mensaje;
    }
}