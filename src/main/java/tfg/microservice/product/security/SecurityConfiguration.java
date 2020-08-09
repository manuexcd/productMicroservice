package tfg.microservice.product.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import tfg.microservice.product.model.Constants;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors().disable();
		http.csrf().disable();
		http.authorizeRequests().antMatchers(HttpMethod.GET, Constants.PATH_PRODUCTS_WILDCARD).permitAll();
		http.authorizeRequests().antMatchers(HttpMethod.POST, Constants.PATH_PRODUCTS_WILDCARD).authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.PUT, Constants.PATH_PRODUCTS_WILDCARD).authenticated();
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, Constants.PATH_PRODUCTS_WILDCARD).authenticated();
		http.addFilter(new JWTAuthorizationFilter(authenticationManager()));
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return source;
	}
}