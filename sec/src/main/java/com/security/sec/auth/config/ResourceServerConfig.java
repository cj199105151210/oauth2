package com.security.sec.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * 资源服务器
 */
@Configuration
@EnableResourceServer   //开启资源提供的服务，是默认情况下spring security oauth2的http配置 会被WebSecurityConfigureAdapter
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    public void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll();
    }
}

