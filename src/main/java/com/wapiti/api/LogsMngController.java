package com.wapiti.api;

import com.wapiti.support.response.ResponseContainer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author sue
 * @date 2020/11/24 23:13
 */
@RestController
public class LogsMngController {
    @GetMapping("logs/{adminId}")
    public ResponseContainer queryLogsByAdminId(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        return ResponseContainer.ideality();
    }
}
