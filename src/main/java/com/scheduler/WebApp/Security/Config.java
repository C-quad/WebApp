package com.scheduler.WebApp.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
/*
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scheduler.WebApp.service.EmployeeDetailsService;
import com.scheduler.WebApp.service.EmployeeServices;



@Configuration
//@EnableWebSecurity
@Order(1)
public class Config extends WebSecurityConfigurerAdapter
{
	@Autowired
	private EmployeeDetailsService employeeServices;
	
	
	protected void configure(HttpSecurity http) throws Exception
	{
		http
		
			.authorizeRequests()
		        .antMatchers("/register.html","/", "/index.html","/about-us.html","/404.html","/assets/**" ,"/fullcalendar/**", "/images/**", "/resources/**").permitAll()
		        .antMatchers("/css/**","/js/**", "/sass/**", "/webfonts/**", "/static/**", "/weekly-calendar.html").permitAll();
		  
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder(); 
	}
	
	
	public DaoAuthenticationProvider authProvider()
	{
		 DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
         authProvider.setUserDetailsService(employeeServices);
         authProvider.setPasswordEncoder(passwordEncoder());
         return authProvider;
	}
	
	
	

}
*/