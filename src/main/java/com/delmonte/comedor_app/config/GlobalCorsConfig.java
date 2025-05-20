package com.delmonte.comedor_app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class GlobalCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        // Permitir cookies (JSESSIONID, etc.)
        config.setAllowCredentials(true);

        // Aceptar solicitudes desde el frontend desplegado
        config.setAllowedOrigins(Arrays.asList(
                "https://comedor-app-frontend.onrender.com"
        ));

        // Métodos permitidos
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Encabezados permitidos
        config.setAllowedHeaders(Arrays.asList("*"));

        // Encabezados visibles en la respuesta (opcional)
        config.setExposedHeaders(Arrays.asList("Authorization", "Content-Type"));

        // Aplicar esta configuración a todas las rutas
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
