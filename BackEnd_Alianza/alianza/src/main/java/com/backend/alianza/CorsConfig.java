package com.backend.alianza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        // Configura los orígenes permitidos (puedes ajustarlo según tus necesidades)
        config.addAllowedOrigin("http://localhost:3000");
        // Configura los métodos HTTP permitidos (GET, POST, PUT, DELETE, etc.)
        config.addAllowedMethod("*");
        // Configura los encabezados permitidos en la solicitud
        config.addAllowedHeader("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
