package com.aluraflix.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {
	
	@Bean 
	OpenAPI customOpenAPI() {
	    return new OpenAPI()
	            .components(new Components()
	            		.addSecuritySchemes("bearer-key",
	            				new SecurityScheme()
	                                    .type(SecurityScheme.Type.HTTP)
	                                    .scheme("bearer")
	                                    .bearerFormat("JWT")))
	                    .info(new Info()
	                            .title("Alura-FLix API")
	                            .description("API Rest da aplicação Alura-Flix, contendo as funcionalidades de CRUD de videos e de categorias. além de serviço de autenticação para acesso às rotas.")
	                            .contact(new Contact()
	                                    .name("Dayvid Jonathan")
	                                    .email("dayvidaf7@gmail.com")));
	}

}
