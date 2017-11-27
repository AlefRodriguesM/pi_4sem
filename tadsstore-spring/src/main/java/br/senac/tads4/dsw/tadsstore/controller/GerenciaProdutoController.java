package br.senac.tads4.dsw.tadsstore.controller;

import java.util.Date;
import br.senac.tads4.dsw.tadsstore.common.entity.Produto;
import br.senac.tads4.dsw.tadsstore.common.service.ProdutoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gerenciamento/produto")
public class GerenciaProdutoController {

  @Autowired
  private ProdutoService produtoService;
  
  @RequestMapping
  public ModelAndView abrirFormulario() {
    return new ModelAndView("produto/input")
	    .addObject("produto", new Produto());
  }
  
  @RequestMapping("/{idProd}")
  public ModelAndView editar(@PathVariable("idProd")Long idProduto) {
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
}