package ufro.dci.gestionapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ufro.dci.gestionapp.security.service.EmployeeSecurityService;


@Configuration
@Order(1)
public class ManagerSecurityConfig {
    @Bean
    public UserDetailsService userDetailsService() {
        return new EmployeeSecurityService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.authorizeHttpRequests().requestMatchers("/","/styles/**").permitAll();

        http.csrf().disable().authorizeHttpRequests()
                .requestMatchers("/manager/**","/styles/**").hasAuthority("MANAGER")
                .and()
                .formLogin()
                .loginPage("/manager/login")
                .usernameParameter("rut")
                .loginProcessingUrl("/manager/login")
                .defaultSuccessUrl("/manager/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/manager/logout")
                .logoutSuccessUrl("/manager/home");

        return http.build();
    }
}