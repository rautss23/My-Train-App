//package com.casestudy;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import java.util.Arrays;
//import java.util.Collections;
//@Configuration
//public class Config extends org.springframework.web.cors.CorsConfiguration {
//    @Bean
//    public CorsWebFilter corsWebFilter() {
//    final CorsConfiguration corsConfig = new CorsConfiguration();
//    corsConfig.setAllowedOrigins(Collections.singletonList("*"));
//    corsConfig.setAllowedMethods(Arrays.asList("*"));
//    corsConfig.addAllowedHeader("*");
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", corsConfig);
//    return new CorsWebFilter(source);
//}
//}






package com.casestudy;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	
	@Bean
	public RouteLocator allRoutes(RouteLocatorBuilder route) {
		return route.routes()
				.route(user->user
				.path("/")
				.uri("http://localhost:8081"))
				
				.route(train->train
						.path("/")
						.uri("http://localhost:8082"))
				.route(booking->booking
						.path("/api")
						.uri("http://localhost:8083"))
				.build();
	}

}
