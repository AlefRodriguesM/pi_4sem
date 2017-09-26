package br.senac.tads4.dsw.tadsstorespring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alef.rmendes
 */
@Controller
@RequestMapping("/compra")
@Scope("session")
public class CompraController implements Serializable{
    private ProdutoService service = new ProdutoServiceFakeImpl();
    
    private List<Produto> carrinho = new ArrayList<Produto>();
    
    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto){
        Produto p = service.obter(idProduto);
        
        carrinho.add(p);
        
        return new ModelAndView("compra/carrinho");
    }
    @RequestMapping("/carrinho")
    public ModelAndView visualizarCarrinho(){   
        return new ModelAndView("compra/carrinho");
    }
    
    public List<Produto> getCarrinho(){
        return carrinho;
    }
}