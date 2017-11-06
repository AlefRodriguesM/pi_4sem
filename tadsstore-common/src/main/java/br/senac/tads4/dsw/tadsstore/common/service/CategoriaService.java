package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Categoria;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andrey
 */
public interface CategoriaService extends Serializable {

  public List<Categoria> listar();

  public Categoria obter(int id);

}
