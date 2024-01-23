package com.example.flexibleresume.config;

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
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // CORS configuration
                .cors().configurationSource(corsConfigurationSource())
                .and()
                // Disable CSRF as we are stateless
                .csrf().disable()
                .httpBasic().disable()
                // Session management
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // Define URL patterns and their security requirements
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(new AntPathRequestMatcher("/auth/register", "POST")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/authenticate", "POST")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/jobseeker/**")).permitAll()
                        .requestMatchers(new AntPathRequestMatcher("/employer/**")).permitAll()

//                        .requestMatchers(new AntPathRequestMatcher("/jobseeker/**")).hasAnyRole("USER", "ADMIN") // Spring adds "ROLE_" prefix automatically
//                        .requestMatchers(new AntPathRequestMatcher("/employer/**")).hasAnyRole("COMPANY", "ADMIN")
                        .anyRequest().authenticated()
                )
                // Authentication provider
                .authenticationProvider(authenticationProvider)
                // JWT filter
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Specify the allowed origins or use patterns
        // Example: configuration.setAllowedOrigins(List.of("http://localhost:3000", "https://yourdomain.com"));
        configuration.setAllowedOriginPatterns(List.of("*")); // Use patterns instead of direct origins

        configuration.setAllowedMethods(List.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));
        configuration.setExposedHeaders(List.of("Authorization", "Cache-Control", "Content-Type"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
