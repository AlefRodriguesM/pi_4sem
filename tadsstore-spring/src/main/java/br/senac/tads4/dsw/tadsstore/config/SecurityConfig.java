package br.senac.tads4.dsw.tadsstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return passwordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*
            com estas configurações, as seguintes telas precisam de autenticação, mas não precisa ser FODAO para funcionar:
            /compra/confirmar/{id}
            /pedido
        */
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/rest/**").permitAll()
                .antMatchers("/teste-ajax-ws", "/css/**", "/js/**", "/img/**", "/font/**").permitAll()      // frameworks
                .antMatchers("/gerenciamento/**").hasRole("FODAO")                                          // gerenciamento
                .antMatchers("/produto", "/produto/**").permitAll()                                         // produto
                .antMatchers("/compra", "/compra/adicionar/**", "/carrinho").permitAll()                    // carrinho
                .antMatchers("/**").authenticated()                                                         // sempre que o usuário acessar algo sem permissão, solicita login
                .and()
                    .formLogin()
                    .loginPage("/login").usernameParameter("username")
                    .passwordParameter("senha")
                    .defaultSuccessUrl("/produto").permitAll()
                .and()
                    .logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login?logout")
                    .invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }
}