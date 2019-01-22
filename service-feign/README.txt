# 服务注册
```
@EnableDiscoveryClient 注解实现服务注册
在 yml 配置文件中设置 consul 注册中心的地址
```

# 熔断
```
Hystrix 实现了服务熔断功能，在启动类上 @Hystrix、@EnableCircuitBreaker，
在方法上使用 @HystrixCommand 注解指定服务不可用时回调的方法
```

# 熔断监控
```
@EnableHystrixDashboard 实现 dashboard 面板
url: localhost:8902/hystrix
在dashboard url 中设置uri: localhost:8902/hystrix.stream
然后调用该服务的api（http://127.0.0.1:8902/serviceFeign/hi?name=feign）激活调用链，则 dashboard中将显示监控数据
```

# springboot actuator 监控
```
springboot actuator 提供基于web的时时监控，包括api、健康状况、配置参数等的查看
服务启动后在浏览器中输入：localhost:8902/actuator
```

# 负载均衡服务
```
启动两个 service-hi 服务（client1、client2）
在 service 层使用 @FeignClient 注解实现对 service-hi 服务的调用: http://127.0.0.1:8902/serviceFeign/hi?name=feign
feign 将轮询的方式将请求分发到 service-hi 上

```

# Hystrix DashBoard 监控面板
```
在浏览器中输入 url : localhost:8902/hystrix 进入监控面板
在监控面板的url 中输入: localhost:8902/hystrix.stream 实现对 service-feign 服务的监控
```

