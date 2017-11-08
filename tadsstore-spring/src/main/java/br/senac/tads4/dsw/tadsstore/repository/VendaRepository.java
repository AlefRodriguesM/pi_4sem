/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.senac.tads4.dsw.tadsstore.common.entity.Venda;

/**
 *
 * @author andrey.asantos1
 */
public interface VendaRepository extends CrudRepository<Venda, Long> {
    
}
