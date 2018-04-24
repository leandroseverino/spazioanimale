package br.gov.caixa.pedes.sistemas.sigde;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SigdeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigdeApplication.class, args);
	}
}
