package com.revobank.backend.fitbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class BigBoostApplication {

	public static void main(String[] args) {
		SpringApplication.run(BigBoostApplication.class, args);
	}

}
