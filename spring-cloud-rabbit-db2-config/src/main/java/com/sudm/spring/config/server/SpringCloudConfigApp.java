package com.sudm.spring.config.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigApp.class, args);
	}

}
