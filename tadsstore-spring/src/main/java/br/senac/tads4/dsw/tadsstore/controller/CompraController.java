package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.entity.ItemVenda;
import br.senac.tads4.dsw.tadsstore.common.service.ItemVendaService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @Autowired
    private ProdutoService service;

    @Autowired
    private VendaService serviceVenda;

    @Autowired
    private ItemVendaService serviceItem;

    private List<ItemVenda> carrinho = new ArrayList<>();

    @RequestMapping
    private ModelAndView mostrarCarrinho() {
        Venda v = new Venda();

        return new ModelAndView("compra/carrinho").addObject("venda", v);
    }

    @RequestMapping("/adicionar/{id}")
    public ModelAndView adicionarProduto(@PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {

        Produto p = service.obter(idProduto);
        ItemVenda ite = new ItemVenda();
        
        if (p.getQuantidade() <= 0) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Produto " + p.getNome() + " sem estoque disponível!");
        } else {
            ite.setProduto(p.getId());
            ite.setQtVenda(1);
            ite.setVlPreuni(p.getPreco());
            ite.setVlTotal(ite.getVlPreuni() * ite.getQtVenda());

            carrinho.add(ite);

            redirectAttributes.addFlashAttribute("mensagem", "Produto : " + p.getNome() + " adicionado com sucesso!");
        }

        return new ModelAndView("redirect:/compra");
    }

    @RequestMapping("/carrinho")
    public ModelAndView visualizarCarrinho() {
        Venda venda = new Venda();
        
        int tipoFrete = 1;
        
        for (ItemVenda ite : carrinho) {
            venda.setVlProdutos(venda.getVlProdutos() + ite.getVlTotal());
        }
        
        if (tipoFrete <= 1) {
            venda.setVlFrete(20.99);
        }else{
            venda.setVlFrete(15.99);
        }
        
        venda.setVlTotal(venda.getVlProdutos() + venda.getVlFrete());

        ModelAndView mod = new ModelAndView("/compra");
        mod.addObject("venda", venda);

        return mod;
    }

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

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public ModelAndView salvar(
            @ModelAttribute("venda") Venda v,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    //@RequestParam("optFrete") String optFrete
    ) {

        ModelAndView mav = new ModelAndView("compra/compraDetalhesUser");
        List<ItemVenda> itensVenda;

        if (carrinho.isEmpty()) {
            redirectAttributes.addFlashAttribute("mensagem", "Não é possível salvar venda sem itens !!");
            return new ModelAndView("redirect:/produto/lista");
        }

        v.setDtVenda(new Date());
        v.setComprador(Long.MIN_VALUE);

        serviceVenda.incluir(v);
        v = serviceVenda.obterUltima();

        for (ItemVenda ite : carrinho) {
            ite.setPedido(v.getId());
            ite.setDtMovimento(v.getDtVenda());

            serviceItem.incluir(ite);
        }

        carrinho.clear();

        itensVenda = serviceItem.obter(v.getId());

        mav.addObject("venda", v);
        mav.addObject("itensVenda", itensVenda);

        redirectAttributes.addFlashAttribute("msgSucesso",
                "Venda " + v.getNumero() + " finalizada com sucesso");
        return mav;
    }

    public List<ItemVenda> getCarrinho() {
        return carrinho;
    }
}
