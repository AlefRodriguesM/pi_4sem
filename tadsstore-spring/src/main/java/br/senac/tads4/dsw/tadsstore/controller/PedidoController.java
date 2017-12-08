package br.senac.tads4.dsw.tadsstore.controller;

import br.senac.tads4.dsw.tadsstore.common.entity.ItemVenda;
import br.senac.tads4.dsw.tadsstore.common.entity.Venda;
import br.senac.tads4.dsw.tadsstore.common.service.ItemVendaService;
import br.senac.tads4.dsw.tadsstore.common.service.VendaService;
import br.senac.tads4.dsw.tadsstore.model.UsuarioSistema;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @Autowired
    private ItemVendaService serviceItem;
    
    public List<Venda> listaped = new ArrayList<>();

    @RequestMapping
    public ModelAndView listar() {
        listaped = vendaService.listar(0, 100);

        return new ModelAndView("pedido/pedido");
    }

    @RequestMapping("pedidoUsuario")
    public ModelAndView listarPorUsuario() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsuarioSistema usu = (UsuarioSistema) authentication.getPrincipal();

        listaped = vendaService.obterPorUsuario(usu.getId());

        return new ModelAndView("pedido/pedidoUsuario");
    }

    @RequestMapping("Zoom/{id}")
    public ModelAndView listarZoom(@PathVariable("id") Long idVenda) {
        Venda v = vendaService.obter(idVenda);

        List<ItemVenda> itensVenda = new ArrayList<>();

        itensVenda = serviceItem.obter(idVenda);
        
        ModelAndView mav = new ModelAndView("pedido/pedZoom");
                
        mav.addObject("venda", v);
        mav.addObject("itensVenda", itensVenda);

        return mav;
    }

    @RequestMapping("/filtro")
    public ModelAndView abrirFormularioCondicao(@RequestParam("dtDe") String dtDe, @RequestParam("dtAte") String dtAte) {
        listaped = vendaService.obterCondicao(dtDe, dtAte);

        return new ModelAndView("pedido/pedido").addObject("listaped", listaped);
    }

    public List<Venda> getVenda() {
        return listaped;
    }

}
