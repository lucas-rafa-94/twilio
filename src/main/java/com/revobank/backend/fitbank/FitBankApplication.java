package com.revobank.backend.fitbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class FitBankApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitBankApplication.class, args);
	}

}
