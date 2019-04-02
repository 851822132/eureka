package com.ysh.adminsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @author ysh
 * @date 2019-4-2 09:32:19
 */
@SpringBootApplication
@EnableDiscoveryClient
public class AdminSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminSecurityApplication.class, args);
    }

}
