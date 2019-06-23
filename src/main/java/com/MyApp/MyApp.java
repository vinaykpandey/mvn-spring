package com.MyApp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@Configuration
@PropertySource("classpath:database.properties")
public class MyApp {
	public static void main(String []args) {
//		SpringApplication.run(MyApp.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(MyApp.class, args);
		DataBase db = (DataBase)ctx.getBean(DataBase.class);
		System.out.println("databse username: "+ db.getUsername());
		System.out.println("databse password: "+ db.getPassword());
		
	}
	
	@Value("${mvapp.username}")
	public String username;
	
	@Value("${mvapp.password}")
	public String password;
	
	@Bean
	public DataBase getDetails() {
		DataBase db = new DataBase();
		db.setUsername(username);
		db.setPassword(password);
		return db;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
