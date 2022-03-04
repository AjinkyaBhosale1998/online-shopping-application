package com.example.demo.websecurity;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.services.UsercustomerServices;

@Configuration
@EnableWebSecurity
public class WebSecurityConFig extends WebSecurityConfigurerAdapter {

//	@Autowired
//	private DataSource dataSource;
	@Bean
	public UserDetailsService  userDetailsService()
	{
		return new UsercustomerServices();
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public DaoAuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider authprovider=new DaoAuthenticationProvider();
		authprovider.setUserDetailsService(userDetailsService());
		authprovider.setPasswordEncoder(passwordEncoder());
		
		return authprovider;
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.authenticationProvider(authenticationProvider());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http.authorizeRequests()
		.antMatchers("/demo").authenticated()
		.anyRequest().permitAll()
		.and()
		.formLogin()
		.usernameParameter("username")
		.defaultSuccessUrl("/demo") // for sending data
		.permitAll()
		.and()
		.logout().logoutSuccessUrl("/").permitAll();
	}
	 @Autowired
	   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	      auth
	         .inMemoryAuthentication()
	         .withUser("user").password("password").roles("USER");
	   }
	 
	 @Bean public PasswordEncoder passwordEncoder1()
	 {
	     PasswordEncoder encoder = new BCryptPasswordEncoder();
	     return encoder;
	 }
	
}
