package ufro.dci.gestionapp.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import ufro.dci.gestionapp.security.service.EmployeeSecurityService;

@Configuration
public class EmployeeSecurityConfig {
    @Bean
    public UserDetailsService UserDetailsService() {
        return new EmployeeSecurityService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(UserDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChainEmployee(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.authorizeHttpRequests().requestMatchers("/","/styles/**").permitAll();

        http.securityMatcher("/employee/login")
                .authorizeHttpRequests(
                        authConfig ->{
                            authConfig.requestMatchers("/employee/**").hasAuthority("EMPLOYEE");
                            authConfig.anyRequest().authenticated();
                        }
                )
                .formLogin()
                .loginPage("/employee/login")
                .usernameParameter("rut")
                .loginProcessingUrl("/employee/login")
                .defaultSuccessUrl("/employee/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/")
                .logoutSuccessUrl("/");

        return http.build();
    }

    @Bean
    @Order(1)
    public SecurityFilterChain filterChainManager(HttpSecurity http) throws Exception {
        http.authenticationProvider(authenticationProvider());
        http.authorizeHttpRequests().requestMatchers("/","/styles/**").permitAll();

        http.securityMatcher("/manager/login")
                .authorizeHttpRequests(
                        authConfig ->{
                            authConfig.requestMatchers("/manager/**").hasAuthority("MANAGER");
                            authConfig.anyRequest().authenticated();
                        }
                )
                .formLogin()
                .loginPage("/manager/login")
                .usernameParameter("rut")
                .loginProcessingUrl("/manager/login")
                .defaultSuccessUrl("/manager/home")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/")
                .logoutSuccessUrl("/");

        return http.build();
    }
}
