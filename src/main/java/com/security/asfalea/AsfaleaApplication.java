package com.security.asfalea;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.annotations.servers.ServerVariable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(
				title = "ASFALEA[ασφάλεια,Greek]~~[SECURITY]",
				version = "1.0",
				description = "Spring Boot demo project for spring_security,",
				termsOfService = "http://terms.example.com",
				contact = @Contact(
						name = "Naveen K Wodeyar",
						email = "naveen.wodeyar@yahoo.com",
						url = "http://naveenwodeyar.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "http://www.apache.org/licenses/LICENSE-2.0.html"
				)
		),
		servers = {
				@Server(
						url = "http://localhost:7070",
						description = "Testing server",
						variables = {
								@ServerVariable(
										name = "port",
										description = "Port number",
										defaultValue = "7070"
								)
						}
				),
				@Server(
						url = "http://production-server.com",
						description = "Production server"
				)
		},
		externalDocs = @ExternalDocumentation(
				description = "Find more info here",
				url = "http://example.com/docs"
		))
@SpringBootApplication
public class AsfaleaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AsfaleaApplication.class, args);
		System.out.println("\nSPRING~^~SECURITY\n");
	}

}
