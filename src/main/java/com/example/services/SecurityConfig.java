/**
 * 
 */
package com.example.services;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * @author neeravshah
 *
 */
@Configuration
@SuppressWarnings("deprecation")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Authentication : User --> Roles
		protected void configure(AuthenticationManagerBuilder auth)
				throws Exception {
			auth.
			inMemoryAuthentication().
			passwordEncoder(NoOpPasswordEncoder.getInstance()).
			withUser("user1").password("secret1").
			roles("USER").and().withUser("admin1").
			password("secret1").
			roles("USER", "ADMIN");
		}

		// Authorization : Role -> Access
		protected void configure(HttpSecurity http) throws Exception {
			http.httpBasic().
			and().
			authorizeRequests().antMatchers("/api/profile/**").
		    hasRole("USER").antMatchers("/**").
		    hasRole("ADMIN").
		    and().
		    csrf().disable().
		    headers().frameOptions().disable();
		}	

}
