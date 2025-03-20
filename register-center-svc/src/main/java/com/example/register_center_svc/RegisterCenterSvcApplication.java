package com.example.register_center_svc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterCenterSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegisterCenterSvcApplication.class, args);
	}

}
