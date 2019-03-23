package com.ysh.eurekaribbonclient.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ysh.eurekaribbonclient.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: ysh
 * @date: 2019/3/21 15:44
 * @Description:
 */
@Service
public class RibbonServiceImpl implements RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(fallbackMethod = "helloFallback")
    public String getHi(String name) {
        return restTemplate.getForObject("http://eureka-client/hi/index?name=" + name,String.class);
    }

    public String helloFallback(String name) {
        return "sorry "+name+"，service has fail!";
    }
}
