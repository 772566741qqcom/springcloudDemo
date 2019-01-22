# 服务注册
```
@EnableDiscoveryClient 注解实现服务注册
在 yml 配置文件中设置 consul 注册中心的地址
```

# springboot actuator 监控
```
springboot actuator 提供基于web的时时监控，包括api、健康状况、配置参数等的查看
服务启动后在浏览器中输入：localhost:8902/actuator
```

# 路由网关
```
两个同名的服务 client-hi , 使用zuul 的网关服务，当请求是 /hi/* 开头时，会自动分发到 client-hi
```

