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
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class ClienteBL {
    public static ArrayList<Cliente> buscarCliente(String busqueda) {
        ArrayList<Cliente> arrayClientes;
        arrayClientes = ClienteDAL.buscarCliente(busqueda);
        return arrayClientes;
    }
    
    public static ArrayList<Cuenta> getCuentas(Cliente cliente) {
        ArrayList<Cuenta> arrayCuentas = ClienteDAL.cuentaCliente(cliente);
        return arrayCuentas;
    }
    
    public static void agregarCuenta(Cuenta cuenta, Cliente cliente, Persona empleado)  {
        ClienteDAL.agregarCuenta(cuenta, cliente, empleado);
    }
}
