package com.wapiti.common.utils;


import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.wapiti.common.config.ALInfoConfig;
import com.wapiti.common.config.ALOSSConfig;
import com.wapiti.common.enums.ErrorEnums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author sue
 * @date 2020/11/18 21:39
 */
@Component
public class FileEjector {


    @Autowired
    private ALOSSConfig alossConfig;

    @Autowired
    private ALInfoConfig alInfoConfig;


    private void check(MultipartFile file){
        if(StringUtils.isBlank(file.getOriginalFilename())){
            ExceptionPerformer.Execute(ErrorEnums.FILE_NULL);
        }
    }

    //文件上传到oss文件服务器
    public String launch(MultipartFile file) throws IOException {

        this.check(file);
        // Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = alossConfig.getEndpoint();
        // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
        String accessKeyId = alInfoConfig.getAccessKeyID();
        String accessKeySecret = alInfoConfig.getAccessKeySecret();

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        String myObjectName = alossConfig.getObjectName() + file.getOriginalFilename();

        // 上传网络流。
        InputStream inputStream = file.getInputStream();
        ossClient.putObject(alossConfig.getBucketName(), myObjectName, inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();

        return alossConfig.getOssHost()+myObjectName;

    }
}
