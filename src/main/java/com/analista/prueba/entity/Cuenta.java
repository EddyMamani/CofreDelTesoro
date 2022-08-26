/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Eddy
 */

@Entity
public class Cuenta {
    
    @Id
    private int nrocuenta;
    
    private String nombres;
    private String apellidos;
    private String tipodocumento;
    private String nrodocumento;
    private String nrotelefono;
    private String email;
    private String estado;
    private String moneda;

    public Cuenta() {
    }

    public Cuenta(int nrocuenta, String nombres, String apellidos, String tipodocumento, String nrodocumento, String nrotelefono, String email, String estado, String moneda) {
        this.nrocuenta = nrocuenta;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipodocumento = tipodocumento;
        this.nrodocumento = nrodocumento;
        this.nrotelefono = nrotelefono;
        this.email = email;
        this.estado = estado;
        this.moneda = moneda;
    }

    public int getNrocuenta() {
        return nrocuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nrocuenta = nroCuenta;
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

    public String getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(String tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNrodocumento() {
        return nrodocumento;
    }

    public void setNrodocumento(String nrodocumento) {
        this.nrodocumento = nrodocumento;
    }

    public String getNrotelefono() {
        return nrotelefono;
    }

    public void setNrotelefono(String nrotelefono) {
        this.nrotelefono = nrotelefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    
    
    
}
