package br.com.bootstrapteste.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.bootstrapteste.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	@Bean
	public UserDetailsService userDetailsService(){
		return new UserService();

	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth){
		try {
			auth.userDetailsService(userDetailsService());
		} catch (Exception e) {
			throw new SecurityException(e);
		}
	}

//	@Override
//	protected void configure(AuthenticationManagerBuilder auth)
//			throws Exception {
//		auth
//			.userDetailsService(userDetailsService)
//			.passwordEncoder(bCryptPasswordEncoder);
//	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.
		authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("USER_GROUP").anyRequest();

		http.csrf().disable().authorizeRequests().anyRequest().authenticated().and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/")
		.failureUrl("/login?error")
		.permitAll();

	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/css/**", "/font-awesome/**", "/fonts/**", "/js/**", "/images/**");
	}

}
