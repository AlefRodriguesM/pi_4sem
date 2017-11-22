package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.ItemVenda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andrey.asantos1
 */
public interface ItemService extends Serializable {
    public List<ItemVenda> listar(int offset, int quantidade);

    public List<ItemVenda> obter(long id);

    public void incluir(ItemVenda i);

    public void alterar(ItemVenda i);

    public void remover(long id);
}
