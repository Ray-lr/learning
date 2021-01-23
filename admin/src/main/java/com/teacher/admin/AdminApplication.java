package com.teacher.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/***
 *@author : Ray
 *@date :  2021/1/23 1:10
 *description: system admin starter
 ***/
@SpringBootApplication
@EnableEurekaClient
@EnableAutoConfiguration
@MapperScan("com.teacher.admin.mapper")
public class AdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class, args);
    }

}
