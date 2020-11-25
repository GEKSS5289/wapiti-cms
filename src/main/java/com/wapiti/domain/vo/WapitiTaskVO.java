package com.wapiti.domain.vo;

import com.wapiti.domain.entity.WapitiTask;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class WapitiTaskVO {

    private Integer id;
    private String executorName;
    private String publisherName;
    private String taskTitle;
    private Integer taskLevel;
    private Integer taskStatus;
    private Date finishTime;
    private String taskContent;

//    public WapitiTaskVO(WapitiTask wapitiTask){
//        BeanUtils.copyProperties(wapitiTask,this);
//    }
}