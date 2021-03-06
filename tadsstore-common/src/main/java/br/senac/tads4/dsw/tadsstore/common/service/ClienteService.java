package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface ClienteService extends Serializable {
    public List<Cliente> listar(int offset, int quantidade);

    public Cliente obter(long idCliente);
    
    public Cliente obterByUsername(String username);
    
    public Cliente obterByEmail(String username);

    public ArrayList<Cliente> obterTodos();

    public void incluir(Cliente c);

    public void alterar(Cliente c);

    public void remover(long idCliente);
}
