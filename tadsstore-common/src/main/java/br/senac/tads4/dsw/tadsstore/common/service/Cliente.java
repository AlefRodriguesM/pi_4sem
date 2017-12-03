package br.senac.tads4.dsw.tadsstore.common.service;

import java.io.Serializable;
import java.util.List;

public interface Cliente extends Serializable {
    public List<Cliente> listar(int offset, int quantidade);

    public List<Cliente> obter(long id);

    public void incluir(Cliente c);

    public void alterar(Cliente c);

    public void remover(long id);
}
