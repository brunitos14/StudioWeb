package br.com.bootstrapteste;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.bootstrapteste.conf.WebSecurityConfig;

@SpringBootApplication
public class BootstraptesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstraptesteApplication.class, args);
	}

}
