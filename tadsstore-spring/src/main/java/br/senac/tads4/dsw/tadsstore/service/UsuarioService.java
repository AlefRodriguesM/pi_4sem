package br.senac.tads4.dsw.tadsstore.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import br.senac.tads4.dsw.tadsstore.config.SecurityConfig;
import br.senac.tads4.dsw.tadsstore.model.Papel;
import br.senac.tads4.dsw.tadsstore.model.UsuarioSistema;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private ClienteService clienteService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UsuarioSistema usu = new UsuarioSistema();
        Cliente c = clienteService.obterByEmail(username);
        
        usu.setId(c.getId());
        usu.setNomeCompleto(c.getNome());
        if("CLIENTE".equals(c.getPapel().trim())){
            usu.setPapeis(Arrays.asList(new Papel("CLIENTE")));
        }else{
            usu.setPapeis(Arrays.asList(new Papel("BACKOFFICE")));
        }
        usu.setSenha(SecurityConfig.passwordEncoder().encode(c.getSenha()));
        usu.setUsername(c.getEmail());

        return usu;
    }
}
