package com.wapiti.support.config;


import com.wapiti.support.interceptor.JwtIntercepter;
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


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtIntercepter)
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/sms/**")
                .addPathPatterns("/task/**")
                .addPathPatterns("/story/**")
                .addPathPatterns("/admin/**")
                .addPathPatterns("/res/**");
    }
}
