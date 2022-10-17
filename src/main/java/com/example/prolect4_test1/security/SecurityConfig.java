package com.example.prolect4_test1.security;

import com.example.prolect4_test1.filter.CustomAuthenticationFilter;
import com.example.prolect4_test1.filter.CustomAuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public SecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter(authenticationManagerBean());
        customAuthenticationFilter.setFilterProcessesUrl("/login");
        http.cors().and().csrf().disable();
        http.cors().configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("*"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;});
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        // Define the authorization patterns below
//        http.authorizeRequests().anyRequest().hasAnyAuthority("ADMIN");
//        http.authorizeRequests().antMatchers(DELETE, "/genres/**").permitAll();
        http.authorizeRequests().antMatchers(PUT, "/genres/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST, "/login").permitAll();
        http.authorizeRequests().antMatchers(POST,"/users").permitAll();
        http.authorizeRequests().antMatchers(GET,"/users").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(DELETE,"/users/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/users/admin").permitAll();
        http.authorizeRequests().antMatchers(GET,"/games/**").permitAll();
        http.authorizeRequests().antMatchers(DELETE,"/games/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/games/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(GET,"/review/**").permitAll();
        http.authorizeRequests().antMatchers(POST,"/review/**").permitAll();
        http.authorizeRequests().antMatchers(GET,"/genres").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/genres").hasAnyAuthority("ADMIN");
        http.authorizeRequests().antMatchers(POST,"/roles").permitAll();
        http.authorizeRequests().antMatchers( "/todos/**").hasAnyAuthority("USER");
//        http.authorizeRequests().antMatchers(POST, "/admin/**").hasAnyAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(customAuthenticationFilter);
        http.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

}
