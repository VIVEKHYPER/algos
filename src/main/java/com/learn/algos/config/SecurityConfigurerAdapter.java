package com.learn.algos.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfigurerAdapter extends WebSecurityConfigurerAdapter{

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	UserBuilder users = User.withDefaultPasswordEncoder();
	auth.inMemoryAuthentication().withUser(users.username("user").password("test123").roles("USER"));
	// .withUser(users.username("Vivek").password("test123").roles("END_USER",
	// "ADMIN"));
    }

    protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/").hasRole("USER")
			.antMatchers("/resources/**").hasRole("USER")
			.antMatchers("/api/**").hasRole("USER")
			.antMatchers("/sort/**").hasRole("USER")
			.antMatchers("/showHome/**").hasRole("USER")
			.antMatchers("/showMain/**").hasRole("USER")
//	                .antMatchers("/*.js").hasRole("USER")
			
//	                .antMatchers("/*.css").hasRole("USER")
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
				.and()
					.logout()
					.permitAll()
			.and()
			.csrf().disable()
			.exceptionHandling().accessDeniedPage("/access-denied")
			.and()
			.httpBasic();
    }

}