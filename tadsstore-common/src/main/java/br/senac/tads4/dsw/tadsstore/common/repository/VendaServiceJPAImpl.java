/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andrey.asantos1
 */
@Repository
public class VendaServiceJPAImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Venda> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT v FROM Venda v ");
        return query.getResultList();
    }
    
    public Venda obter(long idVenda) {
    Query query = entityManager.createQuery(
            "SELECT DISTINCT v FROM Venda v "
            + "WHERE v.id = :idVenda")
            .setParameter("idVenda", idVenda);
    return (Venda) query.getSingleResult();
  }
}
