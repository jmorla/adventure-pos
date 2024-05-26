package com.bytetechsolutions.adventurepos.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    @ConditionalOnMissingBean(UserDetailsService.class)
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        String generatedPassword = passwordEncoder().encode("admin123");
        return new InMemoryUserDetailsManager(User.withUsername("user@localhost")
                .password(generatedPassword).roles("USER").build());
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/signIn","/error","*.js", "*.css", "/img/**", "assets/**").permitAll()
                .anyRequest().authenticated())
        .formLogin((form) -> form
                .loginPage("/signIn")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/products", true)
                .failureUrl("/signIn?error=true")
                .permitAll())
        .csrf((csrf) -> csrf.disable());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}