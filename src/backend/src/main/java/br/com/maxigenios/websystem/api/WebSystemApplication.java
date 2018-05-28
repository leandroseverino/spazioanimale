package br.com.maxigenios.websystem.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WebSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSystemApplication.class, args);
	}
}
