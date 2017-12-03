/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Movimento;
import br.senac.tads4.dsw.tadsstore.common.service.MovimentoService;
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
public class MovimentoServiceJPAImpl1 implements MovimentoService{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Movimento> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT m FROM Movimento m ");
        return query.getResultList();
    }
    
    @Override
    public List<Movimento> listarProdutos(int offset, int quantidade, long idProduto) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT m FROM Movimento m "
                + "WHERE m.idProduto = :idProduto ORDER BY m.dhMovimento DESC").setParameter("idProduto", idProduto);
        return query.getResultList();
    }
    
    @Override
    public List<Movimento> listarProdutosDoPedido(int offset, int quantidade, long idPedido) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT m FROM Movimento m "
                + "WHERE m.idPedido = :idPedido").setParameter("idPedido", idPedido);
        return query.getResultList();
    }
    
    @Override
    public Movimento obter(long idMovimento) {
    Query query = entityManager.createQuery(
            "SELECT DISTINCT m FROM Movimento m "
            + "WHERE m.id = :idMovimento")
            .setParameter("idMovimento", idMovimento);
    return (Movimento) query.getSingleResult();
  }

    @Override
    @Transactional
    public void incluir(Movimento m) {
        entityManager.persist(m);
    }
}
