package com.rayandahmena.project_3.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class that handles Swagger
 */
@OpenAPIDefinition
@Configuration
public class SwaggerConfig {

    /**
     * Configure Swagger Title, Description & Version
     * @return OpenAPI
     */
    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI().info(new Info()
                .title("ChaTôp API Documentation")
                .description("API Documentation for ChaTôp application (Swagger)")
                .version("1.0")
        );
    }
}
