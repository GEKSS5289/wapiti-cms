package com.wapiti.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author sue
 * @date 2020/10/1 11:37
 */



@Component
@PropertySource("classpath:aliyun.properties")
@ConfigurationProperties(prefix = "aliyun")
@Data
/**
 * Aliyun账号配置
 */
public class ALInfoConfig {
    private String accessKeyID;
    private String accessKeySecret;
}
