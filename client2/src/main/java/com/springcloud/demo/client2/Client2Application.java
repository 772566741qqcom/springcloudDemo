package com.springcloud.demo.client2;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.consul.discovery.ConsulDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@RestController
@EnableCircuitBreaker
@EnableHystrixDashboard
@SpringBootApplication
@RequestMapping("/client")
public class Client2Application {

	public static void main(String[] args) {

		SpringApplication.run(Client2Application.class, args);
	}

	@Value("${server.port}")
	String port;
	@Autowired
	private LoadBalancerClient loadBalanacer;
	@Autowired
	private DiscoveryClient discoverClient;
	@Autowired
	private ConsulDiscoveryClient consulDiscoveryClient;

	/**
	 * 熔断
	 */
	@GetMapping("/hi")
	@HystrixCommand(fallbackMethod = "hiError")
	public String hi(@RequestParam("name") String name) {
		return "hi " + name + ",i am from port:" + port;
	}

	/**
	 * 熔断 callBack
	 */
	public String hiError(String name) {

		return "hi," + name + ",sorry,error!";
	}

	/**
	 * 服务发现
	 */
	@RequestMapping("/service1")
	public Object services() {

		return discoverClient.getServices();
	}

	/**
	 * 服务发现
	 */
	@RequestMapping("/discover")
	public Object discover() {

		return loadBalanacer.choose("service-config").getUri().toString();
	}

	/**
	 * 通过 ribbon 方式调用远程服务
	 */
	@GetMapping("ribbonCall")
	public void run(String... args) throws Exception {
		List<ServiceInstance> serviceInstanceList = consulDiscoveryClient
				.getInstances("service-consul");
		ServiceInstance serviceInstance = serviceInstanceList.get(0);

		String callServiceResult = new RestTemplate()
				.getForObject(serviceInstance.getUri().toString() + "/test/hi", String.class);
		System.out.println("ribbonCall ->" + callServiceResult);
	}
	@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}
}

