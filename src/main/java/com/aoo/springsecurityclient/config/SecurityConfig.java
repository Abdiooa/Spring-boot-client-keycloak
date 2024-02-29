package com.aoo.springsecurityclient.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.http.SessionCreationPolicy.ALWAYS;

@EnableWebSecurity
@Configuration
public class SecurityConfig{
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/unauthenticated").permitAll()
                        .anyRequest().authenticated())
                .oauth2Login(oauth->oauth.defaultSuccessUrl("/"))
                .sessionManagement(manager-> manager.sessionCreationPolicy(ALWAYS))
                .logout((logout)-> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("http://localhost:8080/realms/spring-microservice-realm/protocol/openid-connect/logout"))
                .build();
    }
}