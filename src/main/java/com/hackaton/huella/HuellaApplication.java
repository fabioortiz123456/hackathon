package com.hackaton.huella;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"com.hackaton.huella.model"})
@SpringBootApplication
public class HuellaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HuellaApplication.class, args);
	}

}
