package com.oakscode.usermanagementapi.authFilter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;





@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//private static final String[] SWAGGER_PATHS = { "/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/swagger-ui/**"};
	
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		//return http
				
                //.authorizeHttpRequests(authorize -> authorize
                		//.requestMatchers("/**").authenticated()
                		//.requestMatchers(HttpMethod.GET,"/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/webjars/swagger-ui/**").permitAll()
                       // .requestMatchers(SWAGGER_PATHS).permitAll()
                       // )
                //.requestMatchers("/**").authenticated()
                //.requestMatchers(HttpMethod.GET, "/api/**").permitAll()
                        // .anyRequest().authenticated())
                                    
                //.build();
       http.csrf(csrf -> csrf
                .disable())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, AUTH_WHITELIST).permitAll()
                .requestMatchers("/**").authenticated()
                .requestMatchers(AUTH_WHITELIST).permitAll()
              .and()
//               .sessionManagement(management -> management
//                       .sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//               
                .addFilterBefore(new AuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
	private static final String[] AUTH_WHITELIST = {
            // -- Swagger UI v2
			"/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui/**",
            "/webjars/**",
            "/swagger-ui.html",
            
            // -- Swagger UI v3 (OpenAPI)
            "/v3/api-docs",
            "/v3/api-docs/**",
            "/swagger-ui/**"
           
    };

}
