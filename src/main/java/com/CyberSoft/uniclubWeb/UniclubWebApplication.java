package com.CyberSoft.uniclubWeb;

import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class UniclubWebApplication{
	public static void main(String[] args) {
		SpringApplication.run(UniclubWebApplication.class, args);
	}
}
