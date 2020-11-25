package com.wapiti.api;

import com.wapiti.domain.dto.ResDTO;
import com.wapiti.domain.vo.WapitiResVO;
import com.wapiti.service.ResourceMngService;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

/**
 * @author sue
 * @date 2020/11/24 22:40
 */
@RestController
public class ResourceMngController {

    @Autowired
    private ResourceMngService resourceMngService;

    @PostMapping("res/{adminId}")
    public ResponseContainer uploadres(
            @PathVariable @Valid @NotNull(message = "管理员id不能为空")Integer adminId,
            MultipartFile file
    ) throws IOException {


        resourceMngService.uploadFile(adminId,file);
        return ResponseContainer.ideality();

    }

    @GetMapping("res")
    public ResponseContainer queryResAll(){
        List<WapitiResVO> wapitiResVOS = resourceMngService.queryAllResInfo();
        return ResponseContainer.ideality(wapitiResVOS);
    }

    @GetMapping("res/check")
    public ResponseContainer queryResNoCheck(){
        List<WapitiResVO> wapitiResVOS = resourceMngService.queryNoCheckRes();
        return ResponseContainer.ideality(wapitiResVOS);
    }


    @PutMapping("res/{resId}")
    public ResponseContainer controlRes(@PathVariable @Valid @NotNull(message = "资源Id不能为空") Integer resId){
        resourceMngService.updateResStatus(resId);
        return ResponseContainer.ideality();
    }

    @PutMapping("res/pass/{resId}")
    public ResponseContainer passRes(@PathVariable @Valid @NotNull(message = "资源id不能为空")Integer resId){
        resourceMngService.passRes(resId);
        return ResponseContainer.ideality();
    }

    @PutMapping("res/nopass/{resId}")
    public ResponseContainer noPassRes(@PathVariable @Valid @NotNull(message = "资源id不能为空")Integer resId){
        resourceMngService.noPassRes(resId);
        return ResponseContainer.ideality();
    }



}
