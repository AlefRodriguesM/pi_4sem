/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
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
public class VendaServiceJPAImpl implements VendaService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Venda> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT v FROM Venda v ");
        return query.getResultList();
    }

    @Override
    public Venda obter(long idVenda) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT v FROM Venda v "
                + "WHERE v.id = :idVenda")
                .setParameter("idVenda", idVenda);
        return (Venda) query.getSingleResult();
    }
    
    @Override
    public Venda obterUltima() {
        Query query = entityManager.createQuery(
                "SELECT MAX(v.id) FROM Venda v ");
        return (Venda) query.getSingleResult();
    } 

    @Override
    @Transactional
    public void incluir(Venda v) {
        entityManager.persist(v);
    }

    @Override
    @Transactional
    public void alterar(Venda v) {
        entityManager.merge(v);
    }

    @Override
    public void remover(long idVenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
