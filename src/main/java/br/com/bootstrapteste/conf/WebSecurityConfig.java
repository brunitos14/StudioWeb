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

	@Autowired
	private UserDetailsService userDetailsService;

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
//		http.authorizeRequests().antMatchers("/css/**").permitAll();
//		http.authorizeRequests().antMatchers("/font-awesome/**").permitAll();
//		http.authorizeRequests().antMatchers("/fonts/**").permitAll();
//		http.authorizeRequests().antMatchers("/js/**").permitAll();

//		http.
//		authorizeRequests()
//			.antMatchers("/").permitAll()
//			.antMatchers("/login").permitAll()
//			.antMatchers("/registration").permitAll()
//			.antMatchers("/admin/**").hasAuthority("ADMIN").anyRequest()
//			.authenticated().and().csrf().disable().formLogin()
//			.loginPage("/login").failureUrl("/login?error=true")
//			.defaultSuccessUrl("/admin/home")
//			.usernameParameter("user")
//			.passwordParameter("password")
//			.and().logout()
//			.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//			.logoutSuccessUrl("/").and().exceptionHandling()
//			.accessDeniedPage("/access-denied");

		http.
		authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("ADMIN_GROUP").anyRequest();

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

//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		return bCryptPasswordEncoder;
//	}

}
