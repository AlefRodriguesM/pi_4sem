/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author thais
 */
@Controller
@RequestMapping("/compra")
public class ConsultaController {
    private GerenciaVenda service = new GerenciaVenda();
    private List<Venda> lista = new ArrayList<>();
    
    @RequestMapping("/pedido")
    public ModelAndView listar(){
        return new ModelAndView("/compra/pedido").addObject("itens", lista);
    }
    

}
