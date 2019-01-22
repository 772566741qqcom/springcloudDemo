# 服务注册
```
@EnableDiscoveryClient 注解实现服务注册
在 yml 配置文件中设置 consul 注册中心的地址
```


# dashboard 监控
```
@EnableHystrixDashboard 和 @EnableTurbine 实现dashboard面板的统一化管理
(配置文件中设置了 service-feign,client-hi 两个服务，则Turbine将这两个服务的面板统一管理)。
url: localhost:8903/hystrix
在dashboard url 中设置uri: localhost:8903/hystrix.stream
然后调用 service-feign,client-hi 服务,dashboard面板将刷新
```

# springboot actuator 监控
```
springboot actuator 提供基于web的时时监控，包括api、健康状况、配置参数等的查看
服务启动后在浏览器中输入：localhost:8902/actuator
```

