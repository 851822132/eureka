package com.ysh.eurekaribbonclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ysh
 * @date: 2019/3/22 14:53
 * @Description: ribbon配置文件
 */
@Configuration
public class RibbonConfig {

    //LoadBalanced 注解表明restTemplate使用LoadBalancerClient执行请求
    //LoadBalanced注解表明restTemplate结合Ribbon开启了负载均衡功能
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
