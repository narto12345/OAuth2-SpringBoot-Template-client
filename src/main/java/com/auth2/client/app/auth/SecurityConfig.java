package com.auth2.client.app.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((authHttp) -> authHttp
				.requestMatchers(HttpMethod.GET,"/authorized").permitAll()
				.requestMatchers(HttpMethod.GET, "/list").hasAnyAuthority("SCOPE_read", "SCOPE_write")
				.requestMatchers(HttpMethod.GET, "/create").hasAuthority("SCOPE_write")
			.anyRequest().authenticated())
			.csrf(csrf -> csrf.disable())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.oauth2Login(login -> login.loginPage("/oauth2/authorization/client-app"))
			.oauth2Client(withDefaults())
			.oauth2ResourceServer(resourceServer -> resourceServer.jwt(withDefaults()));
		
		return http.build();
	}
}
