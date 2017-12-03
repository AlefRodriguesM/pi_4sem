package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author alef.rmendes
 */
@Controller
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService ClienteService;
    
    private List<Cliente> listaClientes = new ArrayList();
    
    @RequestMapping("/lista")
    public ModelAndView listarTabela(){
        listaClientes = ClienteService.listar(0, 100);
        
        return new ModelAndView("cliente/lista").addObject("listaClientes", listaClientes);
    }
}