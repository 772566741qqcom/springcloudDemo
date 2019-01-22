package com.springcloud.demo.servicegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceGatewayApplication.class, args);
	}

	/**
	 * 除了配置文件方式 还可以 直接把路由转发规则写进启动类中：
	 * @param builder
	 * @return
	 */
	/*@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/jianshu")
						.uri("http://www.jianshu.com/u/128b6effde53")
				)
				.route(r -> r.path("/userapi3/**")
						.filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))
						.uri("lb://user-service/")
				)
				.build();
	}*/
}

