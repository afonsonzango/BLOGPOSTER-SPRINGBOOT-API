package com.bloger.afonsonzango.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BloggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloggerApplication.class, args);
	}

}
