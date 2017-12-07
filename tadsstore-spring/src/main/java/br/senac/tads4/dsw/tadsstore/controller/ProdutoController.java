package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alef.rmendes
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService Produtoservice;
    
    private Produto p = new Produto();
    
    private List<Produto> listaProdutos = new ArrayList();
    
    @RequestMapping
    public ModelAndView listar(){
        listaProdutos = Produtoservice.listar(0, 100);
        
        // tratamento para não estourar exibição dos campos da tela.
        for (Produto pro : listaProdutos) {
            if (pro.getNome().length() > 45) {
                pro.setNome(pro.getNome().substring(0, 45) + "...");
            }
            
            if (pro.getDescricaoResumida().length() > 133) {
                pro.setDescricao(pro.getDescricaoResumida().substring(0, 133) + "...");
            }
        }
        
        return new ModelAndView("produto/lista").addObject("itens", listaProdutos);
    }
    
    @RequestMapping("/{id}")
    public ModelAndView obterPorId(@PathVariable("id") Long idProduto){
        p = Produtoservice.obter(idProduto);
        
        return new ModelAndView("produto/detalhe").addObject("produto", p);
    }
    
    @RequestMapping("/itens")
    public ModelAndView listarTabela(){
        listaProdutos = Produtoservice.listar(0, 100);
        
        return new ModelAndView("produto/itens").addObject("listaProdutos", listaProdutos);
    }
    
    @RequestMapping("/filtro")
    public ModelAndView abrirFormularioCondicao(@RequestParam("busca") String condicao) {
        listaProdutos = Produtoservice.obterCondicao(condicao);

        return new ModelAndView("produto/lista").addObject("itens", listaProdutos);
    }
}