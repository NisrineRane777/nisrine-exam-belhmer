package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecConfig {

	@Autowired
	UServiceSec uservice;
	
	@Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(uservice);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;

    }

	@Bean
	public AuthenticationManager authenticationManager(
			UserDetailsService userDetailsService,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return new ProviderManager(authenticationProvider);
	}
	  
	@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        return http
	        	.csrf(c->c.disable())
	        	.authorizeHttpRequests(
	        			au->au.requestMatchers("/api/**").hasAnyAuthority("admin"))
	        	.authorizeHttpRequests(
	        				au->au.requestMatchers("/auth/**").permitAll())
	        	.authorizeHttpRequests(
        				au->au.requestMatchers("/abc/**").permitAll())
	        	.authorizeHttpRequests(
        				au->au.requestMatchers("/swagger-ui.html").permitAll())	
	        	/*			.hasAuthority("admin")
	        					)
	               .authorizeHttpRequests(
	            		   a->a.requestMatchers("/labos/**")
	            		   .authenticated())
	               .authorizeHttpRequests(
	            		   auth->
	            		   auth.requestMatchers("post","get","/abc/**").permitAll())
	               */
	               .formLogin(f->f.permitAll())
	               .build();
	                
	    }
	  
	  
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	
}
