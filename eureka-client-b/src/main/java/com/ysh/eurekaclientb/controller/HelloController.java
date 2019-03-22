package com.ysh.eurekaclientb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ysh
 * @date: 2019/3/21 12:28
 * @Description:
 */
@RestController
@RequestMapping("hi")
public class HelloController {

    @Value("${server.port}")
    String port;

    @RequestMapping(value = "index",method = {RequestMethod.GET,RequestMethod.POST})
    public String index(@RequestParam String name){
        return "hi " + name + " ,port is " + port;
    }

}
