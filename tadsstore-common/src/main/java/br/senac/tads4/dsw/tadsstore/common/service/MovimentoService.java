package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Movimento;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andrey
 */
public interface MovimentoService extends Serializable {
  public List<Movimento> listar(int offset, int quantidade);
  
  public List<Movimento> listarProdutos(int offset, int quantidade, long idProduto);
  
  public List<Movimento> listarProdutosDoPedido(int offset, int quantidade, long idPedido);
  
  public Movimento obter(long idMovimento);

  public void incluir(Movimento m);
}
