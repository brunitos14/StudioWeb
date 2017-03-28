package br.com.bootstrapteste.conf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootstraptesteApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootstraptesteApplication.class, args);
	}

//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.postgresql.Driver");
//		dataSource.setUrl("jdbc:postgresql://localhost:5432/studiocontroller");
//		dataSource.setUsername("postgres");
//		dataSource.setPassword("root");
//		return dataSource;
//	}
	
}
