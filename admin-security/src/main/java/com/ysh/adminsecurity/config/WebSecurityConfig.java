package com.ysh.adminsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;

import javax.servlet.http.HttpServletResponse;

/**
 * @author: ysh
 * @date: 2019/4/2 14:00
 * @Description:
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        // 禁用 csrf, 由于使用的是JWT，我们这里不需要csrf
////        http.cors().and().csrf().disable()
////                .authorizeRequests()
////                // 跨域预检请求
////                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
////                // web jars
////                .antMatchers("/webjars/**").permitAll()
////                // 查看SQL监控（druid）
////                .antMatchers("/druid/**").permitAll()
////                // 首页和登录页面
////                .antMatchers("/").permitAll()
////                .antMatchers("/login").permitAll()
////                // swagger
////                .antMatchers("/swagger-ui.html").permitAll()
////                .antMatchers("/swagger-resources").permitAll()
////                .antMatchers("/v2/api-docs").permitAll()
////                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
////                // 验证码
////                .antMatchers("/captcha.jpg**").permitAll()
////                // 服务监控
////                .antMatchers("/actuator/**").permitAll()
////                // 其他所有请求需要身份认证
////                .anyRequest().authenticated();
////        // 退出登录处理器
////        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        http.csrf().disable() //关闭CSRF
                .exceptionHandling()
                .authenticationEntryPoint((request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .authorizeRequests()
                .antMatchers("/**").authenticated()
                .and()
                .httpBasic();
    }


    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
