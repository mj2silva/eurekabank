/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.sql.Date;

/**
 *
 * @author manue
 */
public class Asignado {
    private Sucursal sucursal;
    private Date fechaAlta;
    private Date fechaBaja;

    public Asignado(Sucursal sucursal, Date fechaAlta, Date fechaBaja) {
        this.sucursal = sucursal;
        this.fechaAlta = fechaAlta;
        this.fechaBaja = fechaBaja;
    }

    public Asignado(Sucursal sucursal, Date fechaAlta) {
        this.sucursal = sucursal;
        this.fechaAlta = fechaAlta;
    }

    public Asignado(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Sucursal getSucursal() {
        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    
}
