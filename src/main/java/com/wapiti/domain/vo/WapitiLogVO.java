package com.wapiti.domain.vo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
public class WapitiLogVO {


    private String logContent;
    private Date createdTiem;


}