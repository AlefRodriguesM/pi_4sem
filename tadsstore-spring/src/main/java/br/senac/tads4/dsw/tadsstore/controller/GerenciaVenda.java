package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
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
@RequestMapping("/gerenciamento/venda")
public class GerenciaVenda {

  @Autowired
  private VendaService vendaService;

  @RequestMapping
  public ModelAndView abrirFormulario() {
    return new ModelAndView("venda/input")
            .addObject("venda", new Venda());
  }

  @RequestMapping("/{id}")
  public ModelAndView abrirAlteracao(@PathVariable("id") Long idVenda) {
    Venda v = vendaService.obter(idVenda);
    return new ModelAndView("venda/input")
            .addObject("venda", v);
  }

  @RequestMapping(value = "/{id}/remover", method = RequestMethod.POST)
  public ModelAndView removerProduto(@PathVariable("id") Long idVenda) {
    vendaService.remover(idVenda);
    return new ModelAndView("redirect:/gerenciamento/venda");
  }

  @RequestMapping(value = "/salvar", method = RequestMethod.POST)
  public ModelAndView salvar(
          @ModelAttribute("venda") @Valid Venda v,
          BindingResult bindingResult,
          RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      return new ModelAndView("venda/input");
    }
    boolean inclusao = (v.getId() == null);
    v.setDtVenda(new Date());

    if (inclusao) {
      vendaService.incluir(v);
    } else {
      vendaService.alterar(v);
    }

    redirectAttributes.addFlashAttribute("msgSucesso",
            "Venda " + v.getId() + " cadastrada com sucesso");
    return new ModelAndView("redirect:/gerenciamento/venda");
  }

}
