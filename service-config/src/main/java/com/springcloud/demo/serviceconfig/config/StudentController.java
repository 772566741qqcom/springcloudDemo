package com.springcloud.demo.serviceconfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class StudentController {

	@Value("${myName}")
	private String myName;

	@Value("${port}")
	private String port;

	@Value("${server.port}")
	private String serverPort;


	@Autowired
	private StudentConfig studentConfig;

	@GetMapping("/myname")
	public String testHello() {
		String info = ",myName=" + myName;
		System.out.println(info);
		return info;
	}

	@GetMapping("/config")
	public String testConfig() {

		System.out.println(studentConfig.toString());
		return studentConfig.toString();
	}

}
