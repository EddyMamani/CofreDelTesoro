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
public class ConsultaReqDto {
    
    private int nroCuenta;

    public ConsultaReqDto() {
    }

    public ConsultaReqDto(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    
    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }
    
    
}
