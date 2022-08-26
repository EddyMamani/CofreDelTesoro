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
public class ListaEventos extends ErrorStatus{
    
    private List<Eventos> listEventos;

    public ListaEventos() {
    }

    public ListaEventos(int error, String mensaje) {
        super(error, mensaje);
    }

    public ListaEventos(List<Eventos> listEventos) {
        this.listEventos = listEventos;
    }

    public ListaEventos(List<Eventos> listEventos, int error, String mensaje) {
        super(error, mensaje);
        this.listEventos = listEventos;
    }

    public List<Eventos> getListEventos() {
        return listEventos;
    }

    public void setListEventos(List<Eventos> listEventos) {
        this.listEventos = listEventos;
    }
    
    
}
