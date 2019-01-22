package com.springcloud.demo.clientconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@RestController
@RefreshScope
@SpringBootApplication
public class ClientConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientConfigApplication.class, args);
	}

	@Value("${hello}")
	String hello;

	@GetMapping("/hello")
	public String hello(){
		return hello;
	}

}

