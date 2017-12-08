package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/gerenciamento/cliente")
public class GerenciaClienteController {

    @Autowired
    private ClienteService clienteService;

    private List<Cliente> listaClientes = new ArrayList();

    @RequestMapping("/lista")
    public ModelAndView listarTabela() {
        listaClientes = clienteService.listar(0, 100);

        return new ModelAndView("cliente/lista").addObject("listaClientes", listaClientes);
    }

    @RequestMapping(path = "/excluir/{idCli}")
    public ModelAndView excluir(@PathVariable("idCli") Long idCliente, RedirectAttributes redirectAttributes) {
        clienteService.remover(idCliente);

        return new ModelAndView("redirect:/gerenciamento/cliente/lista");
    }
}
