package com.ysh.eurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter {
    private final Logger logger = LoggerFactory.getLogger(TokenFilter.class);

    @Override
    public String filterType() {
        /**
         * Zuul有一下四种过滤器
         * "pre":是在请求路由到具体的服务之前执行,这种类型的过滤器可以做安全校验,例如身份校验,参数校验等
         * "routing":它用于将请求路由到具体的微服务实例,在默认情况下,它使用Http Client进行网络请求
         * "post":它是在请求已被路由到微服务后执行,一般情况下,用作收集统计信息,指标,以及将响应传输到客户端
         * "error":它是在其他过滤器发生错误时执行
         */
        return "pre";
    }

    @Override
    public int filterOrder() {
        // filter执行顺序，通过数字指定 ,优先级为0，数字越大，优先级越低
        return 0;
    }

    /**
     * 表示该过滤器是否过滤逻辑,如果是ture,则执行run()方法;如果是false,则不执行run()方法.
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");// 获取请求的参数
        if (StringUtils.isNotBlank(token)) {
            ctx.setSendZuulResponse(true); //对请求进行路由
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
        } else {
            ctx.setSendZuulResponse(false); //不对其进行路由
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
        }
        return null;
    }
}
