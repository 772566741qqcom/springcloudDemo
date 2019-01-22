package com.springcloud.demo.servicefeign.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloWorldServiceFailure implements HelloWorldService {
	@Override
	public String sayHello(@RequestParam("name") String name) {
		System.out.println("hello world service is not available !");
		return "hello world service is not available !";
	}
}
