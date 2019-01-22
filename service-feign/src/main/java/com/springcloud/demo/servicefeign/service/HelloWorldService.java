package com.springcloud.demo.servicefeign.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "CLIENT-HI",fallback =HelloWorldServiceFailure.class)
public interface HelloWorldService {

	@RequestMapping(value = "/client/hi",method = RequestMethod.GET)
	String sayHello(@RequestParam("name") String name);
}
