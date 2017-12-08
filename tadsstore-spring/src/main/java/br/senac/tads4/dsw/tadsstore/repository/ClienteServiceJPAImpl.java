package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import java.util.ArrayList;
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
public class ClienteServiceJPAImpl implements ClienteService {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cliente> listar(int offset, int quantidade) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Cliente c ");
        return query.getResultList();
    }

    @Override
    public Cliente obter(long idCliente) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Cliente c "
                + "WHERE c.id = :idCliente")
                .setParameter("idCliente", idCliente);
        return (Cliente) query.getSingleResult();
    }

    public Cliente obterByUsername(String username) {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Cliente c "
                + "WHERE c.email = :username")
                .setParameter("username", username);
        
        return (Cliente) query.getSingleResult();
    }

    public ArrayList<Cliente> obterTodos() {
        Query query = entityManager.createQuery(
                "SELECT DISTINCT c FROM Cliente c ");
        return (ArrayList<Cliente>) query.getResultList();
    }

    @Override
    @Transactional
    public void incluir(Cliente c) {
        entityManager.persist(c);
    }

    @Override
    @Transactional
    public void alterar(Cliente c) {
        entityManager.merge(c);
    }

    @Override
    @Transactional
    public void remover(long idCliente) {
        Cliente c = entityManager.find(Cliente.class, idCliente);
        entityManager.remove(c);
    }
}
