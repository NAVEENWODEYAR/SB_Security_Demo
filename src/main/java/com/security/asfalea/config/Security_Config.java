package com.security.asfalea.config;
/*
 * @author NaveenWodeyar
 * @date 26-08-2024
 */

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class Security_Config {

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Disable CSRF for simplicity in this example
        httpSecurity.csrf(AbstractHttpConfigurer::disable);

        // Allow unauthenticated access to Swagger UI
        httpSecurity.authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll()
                        .requestMatchers("register","generateToken").permitAll()
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

        httpSecurity.addFilterBefore(null, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }
}
