package com.MyApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

@SpringBootApplication
@Configuration
@PropertySource({"classpath:database.properties", "classpath:email.properties"})
public class MyApp {
	public static void main(String []args) {
//		SpringApplication.run(MyApp.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(MyApp.class, args);
		
		DataBase db = (DataBase)ctx.getBean(DataBase.class);
		System.out.println("databse username: "+ db.getUsername());
		System.out.println("databse password: "+ db.getPassword());
		
		Contact ct = (Contact)ctx.getBean(Contact.class);
		System.out.println("Email address: "+ ct.getEmail());
		System.out.println("Phone number: "+ ct.getPhone());
		
	}
	@Autowired
	Environment env;
	
	@Value("${mvapp.username}")
	public String username;
	
	@Value("${mvapp.password}")
	public String password;
	
	@Value("${my_email}")
	public String email;
	
	@Value("${my_phone}")
	public String phone;
	
	@Bean
	public DataBase getDetails() {
		DataBase db = new DataBase();
//		env_value = env.getProperty("ENV.NAME");
		db.setUsername(username);
		db.setPassword(password);
		return db;
	}
	
	@Bean
	public Contact getContact() {
		Contact ct = new Contact();
		ct.setEmail(email);
		ct.setPhone(phone);
		return ct;
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer property() {
		return new PropertySourcesPlaceholderConfigurer();
	}
}
