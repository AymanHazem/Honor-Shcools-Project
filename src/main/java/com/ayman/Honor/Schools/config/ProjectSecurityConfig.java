package com.ayman.Honor.Schools.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig
{
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception
    {
//        // Permit All Requests inside the Web Application
        http.authorizeHttpRequests(request -> request.anyRequest().permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
//        Deny All Requests inside the Web Application
//        http.authorizeHttpRequests(request -> request.anyRequest().denyAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
