/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.analista.prueba.repository;

import com.analista.prueba.entity.Cuenta;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Eddy
 */
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
    
    public boolean existsByNrocuenta(int nroCuenta);
    
    public List<Cuenta> findByNrocuenta(int nroCuenta);
    
    public Cuenta getByNrocuenta(int nroCuenta);
    
    
}