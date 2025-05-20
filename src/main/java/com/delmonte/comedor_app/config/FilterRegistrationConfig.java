package com.delmonte.comedor_app.config;

import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterRegistrationConfig {

    @Bean
    public FilterRegistrationBean<Filter> sameSiteCookieFilterRegistration(SameSiteCookieFilterConfig filter) {
        FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/*");  // Aplica a todas las rutas
        registrationBean.setName("SameSiteCookieFilter");
        registrationBean.setOrder(1); // Ejecutar con alta prioridad
        return registrationBean;
    }
}
