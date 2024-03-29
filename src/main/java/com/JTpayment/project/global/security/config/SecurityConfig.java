package com.JTpayment.project.global.security.config;

import com.JTpayment.project.global.filter.JwtRequestFilter;
import com.JTpayment.project.global.security.handler.CustomAccessDeniedHandler;
import com.JTpayment.project.global.security.handler.CustomAuthenticationEntryPointHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig {
    private final JwtRequestFilter jwtRequestFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .cors().configurationSource(corsConfigurationSource()).and()
                .csrf().disable();
        httpSecurity
                .exceptionHandling()
                .accessDeniedHandler(new CustomAccessDeniedHandler())
                .authenticationEntryPoint(new CustomAuthenticationEntryPointHandler());
        httpSecurity
                .httpBasic().disable() //UI, UX Disable
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeHttpRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/signup").permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .requestMatchers(HttpMethod.POST, "/mail").permitAll()
                .requestMatchers(HttpMethod.POST, "/mail/check").permitAll()
                .requestMatchers(HttpMethod.GET,"/").permitAll()
                .requestMatchers(HttpMethod.POST, "/request/**").authenticated()
                .requestMatchers("/request/list").hasAuthority("ADMIN")
                .requestMatchers("/request/detail").hasAuthority("ADMIN")
                .requestMatchers("/create").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.PATCH, "/admin/**").hasAuthority("ADMIN")
                .requestMatchers(HttpMethod.GET, "/user/**").authenticated()
                .requestMatchers("/certification/**").authenticated()
                .requestMatchers("/report/**").authenticated()
                .requestMatchers("/order").authenticated()
                .requestMatchers("/payment/**").permitAll()
                .requestMatchers("/ws/**").permitAll()
                .requestMatchers("/pub/**").permitAll()
                .requestMatchers("/sub/**").permitAll()
                .requestMatchers("/chat/**").authenticated()
                .anyRequest().denyAll();

        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.addAllowedOriginPattern("*");
        configuration.addAllowedHeader("*");
        configuration.addAllowedMethod("*");
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
