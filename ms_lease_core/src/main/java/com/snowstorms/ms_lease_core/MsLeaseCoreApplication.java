package com.snowstorms.ms_lease_core;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.snowstorms.ms_lease_core.dao")
public class MsLeaseCoreApplication {
	public static void main(String[] args) {
		SpringApplication.run(MsLeaseCoreApplication.class, args);
	}
}
