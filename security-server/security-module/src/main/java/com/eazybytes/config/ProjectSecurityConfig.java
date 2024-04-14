package com.eazybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Collections;

import static constant.HttpRequestConstants.*;

/**
 * The type Project security config.
 */
@Configuration
public class ProjectSecurityConfig {
	
	/**
	 * Default security filter chain security filter chain. section1
	 *
	 * @param http the http
	 * @return the security filter chain
	 * @throws Exception the exception
	 */
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.cors(cors -> cors.configurationSource(corsConfigurationSource()))
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests((requests) -> requests
						.requestMatchers(HTTP_MY_ACCOUNT, HTTP_MY_BALANCE, HTTP_MY_CARDS, HTTP_MY_LOANS, HTTP_USER).authenticated()
						.requestMatchers(HTTP_CONTACT, HTTP_NOTICES, HTTP_REGISTER).permitAll())
				.formLogin(Customizer.withDefaults())
				.httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	private CorsConfigurationSource corsConfigurationSource() {
		return request -> {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowedOrigins(Collections.singletonList(FE_ENDPOINT));
			config.setAllowedMethods(Collections.singletonList("*"));
			config.setAllowedHeaders(Collections.singletonList("*"));
			config.setAllowCredentials(true);
			return config;
		};
	}
	
	/**
	 * Password encoder password encoder.
	 *
	 * @return the password encoder
	 */
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
