package com.ysh.eurekafeignclienta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
//启用服务注册与发现
@EnableDiscoveryClient
//启用feign进行远程调用
@EnableFeignClients
public class EurekaFeignClientAApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaFeignClientAApplication.class, args);
    }

}
