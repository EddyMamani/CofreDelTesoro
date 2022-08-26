/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.dto;

import java.io.Serializable;

/**
 *
 * @author Eddy
 */
public class SaldoCuenta extends ErrorStatus implements Serializable{
    
    private Number saldo;
    private String estadoCuenta;

    public SaldoCuenta() {
    }

    public SaldoCuenta(int error, String mensaje) {
        super(error, mensaje);
    }

    public SaldoCuenta(Number sald, String estadoCuenta) {
        this.saldo = saldo;
        this.estadoCuenta = estadoCuenta;
    }

    public SaldoCuenta(Number saldo, int error, String mensaje) {
        super(error, mensaje);
        this.saldo = saldo;
    }

    public Number getSaldo() {
        return saldo;
    }

    public void setSaldo(Number saldo) {
        this.saldo = saldo;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    
    
    
    
}
