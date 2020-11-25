package com.wapiti.api;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.wapiti.common.utils.RedisOperator;
import com.wapiti.domain.dto.AdminDTO;
import com.wapiti.domain.dto.AdminLoginDTO;
import com.wapiti.domain.vo.WapitiAdminVO;
import com.wapiti.service.AdminMngService;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sue
 * @date 2020/11/24 22:39
 */
@RestController
public class AdminMngController {

    @Autowired
    private AdminMngService adminMngService;




    @PostMapping("admin/login")
    public ResponseContainer login(@RequestBody @Valid AdminLoginDTO adminLoginDTO){
        String token = adminMngService.login(adminLoginDTO);
        return ResponseContainer.ideality(token);
    }

    @GetMapping("admin/sms/{phone}")
    public ResponseContainer sms(@PathVariable @Valid @NotBlank(message = "手机号不能为空")String phone, HttpServletRequest request){
        adminMngService.sendSms(phone,request);
        return ResponseContainer.ideality();
    }

    @PostMapping("admin")
    public ResponseContainer addAdmin(@RequestBody @Valid AdminDTO adminDTO){
        adminMngService.addAdmin(adminDTO);
        return ResponseContainer.ideality();
    }

    @GetMapping("admin")
    public ResponseContainer queryAdminAll(){
        List<WapitiAdminVO> wapitiAdminVOS = adminMngService.queryAllAdmin();
        return ResponseContainer.ideality(wapitiAdminVOS);
    }

    @PutMapping("admin/freeze/{adminId}")
    public ResponseContainer freezeAdmin(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        adminMngService.freezeOrStart(adminId);
        return ResponseContainer.ideality();
    }

    @PutMapping("admin/thaw/{adminId}")
    public ResponseContainer thawAdmin(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        adminMngService.freezeOrStart(adminId);
        return ResponseContainer.ideality();
    }

    @PutMapping("admin/up/{adminId}")
    public ResponseContainer upAdmin(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        adminMngService.upOrThawLevelAdmin(adminId);
        return ResponseContainer.ideality();
    }

    @PutMapping("admin/demote/{adminId}")
    public ResponseContainer demoteAdmin(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        adminMngService.upOrThawLevelAdmin(adminId);
        return ResponseContainer.ideality();
    }

    @DeleteMapping("admin/{adminId}")
    public ResponseContainer delAdmin(@PathVariable @Valid @NotNull(message = "adminId不能为空")Integer adminId){
        adminMngService.deleteAdmin(adminId);
        return ResponseContainer.ideality();
    }


}
