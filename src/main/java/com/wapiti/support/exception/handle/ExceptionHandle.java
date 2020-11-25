package com.wapiti.support.exception.handle;


import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ErrorMapGenerator;
import com.wapiti.support.exception.ErrorclampException;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author sue
 * @date 2020/10/8 20:21
 */

@RestControllerAdvice
public class ExceptionHandle {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseContainer methodArgumentExceptionHandler(MethodArgumentNotValidException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(e));
    }

    @ExceptionHandler(ErrorclampException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseContainer errorClampException(ErrorclampException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(e));
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.EXPECTATION_FAILED)
    public ResponseContainer NullPointerException(NullPointerException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(ErrorEnums.NOT_FOUND_RESOURCE.getMsg()));
    }

    @ExceptionHandler(TokenExpiredException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseContainer tokenExpiredException(TokenExpiredException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(ErrorEnums.TOKEN_FAILURE.getMsg()));
    }


    @ExceptionHandler(JWTDecodeException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseContainer jwtDecodeException(JWTDecodeException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(ErrorEnums.TOKEN_ERROR.getMsg()));
    }

    @ExceptionHandler(IOException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseContainer  iOException(IOException e){
        return ResponseContainer.bad(ErrorMapGenerator.errorPush(ErrorEnums.FILE_UPLOAD_FAIL.getMsg()));
    }
}
