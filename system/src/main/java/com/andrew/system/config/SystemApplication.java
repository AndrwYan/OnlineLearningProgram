package com.andrew.system.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.andrew")
@MapperScan("com.andrew.server.mapper")
public class SystemApplication{

    public static void main(String[] args) {
        SpringApplication.run(SystemApplication.class,args);
    }
}
