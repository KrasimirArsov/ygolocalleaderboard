package com.k.arsov.ygolocalleaderboard.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.sql.SQLOutput;

@Configuration
public class SecurityConfig
{

    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        System.out.println("Setting up in-memory user details manager...");

        UserDetails user1 = User.builder()
                .username("karsov")
                .password("{noop}password")
                .roles("PLAYER", "ADMIN")
                .build();

        UserDetails user2 = User.builder()
                .username("rgeorgiev")
                .password("{noop}qwerty")
                .roles("PLAYER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/decks").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.GET, "/api/decks/**").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.POST, "/api/decks").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/decks").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/decks/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/players").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.GET, "/api/players/**").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.POST, "/api/players").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/players").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/players/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/duels").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.GET, "/api/duels/**").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.POST, "/api/duels").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/duels").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/duels/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/api/set-cards").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.GET, "/api/set-cards/**").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.POST, "/api/set-cards").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/set-cards").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/set-cards/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/decks").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.GET, "/decks/**").hasRole("PLAYER")
                        .requestMatchers(HttpMethod.POST, "/decks").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.GET, "/css/styles.css").hasRole("PLAYER")
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
