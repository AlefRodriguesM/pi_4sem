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
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private ProdutoService serviceProduto;

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

        Produto p = serviceProduto.obter(idProduto);
        ItemVenda ite = new ItemVenda();

        for (ItemVenda i : carrinho) {
            if (Objects.equals(i.getProduto(), idProduto)) {
                redirectAttributes.addFlashAttribute("mensagemErro", "O produto " + p.getNome() + " já estava no seu carrinho!");
                return new ModelAndView("redirect:/compra/carrinho");
            }
        }

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

        return new ModelAndView("redirect:/compra/carrinho");
    }

    @RequestMapping("/alterar/{id}")
    public ModelAndView alterarProduto(
            @PathVariable("id") Long idProduto,
            @RequestParam("quantidade") String quantidade,
            RedirectAttributes redirectAttributes) {

        Produto p = serviceProduto.obter(idProduto);
        ItemVenda ite = new ItemVenda();

        int qtAlterar = 0;
        
        try {
            qtAlterar = Math.abs(Integer.parseInt(quantidade));
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Quantidade de compra inválida!");

            return new ModelAndView("redirect:/compra/carrinho");
        }

        // quantidade no carrinho não pode ser menor que 1
        if (qtAlterar < 1) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Quantidade de compra não pode ser menor que 1!");

            return new ModelAndView("redirect:/compra/carrinho");
        }

        if (p.getQuantidade() <= 0) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Produto " + p.getNome() + " sem estoque disponível. Ele foi removido do carrinho.");

            for (ItemVenda i : carrinho) {
                if (i.getProduto() == p.getId()) {
                    carrinho.remove(i);

                    break;
                }
            }

            return new ModelAndView("redirect:/compra/carrinho");

        } else if (p.getQuantidade() < qtAlterar) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Quantidade informada indisponível. Quantidade máxima: " + p.getQuantidade());

            qtAlterar = p.getQuantidade();
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Quantidade do produto : " + p.getNome() + " alterada com sucesso!");
        }

        for (ItemVenda i : carrinho) {
            if (i.getProduto() == p.getId()) {
                i.setQtVenda(qtAlterar);
                i.setVlTotal(i.getQtVenda() * i.getVlPreuni());
            }
        }

        return new ModelAndView("redirect:/compra/carrinho");
    }

    @RequestMapping("/remover/{id}")
    public ModelAndView removerProduto(
            @PathVariable("id") Long idProduto,
            RedirectAttributes redirectAttributes) {

        for (ItemVenda i : carrinho) {
            if (Objects.equals(i.getProduto(), idProduto)) {
                carrinho.remove(i);

                break;
            }
        }

        redirectAttributes.addFlashAttribute("mensagem", "Produto " + idProduto + " removido.");

        return new ModelAndView("redirect:/compra/carrinho");
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
        } else {
            venda.setVlFrete(15.99);
        }

        venda.setVlTotal(venda.getVlProdutos() + venda.getVlFrete());

        ModelAndView mod = new ModelAndView("compra/carrinho");
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
            @RequestParam("formapag") String formaPag,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        ModelAndView mav = new ModelAndView("compra/compraDetalhesUser");
        List<ItemVenda> itensVenda;

        if (carrinho.isEmpty()) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Não é possível finalizar uma venda sem itens!");
            return new ModelAndView("redirect:/compra/carrinho");
        }

        for (ItemVenda ite : carrinho) {
            Produto p = new Produto();

            p = serviceProduto.obter(ite.getProduto());

            if (p.getQuantidade() <= 0 || p.getQuantidade() < ite.getQtVenda()) {
                if (p.getQuantidade() <= 0) {
                    redirectAttributes.addFlashAttribute("mensagemErro", "O produto " + p.getId() + " - " + p.getNome() + " está com o estoque indisponível e foi removido do carrinho.");

                    carrinho.remove(ite);

                    break;
                } else {
                    redirectAttributes.addFlashAttribute("mensagemErro", "O produto " + p.getId() + " - " + p.getNome() + " não possui " + ite.getQtVenda() + " unidades em estoque. Sua quantidade foi alterada.");

                    ite.setQtVenda(p.getQuantidade());
                }

                return new ModelAndView("redirect:/compra/carrinho");
            }
        }

        v.setDtVenda(new Date());
        v.setComprador(Long.MIN_VALUE);
        v.setFormapag(formaPag);

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
