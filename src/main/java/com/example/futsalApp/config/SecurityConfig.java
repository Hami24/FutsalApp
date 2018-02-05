package com.example.futsalApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	 protected void configureAuth(AuthenticationManagerBuilder auth) throws Exception{
		 auth
		 	 .inMemoryAuthentication()
		 	 		.withUser("admin")
		 	 		.password("admin")
		 	 		.roles("ADMIN")
		 	 .and()
		 	 		.withUser("user")
		 	 		.password("user")
		 	 		.roles("USER");
		 	 				
	 }
	
	 @Override
	 public void configure(HttpSecurity http) throws Exception {
		 
		 	http
		 		.authorizeRequests()
		 		//.antMatchers("/resources/**").permitAll()
		 		.antMatchers("/user/**").hasRole("USER")
		 		.antMatchers("/admin/**").hasRole("ADMIN")
		 		.antMatchers("/home").authenticated()
		 		//.anyRequest().authenticated()
		 		.and()
		 		.formLogin()
		 			.defaultSuccessUrl("/home")
		 			.loginPage("/")
		 			.permitAll()
		 			.and()
		 		.logout()
		 			.logoutUrl("/logout")
		 			.logoutSuccessUrl("/?logout")
		 			.permitAll();
		 		
		 			
	
	 }
	 
}