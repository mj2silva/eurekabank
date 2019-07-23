/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import entidades.Cliente;
import entidades.Cuenta;
import entidades.Empleado;
import entidades.Persona;
import entidades.Movimiento;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
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

    public static Persona obtenerCliente(int usuaId) throws SQLException {
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
        }finally{
            cn.close();
            rs.close();
            ps.close();
        }
        
        return cliente;
    }
    
    public static ArrayList<Cliente> buscarCliente(String busqueda) throws SQLException {
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
        }finally{
            cn.close();
            rs.close();
            ps.close();
        }
        
        return arrayClientes;
    }
    
    public static ArrayList<Cuenta> cuentaCliente(Cliente cliente) throws SQLException {
        ArrayList<Cuenta> arrayCuentas = new ArrayList<>();
        
        try {
            Cuenta cuenta;
            cn = Conexion.establecerConexion();
            String sql = "{call sp_cuentacliente(?)}";
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cliente.getCodigo());
            rs = ps.executeQuery();
            while(rs.next()) {
                String codigo = rs.getString(1);
                String moneda = rs.getString(2);
                BigDecimal saldo = rs.getBigDecimal(3);
                String estado = rs.getString(4);
                Date fechaCreacion = rs.getDate(5);
                int contMov = rs.getInt(6);
                cuenta = new Cuenta(codigo, moneda, saldo, estado, fechaCreacion, contMov);
                cuenta.setMovimientos(historialDeMovimientos(cuenta));
                arrayCuentas.add(cuenta);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }finally{
            cn.close();
            rs.close();
            ps.close();
        }
        
        return arrayCuentas;
    }
    
    public static ArrayList<Movimiento> historialDeMovimientos(Cuenta cuenta) throws SQLException {
        ArrayList<Movimiento> arrayMovimientos = new ArrayList<>();
        
        try {
            cn = Conexion.establecerConexion();
            String sql = "{call sp_historialdemovimientos(?)}";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cuenta.getNumeroDeCuenta());
            rs = ps.executeQuery();
            while(rs.next()) {
                String codigo = rs.getString(1);
                Date fecha = rs.getDate(2);
                String tipodescripcion = rs.getString(3);
                BigDecimal moviimporte = rs.getBigDecimal(4);
                String cuenreferencia;
                if (rs.getString(5) == null) {
                    cuenreferencia = rs.getString(5);
                } else {
                    cuenreferencia = "n/a";
                }
                
                arrayMovimientos.add(new Movimiento(codigo, fecha, tipodescripcion, moviimporte, cuenreferencia));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        } finally{
            cn.close();
            rs.close();
            ps.close();
        }
        
        return arrayMovimientos;
    }
    
    public static void agregarCuenta(Cuenta cuenta, Cliente cliente, Persona empleado) throws SQLException 
    {
        try {
            cn = Conexion.establecerConexion();
            String sql = "{call sp_nuevacuenta(?, ?, ?, ?, ?)}";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cuenta.getNumeroDeCuenta());
            ps.setInt(2, cliente.getCodigo());
            ps.setString(3, cuenta.getTipoDeMoneda());
            ps.setInt(4, empleado.getCodigo());
            ps.setBigDecimal(5, cuenta.getSaldo());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        } finally{
            cn.close();
            ps.close();
        }
    }
    
    public static void relizarDeposito(Persona empleado, String cuenta, BigDecimal monto) throws SQLException {
        try {
            cn = Conexion.establecerConexion();
            String sql = "{call sp_deposito(?, ?, ?)}";
            ps = cn.prepareStatement(sql);
            ps.setString(1, cuenta);
            ps.setBigDecimal(2, monto);
            ps.setInt(3, empleado.getCodigo());
            ps.executeUpdate();
            showMessageDialog(null,"Depósito realizado con éxito.","Resultado",1);
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null,"No se pudo realizar el depósito.","Error!",0);
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        } finally{
            cn.close();
            ps.close();
        }
        
    }
    
    public static String usuarioPorNumeroDeCuenta(String cuenta) throws SQLException {
        String nombres = "";
        
        try {
            cn = Conexion.establecerConexion();
            String sql = "select concat(clienombre, cliepaterno, cliematerno) from cliente c join cuenta cu "
                    + "on c.cliecodigo = cu.cliecodigo where cu.cuencodigo = '" + cuenta + "'";
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()) {
                nombres = rs.getString(1);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            showMessageDialog(null, ex.getMessage(),"Excepcion", 0);
        }finally{
            cn.close();
            rs.close();
            ps.close();
        }
        
        return nombres;
    }
}
