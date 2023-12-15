package com.oakscode.usermanagementapi.openapiconfig;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;

@Configuration
@OpenAPIDefinition(
		info = @Info(
				contact = @Contact(
					name="Oaks",
					email="oaks4ever@gmail.com"
						
			),
				description="OpenApi documentaion for Spring Security",
				title="OpenApi Specificaton -  Oaks",
				version="1.0"
			),
		security= {
				@SecurityRequirement(name= "X-API-KEY")
		}
		
		
)

@SecurityScheme(
		name="X-API-KEY",
		description="Api key description",
		type= SecuritySchemeType.APIKEY,
	     in=SecuritySchemeIn.HEADER
	     
		
		)
public class OpenApConfig {

}
