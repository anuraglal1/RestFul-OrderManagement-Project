package com.infinity.GlobalSolutions;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	javax.sql.DataSource datasource; 
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		
		
		auth.jdbcAuthentication()
			.dataSource(datasource);
		
		//PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password("password")
//			.roles("USER")
//			.and()
//			.withUser("admin")
//			.password("admin")
//			.roles("ADMIN");
			
		
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		
		return NoOpPasswordEncoder.getInstance();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/**").hasAnyRole("USER", "ADMIN")
			.and().formLogin();
	}
	
}
