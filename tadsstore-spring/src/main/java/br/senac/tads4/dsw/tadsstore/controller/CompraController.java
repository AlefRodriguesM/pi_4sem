package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author alef.rmendes
 */
@Controller
@RequestMapping("/compra")
@Scope("session")
public class CompraController implements Serializable{
    private ProdutoService service = new ProdutoServiceFakeImpl();
    
    private List<Produto> carrinho = new ArrayList<>();
    
    @RequestMapping
    private ModelAndView mostrarCarrinho(){
        return new ModelAndView("compra/carrinho");
    }
    
    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes){
        Produto p = service.obter(idProduto);
        
        carrinho.add(p);
        
        redirectAttributes.addFlashAttribute("mensagem", "Produto : " + p.getNome() + "  . adicionado com sucesso!!");
        
        return new ModelAndView("redirect:/compra");
    }
    
    @RequestMapping("/carrinho")
    public ModelAndView visualizarCarrinho(){   
        return new ModelAndView("redirect:/compra");
    }
    
    public List<Produto> getCarrinho(){
        return carrinho;
    }
    
   
    
    public List<Venda> getVenda(){
        List<Venda> venda = null;
        return venda;
    }
}