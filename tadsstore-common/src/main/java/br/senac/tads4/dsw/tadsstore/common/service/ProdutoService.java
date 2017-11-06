package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andrey
 */
public interface ProdutoService extends Serializable {

  public List<Produto> listar(int offset, int quantidade);

  public List<Produto> listarPorCategoria(Categoria categoria, int offset, int quantidade);

  public Produto obter(long idProduto);

  public void incluir(Produto p);

  public void alterar(Produto p);

  public void remover(long idProduto);
}
