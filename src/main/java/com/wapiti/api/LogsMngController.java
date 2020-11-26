package com.wapiti.api;

import com.wapiti.domain.vo.WapitiLogVO;
import com.wapiti.service.LogsMngService;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sue
 * @date 2020/11/24 23:13
 */
@RestController
public class LogsMngController {

    @Autowired
    private LogsMngService logsMngService;

    @GetMapping("logs/")
    public ResponseContainer queryLogsByAdminId(){
        List<WapitiLogVO> wapitiLogVOS = logsMngService.queryLogsByAdminId();
        return ResponseContainer.ideality(wapitiLogVOS);
    }
}
