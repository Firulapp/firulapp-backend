package com.github.firulapp.config;

import com.github.firulapp.constants.ApiPaths;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(ApiPaths.BASE_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.REGISTER_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.LOGIN_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.LOGOUT_URL).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.GET_USER_BY_TYPE).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.GET_USER_PROFILE_BY_ID).permitAll()
                .antMatchers(ApiPaths.USER_ENDPOINTS_URL+ApiPaths.UPDATE_USER).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.SPECIES_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.SPECIES_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.BREED_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.BREED_BY_SPECIES_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.BREED_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.CONDUCT_RULE_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.CONDUCT_RULE_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.HELP_PAGE_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.HELP_PAGE_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.SERVICE_TYPE_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.SERVICE_TYPE_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.PET_CARE_BY_ID).permitAll()
                .antMatchers(ApiPaths.PARAM_ENDPOINTS_URL+ApiPaths.PET_CARE_ENDPOINTS).permitAll()
                .antMatchers(ApiPaths.PET_ENDPOINTS_URL+ApiPaths.GET_PET_BY_ID).permitAll()
                .antMatchers(ApiPaths.PET_ENDPOINTS_URL+ApiPaths.GET_PET_BY_USER_AND_SPECIES).permitAll()
                .antMatchers(ApiPaths.PET_ENDPOINTS_URL+ApiPaths.GET_PET_BY_USER_ID).permitAll()
                .antMatchers(ApiPaths.PET_ENDPOINTS_URL+ApiPaths.SAVE_OR_UPDATE_PET_REGISTER).permitAll()
                .antMatchers(ApiPaths.PET_ENDPOINTS_URL+ApiPaths.DELETE_PET_REGISTER).permitAll()
                .anyRequest().authenticated()
                .and().httpBasic();

        http.formLogin()
                .loginPage("/login").permitAll()
                .and()
                .logout().permitAll();
    }
}