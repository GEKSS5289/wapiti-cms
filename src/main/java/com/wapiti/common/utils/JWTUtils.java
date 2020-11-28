package com.wapiti.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.wapiti.common.constatnt.TokenParameter;
import com.wapiti.common.enums.ErrorEnums;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author sue
 * @date 2020/11/28 18:06
 */

public class JWTUtils {
    public static DecodedJWT jwtVerifier(HttpServletRequest request){

        String token = request.getHeader("token");

        if(StringUtils.isEmpty(token)){
            ExceptionPerformer.Execute(ErrorEnums.NOT_TOKEN);
        }

        Algorithm algorithm = Algorithm.HMAC256(TokenParameter.JWT_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt;
    }
}
