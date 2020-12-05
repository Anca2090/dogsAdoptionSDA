package org.example.config;

import org.example.entities.AdoptersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/error", "/login","/images/**","/register",
                        "/about","/contact","/dogs","/description/{id}","/register-user",
                        "/home","/tables","/saveAdoption","/addAdoption")
                .permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/addDog","/editDog/{id}","/deleteDog/{id}","/saveDog","/tables","/edit","/editAdopter/{username}","deleteAdopter/{id}").hasRole("1")
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/error")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .failureUrl("/login")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home")
                .permitAll();
    }
    @Autowired //apeleaza metoda la rulare
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = passwordEncoder();
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(encoder);
        System.out.println("pass 'parola' encryted: "+encoder.encode("parola"));
    }
}
