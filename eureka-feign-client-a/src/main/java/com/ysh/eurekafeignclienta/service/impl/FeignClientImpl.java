package com.ysh.eurekafeignclienta.service.impl;

import com.ysh.eurekafeignclienta.feign.FeignClientInterface;
import com.ysh.eurekafeignclienta.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: ysh
 * @date: 2019/3/22 16:46
 * @Description:
 */
@Service
public class FeignClientImpl implements FeignService {

    @Autowired
    FeignClientInterface feignClientInterface;

    @Override
    public String getHi(String name) {
        return feignClientInterface.hello(name);
    }
}
