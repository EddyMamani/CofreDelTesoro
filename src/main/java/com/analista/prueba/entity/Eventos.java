/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.entity;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

/**
 *
 * @author Eddy
 */

@Entity

public class Eventos  {
    
    @Id
    private Timestamp fechahora;
  
    private int nrocuenta;
   
    private Number saldo;
    
    
    
    private Number credito;
    private Number debito;
    
    private String concepto;
    private String accion;
    private String moneda;

    public Eventos() {
    }

    public Eventos(int nrocuenta, Number saldo, Number credito, Number debito, Timestamp fechahora, String concepto, String accion, String moneda) {
        this.nrocuenta = nrocuenta;
        this.saldo = saldo;
        this.credito = credito;
        this.debito = debito;
        this.fechahora = fechahora;
        this.concepto = concepto;
        this.accion = accion;
        this.moneda = moneda;
    }

    

    

    

  
    public int getNrocuenta() {
        return nrocuenta;
    }

    public void setNrocuenta(int nrocuenta) {
        this.nrocuenta = nrocuenta;
    }

    public Number getSaldo() {
        return saldo;
    }

    public void setSaldo(Number saldo) {
        this.saldo = saldo;
    }

    public Number getCredito() {
        return credito;
    }

    public void setCredito(Number credito) {
        this.credito = credito;
    }

    public Number getDebito() {
        return debito;
    }

    public void setDebito(Number debito) {
        this.debito = debito;
    }

    public Timestamp getFechahora() {
        return fechahora;
    }

    public void setFechahora(Timestamp fechahora) {
        this.fechahora = fechahora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }
    
    
    
}
