package br.senac.tads4.dsw.tadsstore.controller;

import java.util.Date;
import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
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
@RequestMapping("/gerenciamento/cliente")
public class GerenciaClienteController {

    @Autowired
    private ClienteService clienteService;
    
    @RequestMapping
    public ModelAndView abrirFormulario() {
        return new ModelAndView("cliente/input").addObject("cliente", new Cliente());
    }

    @RequestMapping("/{idCli}")
    public ModelAndView editar(@PathVariable("idCli") Long idCliente) {
        Cliente c = clienteService.obter(idCliente);

        return new ModelAndView("cliente/input").addObject("cliente", c);
    }

    @RequestMapping(value = "/incluir", method = RequestMethod.POST)
    public ModelAndView incluir(@ModelAttribute("cliente") @Valid Cliente c, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (c.getId() == null) {            
            c.setDtCadastro(new Date());
            
            c.setSenha(c.stringToHash(c.getSenha()));
            
            clienteService.incluir(c);
        } else {
            Cliente cAntigo = clienteService.obter(c.getId());
            
            if(!c.getSenha().equals("")){
                c.setSenha(c.stringToHash(c.getSenha()));
            }else{
                c.setSenha(cAntigo.getSenha());
            }
            
            c.setDtCadastro(cAntigo.getDtCadastro());
            
            clienteService.alterar(c);
        }

        return new ModelAndView("redirect:/cliente/lista");
    }

    @RequestMapping(path = "/excluir/{idCli}")
    public ModelAndView excluir(@PathVariable("idCli") Long idCliente, RedirectAttributes redirectAttributes) {
        clienteService.remover(idCliente);

        return new ModelAndView("redirect:/cliente/lista");
    }
}