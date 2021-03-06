/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.common.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author andrey.asantos1
 */
public interface VendaService extends Serializable {
    public List<Venda> listar(int offset, int quantidade);

    public List<Venda> obterCondicao(String dtDe, String dtAte);
    
    public Venda obter(Long idVenda);
    
    public Venda obterUltima();

    public void incluir(Venda v);

    public void alterar(Venda v);

    public void remover(long idVenda);
    
    public List<Venda> obterPorUsuario(long idComprador);
}
