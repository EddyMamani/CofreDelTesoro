/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.service;

import com.analista.prueba.entity.Cuenta;
import com.analista.prueba.dto.ErrorStatus;
import com.analista.prueba.repository.CuentaRepository;
import com.analista.prueba.util.Utils;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Eddy
 */

@Service
public class CuentaService {
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Transactional
    public ErrorStatus createCuenta(Cuenta cuenta){
        ErrorStatus es = new ErrorStatus();
        
        try{
            if(!cuentaRepository.existsByNrocuenta(cuenta.getNrocuenta())){
                cuenta.setEstado(Utils.ACTIVE);
                cuentaRepository.save(cuenta);
                es.setError(0);
                es.setMensaje("Se creo la cuenta correctamente.");
            }else{
                es.setError(404);
                es.setMensaje("El nro de cuenta existe en los registros.");
            }
            
        }catch(Exception e){
            es.setError(500);
            es.setMensaje("Error inesperado");
        }
        return es;
    }
    
    @Transactional
    public Cuenta getCuenta(int nroCuenta){
        Cuenta res = new Cuenta();
        res = cuentaRepository.getByNrocuenta(nroCuenta);
        return res;
    }
}
