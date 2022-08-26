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
public class ErrorStatus implements Serializable{
    
    private int error;
    private String mensaje;

    public ErrorStatus() {
    }

    public ErrorStatus(int error, String mensaje) {
        this.error = error;
        this.mensaje = mensaje;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
}
