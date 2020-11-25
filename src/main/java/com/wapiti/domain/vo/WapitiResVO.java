package com.wapiti.domain.vo;


import com.wapiti.domain.entity.WapitiRes;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WapitiResVO {

    private Integer id;
    private String resName;
    private String resPath;
    private Long resSize;
    private String publishAdminName;
    private Boolean resStatus;
    private Boolean resDel;
    private Date createdTime;

//    public WapitiResVO(WapitiRes wapitiRes){
//        BeanUtils.copyProperties(wapitiRes,this);
//    }

}