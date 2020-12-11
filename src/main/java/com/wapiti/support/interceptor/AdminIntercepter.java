package com.wapiti.support.interceptor;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.wapiti.common.constatnt.TokenParameter;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.JWTUtils;
import com.wapiti.domain.entity.WapitiAdmin;
import com.wapiti.mapper.WapitiAdminMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author sue
 * @date 2020/11/12 21:15
 */

@Component
public class AdminIntercepter extends HandlerInterceptorAdapter {


    @Autowired
    private WapitiAdminMapper wapitiAdminMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        DecodedJWT jwt = JWTUtils.jwtVerifier(request);

        String isFreeze = request.getHeader("isFreeze");
        String isRoot = request.getHeader("isRoot");



        Integer adminId = jwt.getClaim("adminId").asInt();
        Example example = new Example(WapitiAdmin.class);

        Example.Criteria criteria = example.createCriteria();
//        criteria.andEqualTo("isRoot",1);
        criteria.andEqualTo("id",adminId);
        WapitiAdmin wapitiAdmin = wapitiAdminMapper.selectOneByExample(example);



        if(wapitiAdmin == null){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_NOT_EXIST);
        }


        if(wapitiAdmin.getIsFreeze().toString()!=isFreeze || wapitiAdmin.getIsRoot().toString()!=isRoot){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_INFO_ERROR);
        }

        if(wapitiAdmin.getIsFreeze()!=jwt.getClaim("isFreeze").asBoolean()){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_INFO_ERROR);
        }

        if(wapitiAdmin.getIsDel()==true){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_NOT_EXIST);

        }else if(wapitiAdmin.getIsFreeze() == true){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_FREEZE);
        }



        return true;

    }
}
