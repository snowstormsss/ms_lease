package com.snowstorms.ms_lease_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MsLeaseClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLeaseClientApplication.class, args);
	}
}
