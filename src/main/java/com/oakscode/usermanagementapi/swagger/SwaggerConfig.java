//package com.oakscode.usermanagementapi.swagger;
//
//import java.util.Arrays;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;

//@Configuration
//@EnableSwagger2

//public class SwaggerConfig {
	

//	@Bean
//    public OpenAPI springOpenApiConfig() {
//         return new OpenAPI()
//            .components(new Components()
//                        .addSecuritySchemes("api_key", new SecurityScheme()
//                                  .type(SecurityScheme.Type.APIKEY)
//                                  .description("Api Key access")
//                                  .in(SecurityScheme.In.HEADER)
//                                  .name("X-API-Key")
//                                  
//              )          )
//              .security(Arrays.asList(
//                           new SecurityRequirement().addList("api_key")))
//              // whatever else you need
//              .info(new Info().title("User Management API")
//              .description("User Management API")
//              .version("v1"));
//      }
	
//	public Docket api() {
//
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(new ApiInfoBuilder().title("Your API Documentation").description("Description of your API")
//						.version("1.0").build())
//				.forCodeGeneration(true).globalRequestParameters(globalParameterList()).select()
//				.apis(RequestHandlerSelectors.basePackage("com.oakscode.usermanagementapi.controller")) // Specify your
//																										// controller
//																										// package
//				.paths(PathSelectors.any()).build();

//		return new Docket(DocumentationType.SWAGGER_2)
//				.forCodeGeneration(true)
//			.globalRequestParameters(globalParameterList())
//				.select()
//				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
//				.build();
		
	//}
	
	 
//	private List<springfox.documentation.service.RequestParameter> globalParameterList() {
//		val authTokenHeader = new RequestParameterBuilder().name("X-API-KEY") // name of the header
//				 .query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)))//.modelRef(new ModelRef("string")) // data-type of the header
//				.required(false) // required/optional
//				.in(ParameterType.HEADER)//.parameterType("header") // for query-param, this value can be 'query'
//				.description("Api Key").build();
//
//		return Collections.singletonList(authTokenHeader);
//	}
//	
//	 


//}
