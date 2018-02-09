package com.snowstorms.ms_lease_configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MsLeaseConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsLeaseConfigserverApplication.class, args);
	}
}
