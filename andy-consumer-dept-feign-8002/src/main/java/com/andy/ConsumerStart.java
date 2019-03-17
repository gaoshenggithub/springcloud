package com.andy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients({ "com.andy" })
// 当前启动类的包名
@ComponentScan("com.andy")
// 当前启动了的包名
@EnableDiscoveryClient
public class ConsumerStart {
	public static void main(String[] args) {
		SpringApplication.run(ConsumerStart.class, args);
	}
}
