/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.dto;

import java.sql.Timestamp;

/**
 *
 * @author Eddy
 */
public class TransaccionReqDto {
    
    private int nroCuenta;
    private Number monto;
    private String concepto;
    
    private String moneda;

    public TransaccionReqDto() {
    }

    public TransaccionReqDto(int nroCuenta, Number monto,  String concepto,  String moneda) {
        this.nroCuenta = nroCuenta;
        this.monto = monto;
        this.concepto = concepto;
       
        this.moneda = moneda;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNrocuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public Number getMonto() {
        return monto;
    }

    public void setMonto(Number monto) {
        this.monto = monto;
    }

   

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

   

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    
    
}
