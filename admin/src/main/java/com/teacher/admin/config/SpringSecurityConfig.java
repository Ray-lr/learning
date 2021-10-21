package com.teacher.admin.config;


import lombok.SneakyThrows;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/***
 *@author : Ray
 *@date :  2021/1/23 22:46
 *description: close csrf
 ***/
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter
{
    @SneakyThrows
    @Override
    protected void configure(HttpSecurity http){
//        http.csrf().ignoringAntMatchers("/druid/*");
        http.csrf().disable();
    }
}