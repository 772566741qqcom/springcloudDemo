# warn
```
pom 文件中不要引入pring-boot-start-web 依赖,否则会报错：
Description:
Parameter 0 of method modifyRequestBodyGatewayFilterFactory in
org.springframework.cloud.gateway.config.GatewayAutoConfiguration required a bean of
type 'org.springframework.http.codec.ServerCodecConfigurer' that could not be found.
Action:
Consider defining a bean of type 'org.springframework.http.codec.ServerCodecConfigurer' in your configuration.

错误分析：
根据上面描述（Description）中信息了解到GatewayAutoConfiguration这个配置中找不到ServerCodecConfig这个Bean。
spring cloud gateway server项目是一个spring boot项目，在启动的时候会去加载它的配置，其中有一个叫做GatewayClassPathWarningAutoConfiguration的配置类中有这么一行代码：
@Configuration
@ConditionalOnClass(name = "org.springframework.web.servlet.DispatcherServlet")
protected static class SpringMvcFoundOnClasspathConfiguration {
	public SpringMvcFoundOnClasspathConfiguration() {
		log.warn(BORDER+"Spring MVC found on classpath, which is incompatible with Spring Cloud Gateway at this time. "+
		"Please remove spring-boot-starter-web dependency."+BORDER);
	}
}
 log.warn中翻译一下意思就是“在类路径上找到的Spring MVC，此时它与Spring Cloud网关不兼容。请删除spring-boot-start-web依赖项。”。
因为spring cloud gateway是基于webflux的，如果非要web支持的话需要导入spring-boot-starter-webflux而不是spring-boot-start-web。
```

