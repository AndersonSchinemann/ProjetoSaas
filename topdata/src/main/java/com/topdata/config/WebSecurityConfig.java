package com.topdata.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	@Bean
	 SecurityFilterChain configure(HttpSecurity http) throws Exception {
		 http
		 .authorizeHttpRequests( (authorize) -> authorize
			 .requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**").permitAll()
	         .requestMatchers("/cadastro").permitAll()
	         .requestMatchers("/listagem").authenticated() 
	         .anyRequest().authenticated()
	   ).formLogin( (form) -> form
	         .loginPage("/")
	         .defaultSuccessUrl("/", true)
	         .failureUrl("/login-error")
	         .permitAll()
	    ).logout( (logout) -> logout
	         .logoutSuccessUrl("/")
	         //.deleteCookies("JSESSIONID")
	    ).exceptionHandling( (ex) -> ex
	         .accessDeniedPage("/negado")
	    );
	    return http.build();
	}
//	@Bean
//	CorsFilter corsFilter() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.addAllowedOrigin("http://localhost:8080");
//        config.applyPermitDefaultValues();
//        config.addAllowedMethod("DELETE");
//        config.addAllowedMethod("PUT");
//        config.addAllowedMethod("POST");
//        config.addAllowedMethod("GET");
//        source.registerCorsConfiguration("/api/usuarios/**",config);
//        source.registerCorsConfiguration("/api/**",config); // Ajuste para corresponder ao padrão da sua API AngularJS
//        return new CorsFilter(source);
//	}
	@Bean
	PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Bean
	WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurer() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/api/**")
	                    .allowedOrigins("http://localhost:8080")
	                    .allowedMethods("GET", "POST", "PUT", "DELETE")
	                    .allowCredentials(true);
	        }
	    };
	}
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.addAllowedOrigin("*"); // Permitir qualquer origem, ajuste conforme necessário
        configuration.addAllowedMethod("*"); // Permitir todos os métodos (GET, POST, PUT, DELETE, etc.)
        configuration.addAllowedHeader("*"); // Permitir todos os cabeçalhos

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("*", configuration);

        return source;
    }
	@Bean
   CsrfTokenRepository csrfTokenRepository() {
        CookieCsrfTokenRepository repository = CookieCsrfTokenRepository.withHttpOnlyFalse();
        // Adicionar outras configurações, se necessário
        return repository;
    }
}