package com.ysh.eurekaribbonclient.controller;

import com.ysh.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ysh
 * @date: 2019/3/21 15:47
 * @Description:
 */
@RestController
public class RabbonController {

    @Autowired
    private RibbonService ribbonService;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("hi")
    public String hi(@RequestParam(required = false,defaultValue = "ysh") String name){
        return ribbonService.getHi(name);
    }

    @RequestMapping(value = "ribbon",method = {RequestMethod.GET,RequestMethod.POST})
    public String ribbon(){
        ServiceInstance instance = loadBalancerClient.choose("");
        return "host " + instance.getHost() + " ,port is " + instance.getPort();
    }
}
