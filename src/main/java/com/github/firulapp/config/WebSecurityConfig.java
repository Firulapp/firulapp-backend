package com.github.firulapp.config;

import com.github.firulapp.constants.ApiPaths;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // For example: Use only Http Basic and not form login.
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(ApiPaths.BASE_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+"/*").permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.REGISTER_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.LOGIN_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.LOGOUT_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.GET_BY_TYPE).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();

        http.formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}