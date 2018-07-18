package com.bkb.userbase.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class JwtConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter();
        filterFilterRegistrationBean.setFilter(jwtAuthenticationFilter);
        return filterFilterRegistrationBean;
    }
}
