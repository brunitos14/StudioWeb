package br.com.bootstrapteste.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/css/**").permitAll();
		http.authorizeRequests().antMatchers("/font-awesome/**").permitAll();
		http.authorizeRequests().antMatchers("/fonts/**").permitAll();
		http.authorizeRequests().antMatchers("/js/**").permitAll();


		http.formLogin().failureUrl("/login").defaultSuccessUrl("/")
				.loginPage("/login").permitAll().and().logout()
				.logoutSuccessUrl("/login").permitAll();

		http.authorizeRequests().anyRequest().authenticated();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("user").password("password")
				.roles("USER");
	}

}
