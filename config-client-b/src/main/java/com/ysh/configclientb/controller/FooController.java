package com.ysh.configclientb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: ysh
 * @date: 2019/3/25 14:05
 * @Description:
 */
@RestController
// 使用该注解的类，会在接到SpringCloud配置中心配置刷新的时候，自动将新的配置更新到该类对应的字段中。
@RefreshScope
public class FooController {

    @Value("${foo}")
    private String foo;

    @RequestMapping("/foo")
    public String foo(){
        return foo;
    }
}
