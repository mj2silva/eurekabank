/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.ClienteDAL;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Empleado;
import entidades.Persona;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class ClienteBL {
    public static ArrayList<Cliente> buscarCliente(String busqueda) throws SQLException {
        ArrayList<Cliente> arrayClientes;
        arrayClientes = ClienteDAL.buscarCliente(busqueda);
        return arrayClientes;
    }
    
    public static ArrayList<Cuenta> getCuentas(Cliente cliente) throws SQLException {
        ArrayList<Cuenta> arrayCuentas = ClienteDAL.cuentaCliente(cliente);
        return arrayCuentas;
    }
    
    public static void agregarCuenta(Cuenta cuenta, Cliente cliente, Persona empleado) throws SQLException  {
        ClienteDAL.agregarCuenta(cuenta, cliente, empleado);
    }
    
    public static void relizarDeposito(Persona empleado, String cuenta, BigDecimal monto) throws SQLException {
        ClienteDAL.relizarDeposito(empleado, cuenta, monto);
    }
    
    public static String usuarioPorNumeroDeCuenta(String cuenta) throws SQLException {
        return ClienteDAL.usuarioPorNumeroDeCuenta(cuenta);
    }

    public static void realizarTransferencia(String cuentaOrigen, String cuentaDestino, int codigo, BigDecimal monto) throws SQLException {
        ClienteDAL.realizarTransferencia(cuentaOrigen, cuentaDestino, codigo, monto);
    }
}
