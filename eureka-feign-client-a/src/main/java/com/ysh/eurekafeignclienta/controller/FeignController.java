package com.ysh.eurekafeignclienta.controller;

import com.ysh.eurekafeignclienta.feign.AuthServiceClient;
import com.ysh.eurekafeignclienta.service.FeignService;
import com.ysh.eurekafeignclienta.vo.JWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: ysh
 * @date: 2019/3/21 15:47
 * @Description:
 */
@RestController
public class FeignController {
    private static final Logger log = LoggerFactory.getLogger(FeignController.class);

    @Autowired
    private FeignService feignService;
    @Autowired
    private AuthServiceClient authServiceClient;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "hi", method = {RequestMethod.GET, RequestMethod.POST})
    public String hi(@RequestParam(required = false, defaultValue = "ysh") String name) {
        return feignService.getHi(name);
    }

    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public Object login(HttpServletRequest request, String username, String password) {
        String authorization = request.getHeader("Authorization");
        log.error("获取到的token是：{}",authorization);

        String a = passwordEncoder.encode(password);
        log.error("转换1：----" + a + "-----------");
        boolean res = passwordEncoder.matches(password,a);
        log.error("匹配结果是："+ res);

        JWT jwt = authServiceClient.getToken("Basic dXNlci1zZXJ2aWNlOjEyMzQ1Ng==", "password", username, password);
        log.error("转换2------"+passwordEncoder.encode(password)+"---------------");
        log.info("收到的结果是：",jwt);
        if(jwt == null){
            throw new RuntimeException("get token error");
        }
        return jwt;
    }

    @RequestMapping(value = "auth", method = {RequestMethod.GET, RequestMethod.POST})
    @PreAuthorize("hasAuthority('sys:user:edit')")
    public String auth() {

        return "拥有权限";
    }

}
