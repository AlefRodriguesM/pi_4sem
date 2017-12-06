package br.senac.tads4.dsw.tadsstore.service;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import br.senac.tads4.dsw.tadsstore.common.service.ClienteService;
import br.senac.tads4.dsw.tadsstore.config.SecurityConfig;
import br.senac.tads4.dsw.tadsstore.model.Papel;
import br.senac.tads4.dsw.tadsstore.model.UsuarioSistema;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private static ClienteService clienteService;

    private static final Map<String, UsuarioSistema> USUARIOS;

    private static final ArrayList<Cliente> cliLista = clienteService.obterTodos();

    static {
        USUARIOS = new LinkedHashMap<String, UsuarioSistema>();

        for(int i = 0; i < cliLista.size(); i++){

          USUARIOS.put(cliLista.get(i).getNome(), 
                  new UsuarioSistema(cliLista.get(i).getId(), 
                          cliLista.get(i).getEmail(), 
                          SecurityConfig.passwordEncoder().encode(cliLista.get(i).getSenha()),
                          cliLista.get(i).getNome() + cliLista.get(i).getSobrenome(),
                          new Papel(cliLista.get(i).getPapel())));
        }
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return USUARIOS.get(username);
    }
}
