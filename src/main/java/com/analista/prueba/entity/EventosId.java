/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.entity;

import java.io.Serializable;
import java.sql.Timestamp;


/**
 *
 * @author Eddy
 */
public class EventosId implements Serializable{
   
    private int nrocuenta;

    private Number saldo;
    private Timestamp fechahora;

    public EventosId(int nrocuenta, Number saldo, Timestamp fechahora) {
        this.nrocuenta = nrocuenta;
        this.saldo = saldo;
        this.fechahora = fechahora;
    }
    
}
