package com.wapiti.domain.vo;

import com.wapiti.domain.entity.WapitiAdmin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;


/**
 * @author sue
 * @date 2020/11/24 23:11
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WapitiAdminVO {

    private Integer id;
    private String adminFace;
    private String adminName;
    private String adminAccount;
    private Boolean isFreeze;
    private Boolean isRoot;

    public WapitiAdminVO(WapitiAdmin wapitiAdmin){
        BeanUtils.copyProperties(wapitiAdmin,this);
    }

}
