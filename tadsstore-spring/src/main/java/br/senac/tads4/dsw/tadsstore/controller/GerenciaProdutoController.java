package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Movimento;
import java.util.Date;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.MovimentoService;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gerenciamento/produto")
public class GerenciaProdutoController {

    @Autowired
    private ProdutoService produtoService;
    
    @Autowired
    private MovimentoService movimentoService;
    
    private List<Produto> listaProdutos = new ArrayList();

    @RequestMapping
    public ModelAndView abrirFormulario() {
        return new ModelAndView("produto/input")
                .addObject("produto", new Produto());
    }

    @RequestMapping("/{idProd}")
    public ModelAndView editar(@PathVariable("idProd") Long idProduto) {
        Produto p = produtoService.obter(idProduto);

        return new ModelAndView("produto/input").addObject("produto", p);
    }

    @RequestMapping(value = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@ModelAttribute("produto") @Valid Produto p, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        p.setDtCadastro(new Date());

        if (p.getId() == null) {
            produtoService.incluir(p);
        } else {
            produtoService.alterar(p);
        }

        return new ModelAndView("redirect:/produto/itens");
    }

    @RequestMapping(path = "/excluir/{idProd}")
    public ModelAndView excluir(@PathVariable("idProd") Long idProduto, RedirectAttributes redirectAttributes) {
        produtoService.remover(idProduto);

        return new ModelAndView("redirect:/produto/itens");
    }

    @RequestMapping("/estoque")
    public ModelAndView listarProdEstoque() {
        listaProdutos = produtoService.listar(0, 100);

        return new ModelAndView("estoque/listaEstoque").addObject("listaProdutos", listaProdutos);
    }

    @RequestMapping(path = "/atualizarestoque/{idProd}")
    public ModelAndView atualizarEstoque(
            @PathVariable("idProd") Long idProduto,
            @RequestParam("qtMovimento") int qtMovimento
            ) {
        
        String tgMovimento = "";
        int idPed = 0;
        
        if (qtMovimento < 0) {
            tgMovimento = "S";
        }else{
            tgMovimento = "E";
        }
        
        qtMovimento = Math.abs(qtMovimento);
        
        Movimento m = new Movimento();
        
        m.setDhMovimento(new Date());
        m.setIdProduto(idProduto);
        m.setQtMovimento(qtMovimento);
        m.setTgMovimento(tgMovimento);
        m.setIdPedido(Long.parseLong("0"));
        
        movimentoService.incluir(m);
        
        return new ModelAndView("redirect:/gerenciamento/produto/estoque");
    }
}