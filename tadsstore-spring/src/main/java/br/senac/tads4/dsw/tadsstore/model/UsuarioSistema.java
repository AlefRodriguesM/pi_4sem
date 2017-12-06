package br.senac.tads4.dsw.tadsstore.model;

import java.util.Collection;
//import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UsuarioSistema implements UserDetails {

    private Long Id;

    private String username;

    private String senha;

    private String nomeCompleto;

    private Papel papel;

    public UsuarioSistema() {
    }

    public UsuarioSistema(Long Id, String username, String senha, String nomeCompleto, Papel papel) {
        this.Id = Id;
        this.username = username;
        this.senha = senha;
        this.nomeCompleto = nomeCompleto;
        this.papel = papel;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
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

    public Papel getPapeis() {
        return papel;
    }

    public void setPapeis(Papel papel) {
        this.papel = papel;
    }

    @Override
    public Collection<Papel> getAuthorities() {
        return (Collection) papel;
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
