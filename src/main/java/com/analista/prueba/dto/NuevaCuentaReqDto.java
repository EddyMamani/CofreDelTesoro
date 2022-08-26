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
public class NuevaCuentaReqDto {
    
    private int nroCuenta;
    private String nombres;
    private String apellidos;
    private String tipoDocumento;
    private String nroDocumento;
    private String nroTelefono;
    private String email;
 
    private String moneda;

    public NuevaCuentaReqDto() {
    }

    public NuevaCuentaReqDto(int nroCuenta, String nombres, String apellidos, String tipoDocumento, String nroDocumento, String nroTelefono, String email, String moneda) {
        this.nroCuenta = nroCuenta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
        this.nroTelefono = nroTelefono;
        this.email = email;
       
        this.moneda = moneda;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(String nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    
    
}
