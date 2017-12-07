package br.senac.tads4.dsw.tadsstore.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import br.senac.tads4.dsw.tadsstore.model.Papel;
import br.senac.tads4.dsw.tadsstore.model.UsuarioSistema;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private static ClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioSistema usu = new UsuarioSistema();

        Cliente c = clienteService.obterByUsername(username);
        List<Papel> p = (List<Papel>) new Papel();
        Papel pa;
        
        p.add(pa = new Papel(c.getPapel()));
        
        usu.setId(c.getId());
        usu.setNomeCompleto(c.getNome());
        usu.setPapeis(p);
        usu.setSenha(c.getSenha());
        usu.setUsername(c.getEmail());
        
        return usu;
    }
}
