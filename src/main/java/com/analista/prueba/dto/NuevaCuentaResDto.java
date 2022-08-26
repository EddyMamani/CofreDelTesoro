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
public class NuevaCuentaResDto extends ErrorStatus{
    
    private int nroCuenta;
    private String moneda;

    public NuevaCuentaResDto(){
        
    }
    
    public NuevaCuentaResDto(int nroCuenta, String moneda) {
        this.nroCuenta = nroCuenta;
        this.moneda = moneda;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    
    
    
    
}
