package br.com.fiap.cp_diploma.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/diplomas/{id}/texto").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/diplomas").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/diplomas/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/cursos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cursos").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/cursos/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/cursos/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/cursos/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/diplomados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/diplomados").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/diplomados/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/diplomados/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/diplomados/{id}").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
