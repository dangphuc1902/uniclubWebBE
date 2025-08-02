package com.CyberSoft.uniclubWeb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UniclubWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(UniclubWebApplication.class, args);
	}
}
