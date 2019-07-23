/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author manue
 */
public class Cuenta {
    private String numeroDeCuenta;
    private String tipoDeMoneda;
    private BigDecimal saldo;
    private Date fechaCreacion;
    private String estado;
    private int contMov;
    private ArrayList<Movimiento> movimientos;

    public Cuenta(String numeroDeCuenta, String tipoDeMoneda, BigDecimal saldo, String estado, Date fechaCreacion, int contMov) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeMoneda = tipoDeMoneda;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.contMov = contMov;
    }

    public Cuenta(String numeroDeCuenta, String tipoDeMoneda, BigDecimal saldo, String estado, int contMov) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeMoneda = tipoDeMoneda;
        this.saldo = saldo;
        this.estado = estado;
        this.contMov = contMov;
    }

    public Cuenta(String numeroDeCuenta, String tipoDeMoneda, BigDecimal saldo, String estado, Date fechaCreacion,  int contMov, ArrayList<Movimiento> movimientos) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeMoneda = tipoDeMoneda;
        this.saldo = saldo;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.contMov = contMov;
        this.movimientos = movimientos;
    }
    
    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public void setNumeroDeCuenta(String numeroDeCuenta) {
        this.numeroDeCuenta = numeroDeCuenta;
    }

    public String getTipoDeMoneda() {
        return tipoDeMoneda;
    }

    public void setTipoDeMoneda(String tipoDeMoneda) {
        this.tipoDeMoneda = tipoDeMoneda;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getContMov() {
        return contMov;
    }

    public void setClave(int contMov) {
        this.contMov = contMov;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(ArrayList<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    
    
    
}
