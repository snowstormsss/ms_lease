package com.snowstorms.ms_lease_core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsLeaseCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLeaseCoreApplication.class, args);
	}
}
