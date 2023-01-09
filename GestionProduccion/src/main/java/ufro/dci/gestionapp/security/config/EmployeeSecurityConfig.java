package ufro.dci.gestionapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ufro.dci.gestionapp.security.service.EmployeeSecurityService;

@Configuration
@Order(2)
public class EmployeeSecurityConfig {
    @Bean
    public UserDetailsService customerUserDetailsService2() {
        return new EmployeeSecurityService();
    }

    /*
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    */

    @Bean
    public PasswordEncoder passwordEncoder2() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider2() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(customerUserDetailsService2());
        authProvider.setPasswordEncoder(passwordEncoder2());

        return authProvider;
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider2());
        http.authorizeHttpRequests().requestMatchers("/","/styles/**").permitAll();

        http.csrf().disable().cors().disable().authorizeHttpRequests()
                .requestMatchers("/employee/**","/styles/**").hasAuthority("EMPLOYEE")
                .and()
                .formLogin()
                .loginPage("/employee/login")
                .usernameParameter("rut")
                .loginProcessingUrl("/employee/login")
                .defaultSuccessUrl("/employee/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/employee/logout")
                .logoutSuccessUrl("/employee/home");

        return http.build();
    }
}
