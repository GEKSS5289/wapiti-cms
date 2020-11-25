package com.wapiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author sue
 * @date 2020/11/24 22:11
 */

@SpringBootApplication
@MapperScan(basePackages = "com.wapiti.mapper")
public class WapitiCMSApplication {
    public static void main(String[] args){
        SpringApplication.run(WapitiCMSApplication.class,args);
    }
}
