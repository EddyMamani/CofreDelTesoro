/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.service;

import com.analista.prueba.entity.Cuenta;
import com.analista.prueba.entity.Eventos;
import com.analista.prueba.dto.ErrorStatus;
import com.analista.prueba.dto.ListaEventos;
import com.analista.prueba.dto.SaldoCuenta;
import com.analista.prueba.repository.CuentaRepository;
import com.analista.prueba.repository.EventosRepository;
import com.analista.prueba.util.Utils;
import com.sun.media.jfxmedia.logging.Logger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Eddy
 */

@Service
public class EventosService {
    protected final Log logger = LogFactory.getLog(this.getClass());
    @Autowired
    private EventosRepository eventosRepository;
    
    @Autowired
    private CuentaRepository cuentaRepository;
    
    @Transactional
    public ErrorStatus createEventos(Eventos eventos){
        ErrorStatus es = new ErrorStatus();
        if(cuentaRepository.existsByNrocuenta(eventos.getNrocuenta())){
            Cuenta cuentaAccion = cuentaRepository.findById(eventos.getNrocuenta()).get();
            
            if(eventos.getMoneda().equalsIgnoreCase(cuentaAccion.getMoneda())){
            
                try{
                    if(Utils.validEventosAccion(eventos.getAccion())){
                        if(eventos.getAccion().equals(Utils.CREDITO)){

                            eventos.setFechahora(new Timestamp((new Date()).getTime()));
                            eventos.setDebito(0);
                            if(eventosRepository.existsByNrocuenta(eventos.getNrocuenta())){
                                Eventos lastEvent = eventosRepository.findByNrocuentaOrderByFechahoraDesc(eventos.getNrocuenta()).get(0);
                                logger.info("Aqui ingresa 1");
                                eventos.setSaldo((lastEvent.getSaldo().doubleValue())+ (eventos.getCredito().doubleValue()));
                                logger.info("Aqui ingresa 1");
                                if(lastEvent.getSaldo().doubleValue()<0 && eventos.getSaldo().doubleValue()>=0){
                                    Cuenta cuenta = new Cuenta();
                                    cuenta.setNroCuenta(eventos.getNrocuenta());
                                    cuenta.setEstado(Utils.ACTIVE);
                                    updateEstado(cuenta);
                                }
                            }else{
                                eventos.setSaldo(eventos.getCredito());
                            }
                            eventosRepository.save(eventos);
                            es.setError(0);
                            es.setMensaje("");
                        }else{
                            eventos.setFechahora(new Timestamp((new Date()).getTime()));
                            eventos.setCredito(0);
                            if(!cuentaAccion.getEstado().equalsIgnoreCase(Utils.HOLD)){
                                if(eventosRepository.existsByNrocuenta(eventos.getNrocuenta())){
                                    Eventos lastEvent = eventosRepository.findByNrocuentaOrderByFechahoraDesc(eventos.getNrocuenta()).get(0);
                                    eventos.setSaldo(lastEvent.getSaldo().doubleValue() - eventos.getDebito().doubleValue());
                                    if(eventos.getSaldo().doubleValue()<0){
                                        Cuenta cuenta = new Cuenta();
                                        cuenta.setNroCuenta(eventos.getNrocuenta());
                                        cuenta.setEstado(Utils.HOLD);
                                        updateEstado(cuenta);
                                    }
                                }else{
                                    eventos.setSaldo(0 - eventos.getDebito().doubleValue());
                                    Cuenta cuenta = new Cuenta();
                                    cuenta.setNroCuenta(eventos.getNrocuenta());
                                    cuenta.setEstado(Utils.HOLD);
                                    updateEstado(cuenta);
                                }
                                
                                eventosRepository.save(eventos);
                                es.setError(0);
                                es.setMensaje("");
                            }else{
                                es.setError(90);
                                es.setMensaje("No se puede realizar el retiro ya que la cuenta esta en estado HOLD.");
                            }
                        }
                    }else{
                        es.setError(90);
                        es.setMensaje("El valor de acción no es valido.");
                    }
                }catch(Exception ex){
                    es.setError(500);
                    es.setMensaje("Error Inesperado.");
                } catch (Throwable ex) {
                    es.setError(999);
                    es.setMensaje("Actualizar Estado de Cuenta: "+ ex.getMessage());
                }
            }else{
                es.setError(99);
                es.setMensaje("El tipo de moneda no es igual que de la cuenta.");
            }
        }else{
            es.setError(404);
            es.setMensaje("No existe el número de cuenta para esta acción de "+eventos.getAccion());
        }
        return es;
    }
    
    @Transactional
    public SaldoCuenta getSaldo(int nroCuenta){
        
        SaldoCuenta le = new SaldoCuenta();

        if(cuentaRepository.existsByNrocuenta(nroCuenta)){
            le.setError(0);
            le.setMensaje("");
            if(eventosRepository.existsByNrocuenta(nroCuenta)){
                le.setSaldo(eventosRepository.findByNrocuentaOrderByFechahoraDesc(nroCuenta).get(0).getSaldo());
            }else{
                le.setSaldo(0);
            }
            le.setEstadoCuenta(cuentaRepository.getByNrocuenta(nroCuenta).getEstado());
        }else{
            le.setError(404);
            le.setMensaje("No existe esta cuenta.");
        }
        return le;
    }
    
    @Transactional
    public ListaEventos getEstadosAsc(int nroCuenta){        
        ListaEventos le = new ListaEventos();
        if(cuentaRepository.existsByNrocuenta(nroCuenta)){
            if(eventosRepository.existsByNrocuenta(nroCuenta)){
                le.setListEventos(eventosRepository.findByNrocuentaOrderByFechahoraAsc(nroCuenta));
                le.setError(0);
                le.setMensaje("");
            }else{
                le.setError(404);
                le.setMensaje("No existe transacciones.");
            }
        }else{
            le.setError(404);
            le.setMensaje("No existe esta cuenta.");
        }
        return le;
    }
    
    @Transactional
    public ErrorStatus updateEstado(Cuenta cuenta) throws Throwable{
        logger.info("Aqui ingresa update estado");
        ErrorStatus es = new ErrorStatus();
        if(cuentaRepository.existsByNrocuenta(cuenta.getNrocuenta())){
            try{
                Cuenta acount = cuentaRepository.findById(cuenta.getNrocuenta()).get();
                acount.setEstado(cuenta.getEstado());
                cuentaRepository.save(acount);
                es.setError(0);
                es.setMensaje("");
            }catch(Exception ex){
                throw new Throwable("Error Inesperado.");
            }
        }else{
            throw new Throwable("No existe ese número de cuenta.");
        }
        return es;
    }
}
