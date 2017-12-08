/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads4.dsw.tadsstore.service;

import br.senac.tads4.dsw.tadsstore.config.SecurityConfig;
import br.senac.tads4.dsw.tadsstore.model.Papel;
import br.senac.tads4.dsw.tadsstore.model.UsuarioSistema;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    private static final Map<String, UsuarioSistema> USUARIOS;

    static {
        USUARIOS = new LinkedHashMap<String, UsuarioSistema>();
        USUARIOS.put("789", new UsuarioSistema("789",
                SecurityConfig.passwordEncoder().encode("789"),
                "Fulano da Silva",
                Arrays.asList(new Papel("ROLE_FODINHA"))));
        USUARIOS.put("456", new UsuarioSistema("456",
                SecurityConfig.passwordEncoder().encode("456"),
                "Ciclano de Souza",
                Arrays.asList(new Papel("ROLE_FODINHA"), new Papel("ROLE_FODAO"))));

        USUARIOS.put("123", new UsuarioSistema("123", SecurityConfig.passwordEncoder().encode("123"), "Beltrana das Cruzes",
                Arrays.asList(new Papel("ROLE_FODINHA"), new Papel("ROLE_FODAO"), new Papel("ROLE_GOD"))));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return USUARIOS.get(username);
    }
}