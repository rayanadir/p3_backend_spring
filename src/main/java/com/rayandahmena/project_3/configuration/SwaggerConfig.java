package com.rayandahmena.project_3.configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
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
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes("Bearer Authentication", createAPIKeyScheme()))
                .info(new Info()
                .title("ChaTôp API Documentation")
                .description("API Documentation for ChaTôp application (Swagger)")
                .version("1.0")
        );
    }

    /**
     * Configure JWT SecurityScheme
     * @return SecurityScheme
     */
    private SecurityScheme createAPIKeyScheme(){
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
