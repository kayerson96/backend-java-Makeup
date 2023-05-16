package com.tienda.tienda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/login")
                        .allowedOrigins("http://localhost:4200/")
                                .allowedMethods("*")
                                        .exposedHeaders("*");


                        registry.addMapping( "/api/**")
                                .allowedMethods("http://localhost:4200/")
                                .allowedMethods("*");


        }


        };
    }
}

