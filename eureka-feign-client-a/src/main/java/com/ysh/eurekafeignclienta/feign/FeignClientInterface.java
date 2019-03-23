package com.ysh.eurekafeignclienta.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: ysh
 * @date: 2019/3/22 16:37
 * @Description:
 */
//value为远程调用其它服务的服务名
@FeignClient(value = "eureka-client",fallback = FeignServiceHystrix.class)
public interface FeignClientInterface {

    @GetMapping("/hi/index")
    String hello(@RequestParam(value = "name") String name);

}
