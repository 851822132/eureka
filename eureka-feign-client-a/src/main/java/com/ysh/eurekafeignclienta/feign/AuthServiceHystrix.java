package com.ysh.eurekafeignclienta.feign;

import com.ysh.eurekafeignclienta.vo.JWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author: ysh
 * @date: 2019/4/3 11:38
 * @Description:
 */
@Component
public class AuthServiceHystrix implements AuthServiceClient{
    private static final Logger log = LoggerFactory.getLogger(AuthServiceHystrix.class);


    @Override
    public JWT getToken(String authorization, String type, String username, String password) {
        log.error("远程调用失败");
        return null;
    }
}
