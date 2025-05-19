package com.zonetest.eventdriven.demosender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemosenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemosenderApplication.class, args);
	}

}
