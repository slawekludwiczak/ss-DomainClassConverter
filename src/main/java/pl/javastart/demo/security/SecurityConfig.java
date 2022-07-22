package pl.javastart.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.csrf().disable();
        http.authorizeHttpRequests().antMatchers("/h2-console/**").permitAll();
        http.authorizeHttpRequests(requests -> requests
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/user/**").hasAnyRole("USER", "ADMIN")
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().permitAll());
        http.formLogin();
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
