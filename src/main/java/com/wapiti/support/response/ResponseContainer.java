package com.wapiti.support.response;


import com.wapiti.common.enums.ResponseEnums;
import lombok.Data;

/**
 * @author sue
 * @date 2020/10/8 19:49
 */

@Data
public class ResponseContainer {


    private Integer status;
    private String message;
    private Object data;
    private Boolean success;




    public static ResponseContainer ideality(){
        return new ResponseContainer();
    }


    public static ResponseContainer ideality(ResponseEnums responseEnums, Object data){
        return new ResponseContainer(responseEnums,data);
    }

    public static ResponseContainer ideality(Object data){
        return new ResponseContainer(ResponseEnums.SUCCESS,data);
    }

    public static ResponseContainer bad(){
        return new ResponseContainer(ResponseEnums.FAILED,null);
    }

    public static ResponseContainer bad(Object data){
        return new ResponseContainer(ResponseEnums.FAILED,data);
    }




    private ResponseContainer(){
        this.status = ResponseEnums.SUCCESS.getStatus();
        this.message = ResponseEnums.SUCCESS.getMessage();
        this.success = ResponseEnums.SUCCESS.getSuccess();
        this.data = "ok";
    }

    private ResponseContainer(ResponseEnums responseEnums, Object data){
        this.status = responseEnums.getStatus();
        this.message = responseEnums.getMessage();
        this.success = responseEnums.getSuccess();
        this.data = data;
    }








}
