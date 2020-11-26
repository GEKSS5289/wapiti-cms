package com.wapiti.support.config;


import com.wapiti.support.interceptor.IPIntercepter;
import com.wapiti.support.interceptor.JwtIntercepter;
import com.wapiti.support.interceptor.LogsIntercepter;
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
    }
}
