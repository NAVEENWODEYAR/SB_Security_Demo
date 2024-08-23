package com.security.asfalea.config;/*
 * @author LENOVO
 * @date 23-08-2024
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Disable CSRF for simplicity in this example
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // Allow unauthenticated access to Swagger UI
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("register","login").permitAll()
                        .anyRequest().authenticated()
        );

        // Enable form-based login
        httpSecurity.formLogin(Customizer.withDefaults());

        // Enable HTTP Basic authentication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // Configure session management
        httpSecurity.sessionManagement(session ->
                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

        return httpSecurity.build();
    }

    /*
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.authorizeHttpRequests(request->request.anyRequest().authenticated());
        httpSecurity.formLogin(Customizer.withDefaults());
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        // Allow unauthenticated access to Swagger UI
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .anyRequest().authenticated()
        );

        return httpSecurity.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User
                .withDefaultPasswordEncoder()
                .username("uat")
                .password("uat")
                .roles("USER")
                .build();

        UserDetails user1 = User
                .withDefaultPasswordEncoder()
                .username("sit")
                .password("sit")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user1,user);
    }*/

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        authenticationProvider.setUserDetailsService(userDetailsService);

        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
