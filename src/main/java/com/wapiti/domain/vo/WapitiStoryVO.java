package com.wapiti.domain.vo;

import com.wapiti.domain.entity.WapitiStory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WapitiStoryVO {

    private Integer id;
    private Date createdTime;
    private String content;
    private String title;

    public WapitiStoryVO(WapitiStory wapitiStory){
        BeanUtils.copyProperties(wapitiStory,this);
    }
}