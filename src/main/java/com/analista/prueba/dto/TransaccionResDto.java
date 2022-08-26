/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.dto;

/**
 *
 * @author Eddy
 */
public class TransaccionResDto extends ErrorStatus{
    
    private Number saldo;
    private String estadoCuenta;

    public TransaccionResDto() {
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
