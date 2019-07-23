/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.math.BigDecimal;
import java.sql.*;

/**
 *
 * @author manue
 */
public class Movimiento {
    private String codigo; 
    private Date fecha;
    private String tipodescripcion;
    private BigDecimal moviimporte;
    private String cuenreferencia ;

    public Movimiento(String codigo, Date fecha, String tipodescripcion, BigDecimal moviimporte, String cuenreferencia) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.tipodescripcion = tipodescripcion;
        this.moviimporte = moviimporte;
        this.cuenreferencia = cuenreferencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipodescripcion() {
        return tipodescripcion;
    }

    public void setTipodescripcion(String tipodescripcion) {
        this.tipodescripcion = tipodescripcion;
    }

    public BigDecimal getMoviimporte() {
        return moviimporte;
    }

    public void setMoviimporte(BigDecimal moviimporte) {
        this.moviimporte = moviimporte;
    }

    public String getCuenreferencia() {
        return cuenreferencia;
    }

    public void setCuenreferencia(String cuenreferencia) {
        this.cuenreferencia = cuenreferencia;
    }
    
    
}
