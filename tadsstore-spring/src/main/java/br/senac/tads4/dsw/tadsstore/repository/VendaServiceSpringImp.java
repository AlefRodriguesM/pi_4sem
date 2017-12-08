package br.senac.tads4.dsw.tadsstore.repository;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author andrey.asantos1
 */
public class VendaServiceSpringImp implements VendaService {

    @Autowired
    private VendaRepository repo;

    public List<Venda> listar(int offset, int quantidade) {
        Iterable<Venda> vendas = repo.findAll();
        Iterator it = vendas.iterator();
        List<Venda> lista = new ArrayList<Venda>();
        while (it.hasNext()) {
            Venda p = (Venda) it.next();
            lista.add(p);
        }
        return lista;
    }

    @Override
    public Venda obter(Long idVenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venda> obterCondicao(String dtDe, String dtAte) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Venda obterUltima() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void incluir(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void alterar(Venda v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remover(long idVenda) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
