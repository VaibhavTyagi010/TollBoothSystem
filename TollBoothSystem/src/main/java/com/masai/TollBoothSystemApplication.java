package com.masai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TollBoothSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TollBoothSystemApplication.class, args);
	}

}
