package com.ysh.eurekafeignclienta.feign;

import org.springframework.stereotype.Component;

@Component
public class FeignServiceHystrix implements FeignClientInterface {

    @Override
    public String hello(String name) {
        return "sorry "+name+"，service has fail!";
    }
}
