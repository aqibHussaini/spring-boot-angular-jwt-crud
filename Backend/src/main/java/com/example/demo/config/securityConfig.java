package com.example.demo.config;
import com.example.demo.Entities.User;
import com.example.demo.filter.jwtFilter;
import com.example.demo.service.myUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@EnableWebSecurity
@Configuration
public class securityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    myUserDetailsService myUserDetailsService;
    @Autowired
    jwtFilter jwtFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    User getuser() {
        return new User();
    }

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService);
    }

    @Bean
  public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/*").allowedHeaders("*").allowedOrigins("*").allowedMethods("*");
            }
        };

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        antMatchers(HttpMethod.OPTIONS,"/**").permitAll()

        http.authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/get-token").permitAll().
                antMatchers(HttpMethod.OPTIONS,"/**").permitAll().
               anyRequest().authenticated()
                .and().formLogin().permitAll()
                .and()
                .csrf().disable().cors().disable()
                .logout().permitAll()
        ;
        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider()
//    {
//        DaoAuthenticationProvider daoAuthenticationProvider=new DaoAuthenticationProvider();
//        daoAuthenticationProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
//        daoAuthenticationProvider.setUserDetailsService(myUserDetailsService);
//        return daoAuthenticationProvider;
//    }
}
