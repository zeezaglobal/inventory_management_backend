package com.zeezaglobal.inventory_management_backend.Conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // Allow CORS for React app on localhost:3000
        registry.addMapping("/api/**")
                .allowedOrigins("http://147.93.114.66:8081")  // Add your React app URL
                .allowedMethods("GET", "POST", "DELETE");
    }
}
