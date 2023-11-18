package com.example.flexibleresume.config;

import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .httpBasic(basic -> basic.disable())
                .authorizeHttpRequests(auth ->
                        auth

         .requestMatchers("/**").permitAll()

                 .requestMatchers("/auth/**").hasAnyRole("USER", "ADMIN")
                .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                .requestMatchers(HttpMethod.POST,"/auth/authenticate").hasAnyRole("USER","ADMIN")

                .requestMatchers(HttpMethod.POST, "/werkzoekende/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.GET,"/werkzoekende/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST,"/werkzoekende/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/werkzoekende/**").hasAnyRole("USER","ADMIN")
                .requestMatchers("/werkzoekende/**").hasAnyRole("USER","ADMIN")
                .requestMatchers(HttpMethod.POST, "/bedrijf/**").hasAnyRole("COMPANY","ADMIN")
                .requestMatchers(HttpMethod.GET,"/bedrijf/**").hasAnyRole("COMPANY","ADMIN")
                .requestMatchers(HttpMethod.POST,"/bedrijf/**").hasAnyRole("COMPANY","ADMIN")
                .requestMatchers(HttpMethod.DELETE, "/bedrijf/**").hasAnyRole("COMPANY","ADMIN")
                .requestMatchers("/bedrijf/**").hasAnyRole("COMPANY","ADMIN")

                .anyRequest().authenticated()

                )

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }


}
