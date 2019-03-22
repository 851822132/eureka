package com.ysh.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("index")
    public String index(@RequestParam String name){
        return "hi " + name + " ,port is " + port;
    }
}
