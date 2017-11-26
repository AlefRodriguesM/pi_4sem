package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.entity.ItemVenda;
import br.senac.tads4.dsw.tadsstore.common.service.ItemService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import br.senac.tads4.dsw.tadsstore.common.service.fakeimpl.ProdutoServiceFakeImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CompraController implements Serializable {

    private ProdutoService service = new ProdutoServiceFakeImpl();
    public List<Produto> carrinho = new ArrayList<>();
    
    @Autowired
    private VendaService servVenda;
  
    @RequestMapping
    private ModelAndView mostrarCarrinho() {
        Venda v = new Venda();

        return new ModelAndView("compra/carrinho").addObject("venda", v);
    }

    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {
        Produto p = service.obter(idProduto);

        carrinho.add(p);

        redirectAttributes.addFlashAttribute("mensagem", "Produto : " + p.getNome() + "  . adicionado com sucesso!!");

        return new ModelAndView("redirect:/compra");
    }

    @RequestMapping("/carrinho")
    public ModelAndView visualizarCarrinho() {
        Venda v = new Venda();

        return new ModelAndView("redirect:/compra").addObject("venda", v);
    }

    public List<Produto> getCarrinho() {
        return carrinho;
    }

    @Autowired
    private VendaService serviceVenda;
    
    @Autowired
    private ItemService serviceItem;
    
    @RequestMapping("/confirmar/{id}")
    public ModelAndView obterPorId(@PathVariable("id") Long idVenda) {
        ModelAndView mav = new ModelAndView("compra/confirmacaoCompra");
        Venda v = serviceVenda.obter(idVenda);
        
        List<ItemVenda> itensVenda = new ArrayList<>();
        
        itensVenda = serviceItem.obter(idVenda);
        
        mav.addObject("venda", v);
        mav.addObject("itensVenda", itensVenda);
        
        return mav;
    }
}
