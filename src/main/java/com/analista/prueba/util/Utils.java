/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.util;

/**
 *
 * @author Eddy
 */
public class Utils {
    
    public static String CREDITO = "DEPOSITO";
    public static String DEBITO = "RETIRO";
    public static String HOLD = "HOLD";
    public static String ACTIVE = "ACTIVE";
    
    public static boolean validEventosAccion(String accion){
        return accion.equals(CREDITO) || accion.equals(DEBITO);
    }
}
