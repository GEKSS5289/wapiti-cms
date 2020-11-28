package com.wapiti.support.config;


import com.wapiti.support.interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sue
 * @date 2020/11/12 21:30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private JwtIntercepter jwtIntercepter;
    @Autowired
    private IPIntercepter ipIntercepter;
    @Autowired
    private LogsIntercepter logsIntercepter;
    @Autowired
    private AdminIntercepter adminIntercepter;
    @Autowired
    private PrivilegeIntercepter privilegeIntercepter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercepter)
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/sms/**")
                .addPathPatterns("/task/**")
                .addPathPatterns("/story/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/res/**");



        registry.addInterceptor(ipIntercepter)
                .addPathPatterns("/admin/sms/**");


        registry.addInterceptor(logsIntercepter)
                .addPathPatterns("/**");

        registry.addInterceptor(privilegeIntercepter)
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/sms/**")
                .excludePathPatterns("/res/finish/**")
                .addPathPatterns("/task")
                .addPathPatterns("/task/abolish/**")
                .addPathPatterns("/task/rel/**")
                .addPathPatterns("/admin")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/res/check/**");

        registry.addInterceptor(adminIntercepter)
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/sms/**")
                .excludePathPatterns("/res/finish/**")
                .addPathPatterns("/admin")
                .addPathPatterns("/task")
                .addPathPatterns("/res")
                .addPathPatterns("/story")
                .addPathPatterns("/story/**")
                .addPathPatterns("/res/**")
                .addPathPatterns("/task/finish/**")
                .addPathPatterns("/task/abolish/**")
                .addPathPatterns("/task/rel/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/res/check/**");



    }
}
