/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.dto;

import com.analista.prueba.entity.Eventos;
import java.util.List;

/**
 *
 * @author Eddy
 */


public class ConsultaResDto extends ErrorStatus{
    
    private Number Saldo;
    private String estadoCuenta;
    private List<Eventos> historico;

    public ConsultaResDto() {
    }

    public ConsultaResDto(Number Saldo) {
        this.Saldo = Saldo;
    }

    public ConsultaResDto(Number Saldo, int error, String mensaje, String estadoCuenta) {
        super(error, mensaje);
        this.Saldo = Saldo;
        this.estadoCuenta = estadoCuenta;
    }

    public Number getSaldo() {
        return Saldo;
    }

    public void setSaldo(Number Saldo) {
        this.Saldo = Saldo;
    }

    public List<Eventos> getHistorico() {
        return historico;
    }

    public void setHistorico(List<Eventos> historico) {
        this.historico = historico;
    }

    public String getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(String estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }
    
    
    
}
