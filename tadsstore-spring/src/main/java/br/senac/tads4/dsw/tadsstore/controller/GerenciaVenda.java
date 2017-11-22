package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.repository.VendaServiceJPAImpl;

import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import java.util.Date;
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
            @ModelAttribute("venda") Venda v,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        
        v.setDtVenda(new Date());
        
        vendaService.incluir(v);
        
        redirectAttributes.addFlashAttribute("msgSucesso",
                "Venda " + v.getNumero() + " finalizada com sucesso");
        return new ModelAndView("redirect:/produto");
    }
    
    @RequestMapping(value = "/atualizar/{id}", method = RequestMethod.POST)
    public ModelAndView atualizar(
            @ModelAttribute("venda") Venda v,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            @RequestParam("status") String status) {
        
        v = vendaService.obter(v.getId());
        
        v.setDtAlteracao(new Date());
        v.setStatus(Integer.parseInt(status));
        
        vendaService.alterar(v);
        
        redirectAttributes.addFlashAttribute("msgSucesso",
                "Status da venda alterado com sucesso");
        return new ModelAndView("redirect:/pedido");
    }

    List<Venda> listar(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet GERENCIAVENDA LISTAR."); //To change body of generated methods, choose Tools | Templates.
    }
}
