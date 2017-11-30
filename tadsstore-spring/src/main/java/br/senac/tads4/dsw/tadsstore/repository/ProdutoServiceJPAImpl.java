/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
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
public class ProdutoServiceJPAImpl implements ProdutoService{   
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT p FROM Produto p ");
        return query.getResultList();
    }
    
    @Override
    public Produto obter(long idProduto) {
    Query query = entityManager.createQuery(
            "SELECT DISTINCT p FROM Produto p "
            + "WHERE p.id = :idProduto")
            .setParameter("idProduto", idProduto);
    return (Produto) query.getSingleResult();
  }

    @Override
    @Transactional
    public void incluir(Produto p) {
        entityManager.persist(p);
    }

    @Override
    @Transactional
    public void alterar(Produto p) {
        entityManager.merge(p);
    }

    @Override
    @Transactional
    public void remover(long idProduto) {
        Produto p = entityManager.find(Produto.class, idProduto);
        entityManager.remove(p);
    }
}
