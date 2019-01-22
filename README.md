# springcloud demo
```asp
consul 用作注册中心和配置管理中心（eureka 2.x以后不再维护）
feign 用于负载均衡
zuul和gatewat 用于路由网关
turbine 用于熔断
zipkin-dashboard 用于服务链路追踪,A ->B ->C的一个长链路调用，在这里可以方便的通过web监控页面查看出来
server-config 用于配置文件管理（于consul做配置管理类似）
```

## [说明]
```asp
每个模块下都有对应的readme.md 说明文档
你需要做的就是在本地启动一个 consul服务，windows安装consul后执行命令：consul agent -dev 启动consul
然后启动微服务各个模块就好了。
后期会逐步补充各个模块的实现原理和说明文档。

```