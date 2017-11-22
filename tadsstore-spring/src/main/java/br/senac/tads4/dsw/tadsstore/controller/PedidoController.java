package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thais
 */
@Controller
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private VendaService vendaService;
    
    public List<Venda> listaped = new ArrayList<>();
    
    @RequestMapping
    public ModelAndView listar(){
        listaped = vendaService.listar(0, 100);
        
        return new ModelAndView("pedido/pedido");
    }
    
    public List<Venda> getVenda(){
        return listaped;
    }

}
