package br.senac.tads4.dsw.tadsstorespring.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 *
 * @author alef.rmendes
 */
@Controller
@RequestMapping("/produto")
public class ProdutoController {
    
    private ProdutoService service = new ProdutoServiceFakeImpl();

    @RequestMapping
    public ModelAndView listar(){
        List<Produto> lista = service.listar(0, 100);
        
        return new ModelAndView("produto/lista").addObject("itens", lista);
    }
    
    @RequestMapping("/{id}")
    public ModelAndView obterPorId(@PathVariable("id") Long idProduto){
        Produto p = service.obter(idProduto);
        
        return new ModelAndView("produto/detalhe").addObject("produto", p);
    }
}