package com.ysh.eurekaclientb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EurekaClientBApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientBApplication.class, args);
    }

}
