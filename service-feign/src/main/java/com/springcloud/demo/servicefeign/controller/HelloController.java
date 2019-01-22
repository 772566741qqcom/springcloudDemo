package com.springcloud.demo.servicefeign.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.demo.servicefeign.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceFeign")
public class HelloController {

	@Autowired
	HelloWorldService helloWorldFeignService;

	@GetMapping(value = "/hi")
	public String sayHello(@RequestParam("name") String name){

		return helloWorldFeignService.sayHello(name);
	}
}
