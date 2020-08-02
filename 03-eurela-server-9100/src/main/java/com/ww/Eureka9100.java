package com.ww;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Eureka9100 {

    public static void main(String[] args) {
        SpringApplication.run(Eureka9100.class, args);
    }

}
