/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.ItemVenda;
import br.senac.tads4.dsw.tadsstore.common.service.ItemVendaService;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author andrey.asantos1
 */
@Repository
public class ItemVendaServiceJPAImpl implements ItemVendaService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<ItemVenda> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT i FROM ItemVenda i ");
        return query.getResultList();
    }
    
    @Override
    public List<ItemVenda> obter(long idVenda) {
    Query query = entityManager.createQuery(
            "SELECT DISTINCT i FROM ItemVenda i "
            + "WHERE i.pedido = :idVenda")
            .setParameter("idVenda", idVenda);
    return query.getResultList();
  }

    @Override
    @Transactional
    public void incluir(ItemVenda v) {
        entityManager.persist(v);
    }

    @Override
    @Transactional
    public void alterar(ItemVenda v) {
        entityManager.merge(v);
    }

    @Override
    public void remover(long idVenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
