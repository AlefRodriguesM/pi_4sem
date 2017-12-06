package br.senac.tads4.dsw.tadsstore.model;

import br.senac.tads4.dsw.tadsstore.common.entity.Cliente;
import java.util.Collection;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioSistema implements UserDetails {

    private String username;

    private String senha;

    private String nomeCompleto;

   private List<Papel> papeis;
 
    public UsuarioSistema() {
    }


    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public UsuarioSistema(String username, String senha, String nomeCompleto, List<Papel> papeis) {
        this.username = username;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.papeis = papeis;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }

    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }


    @Override
    public Collection<Papel> getAuthorities() {
        return (Collection) papeis;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
