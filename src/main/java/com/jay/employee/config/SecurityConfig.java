package com.jay.employee.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.jay.employee.service.UserDetailProvider;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	
	@Autowired
	UserDetailProvider provider;
	
	
	
	@Bean
	BCryptPasswordEncoder encoderProvider() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(provider);
	}
	
	

	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web.ignoring().antMatchers("/auth/register");
	    web.ignoring().antMatchers("/api/**");
	    web.ignoring().antMatchers("/order/*");
	}

	

	@Override
	protected void configure(HttpSecurity http) throws Exception {		

		 http
		    .httpBasic().and()
		    .authorizeRequests()
		    .antMatchers(HttpMethod.POST).authenticated()
		    .antMatchers(HttpMethod.PUT).authenticated()
		    .antMatchers(HttpMethod.GET).authenticated()
		    .antMatchers(HttpMethod.DELETE).authenticated()
		    .and()
		    .csrf()
		    .disable();
        http.logout().permitAll();
	
	}

}
