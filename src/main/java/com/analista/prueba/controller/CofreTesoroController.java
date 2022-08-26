/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.controller;

import com.analista.prueba.dto.ConsultaReqDto;
import com.analista.prueba.dto.ConsultaResDto;
import com.analista.prueba.dto.ErrorStatus;
import com.analista.prueba.dto.NuevaCuentaReqDto;
import com.analista.prueba.dto.NuevaCuentaResDto;
import com.analista.prueba.dto.TransaccionReqDto;
import com.analista.prueba.dto.TransaccionResDto;
import com.analista.prueba.dto.SaldoCuenta;
import com.analista.prueba.entity.Cuenta;
import com.analista.prueba.entity.Eventos;
import com.analista.prueba.dto.ListaEventos;
import com.analista.prueba.service.CuentaService;
import com.analista.prueba.service.EventosService;
import com.analista.prueba.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Eddy
 */

@RestController
@RequestMapping("/cofretesoro")
@CrossOrigin(origins = "*")
public class CofreTesoroController {
    
    @Autowired
    CuentaService cuentaService;
    
    @Autowired
    EventosService eventosService;
    
    @PostMapping("/crearCuenta")
    public ResponseEntity<?> createCuenta(@RequestBody NuevaCuentaReqDto req){
        
        if(req.getNroCuenta()<=0){
            return new ResponseEntity(new ErrorStatus(99, "Número de cuenta no es válido"),HttpStatus.BAD_REQUEST);
        }else if(req.getNombres()==null){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso el Nombre"),HttpStatus.BAD_REQUEST);
            
        }else if(req.getNombres().equals("")){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso el Nombre"),HttpStatus.BAD_REQUEST);    
        }else if(req.getApellidos()== null){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso Apellidos"),HttpStatus.BAD_REQUEST);
        }else if(req.getApellidos().equals("")){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso Apellidos"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda()==null){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso Moneda"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda().equals("")){
            return new ResponseEntity(new ErrorStatus(99, "No se ingreso Moneda"),HttpStatus.BAD_REQUEST);
        }
        
        Cuenta cuenta = new Cuenta(req.getNroCuenta(), 
                req.getNombres(), 
                req.getApellidos(), 
                req.getTipoDocumento(), 
                req.getNroDocumento(), 
                req.getNroTelefono(), 
                req.getEmail(), 
                "", 
                req.getMoneda());
        ErrorStatus err = cuentaService.createCuenta(cuenta);
        NuevaCuentaResDto res = new NuevaCuentaResDto();
        res.setError(0);
        res.setMensaje(err.getMensaje());
        if(err.getError()==0){
            res.setMoneda(req.getMoneda());
            res.setNroCuenta(req.getNroCuenta());
            return new ResponseEntity(res, HttpStatus.OK);
        }
        return new ResponseEntity(res, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    
    @PostMapping("/depositarDinero")
    public ResponseEntity<?> depositarDinero(@RequestBody TransaccionReqDto req){
        if(req.getNroCuenta()<=0){
            return new ResponseEntity(new ErrorStatus(99, "Número de cuenta no es válido"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda()==null){
            return new ResponseEntity(new ErrorStatus(99, "Moneda no es válida"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda().length()==0){
            return new ResponseEntity(new ErrorStatus(99, "Moneda no es valida"),HttpStatus.BAD_REQUEST);
        }else if(req.getMonto().doubleValue() == 0){
            return new ResponseEntity(new ErrorStatus(99, "El monto debe ser mayor a 0"),HttpStatus.BAD_REQUEST);
        }
        
        
        Eventos event = new Eventos();
        event.setAccion(Utils.CREDITO);
        event.setConcepto(req.getConcepto());
        event.setCredito(req.getMonto());
        event.setDebito(0);
        event.setMoneda(req.getMoneda());
        event.setNrocuenta(req.getNroCuenta());
        
        ErrorStatus err = eventosService.createEventos(event);
        
        TransaccionResDto res = new TransaccionResDto();
        res.setError(err.getError());
        res.setMensaje(err.getMensaje());
        
        if(err.getError()==0){
            SaldoCuenta sc = eventosService.getSaldo(req.getNroCuenta());
            if(sc.getError()==0){
                res.setEstadoCuenta(cuentaService.getCuenta(req.getNroCuenta()).getEstado());
                res.setSaldo(sc.getSaldo());
            }else{
                res.setError(sc.getError());
                res.setMensaje(sc.getMensaje());
            }
        }
        
        return new ResponseEntity(res, HttpStatus.OK);
        
    }
        
    @PostMapping("/retirarDinero")
    public ResponseEntity<?> retirarDinero(@RequestBody TransaccionReqDto req){
        if(req.getNroCuenta()<=0){
            return new ResponseEntity(new ErrorStatus(99, "Número de cuenta no es válido"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda()==null){
            return new ResponseEntity(new ErrorStatus(99, "Moneda no es válida"),HttpStatus.BAD_REQUEST);
        }else if(req.getMoneda().length()==0){
            return new ResponseEntity(new ErrorStatus(99, "Moneda no es valida"),HttpStatus.BAD_REQUEST);
        }else if(req.getMonto().doubleValue() == 0){
            return new ResponseEntity(new ErrorStatus(99, "El monto debe ser mayor a 0"),HttpStatus.BAD_REQUEST);
        }
        
        Eventos event = new Eventos();
        event.setAccion(Utils.DEBITO);
        event.setConcepto(req.getConcepto());
        event.setCredito(0);
        event.setDebito(req.getMonto());
        event.setMoneda(req.getMoneda());
        event.setNrocuenta(req.getNroCuenta());
        
        ErrorStatus err = eventosService.createEventos(event);
        
        TransaccionResDto res = new TransaccionResDto();
        res.setError(err.getError());
        res.setMensaje(err.getMensaje());
        
        if(err.getError()==0){
            SaldoCuenta sc = eventosService.getSaldo(req.getNroCuenta());
            if(sc.getError()==0){
                res.setEstadoCuenta(cuentaService.getCuenta(req.getNroCuenta()).getEstado());
                res.setSaldo(sc.getSaldo());
            }else{
                res.setError(sc.getError());
                res.setMensaje(sc.getMensaje());
            }
        }
        
        return new ResponseEntity(res, HttpStatus.OK);
        
    }    
        
    @PostMapping("/saldo")
    public ResponseEntity<?> saldo(@RequestBody ConsultaReqDto req){  
        if(req.getNroCuenta()<=0){
            return new ResponseEntity(new ErrorStatus(99, "Número de cuenta no es válido"),HttpStatus.BAD_REQUEST);
        }
        
        ConsultaResDto res = new ConsultaResDto();
        SaldoCuenta saldoC = eventosService.getSaldo(req.getNroCuenta());
        res.setError(saldoC.getError());
        res.setMensaje(saldoC.getMensaje());
        if(saldoC.getError() == 0){
            res.setSaldo(saldoC.getSaldo()); 
            res.setEstadoCuenta(saldoC.getEstadoCuenta());
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }
        
    @PostMapping("/historico")
    public ResponseEntity<?> historico(@RequestBody ConsultaReqDto req){  
        if(req.getNroCuenta()<=0){
            return new ResponseEntity(new ErrorStatus(99, "Número de cuenta no es válido"),HttpStatus.BAD_REQUEST);
        }
        
        ConsultaResDto res = new ConsultaResDto();
        SaldoCuenta saldoC = eventosService.getSaldo(req.getNroCuenta());
        res.setError(saldoC.getError());
        res.setMensaje(saldoC.getMensaje());
        if(saldoC.getError() == 0){
            res.setSaldo(saldoC.getSaldo());
            res.setEstadoCuenta(saldoC.getEstadoCuenta());
            ListaEventos lEvents = eventosService.getEstadosAsc(req.getNroCuenta());
            res.setError(lEvents.getError());
            res.setMensaje(lEvents.getMensaje());
            if(lEvents.getError()==0){
                res.setHistorico(lEvents.getListEventos());
            }
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }
}
