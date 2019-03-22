package com.ysh.eurekafeignclienta.controller;

import com.ysh.eurekafeignclienta.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class FeignController {

    @Autowired
    private FeignService feignService;

    @RequestMapping(value = "hi",method = {RequestMethod.GET,RequestMethod.POST})
    public String hi(@RequestParam(required = false,defaultValue = "ysh") String name){
        return feignService.getHi(name);
    }

}
