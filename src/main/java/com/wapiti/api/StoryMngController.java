package com.wapiti.api;

import com.wapiti.domain.dto.StoryDTO;
import com.wapiti.domain.dto.StoryUpdateDTO;
import com.wapiti.domain.vo.WapitiStoryVO;
import com.wapiti.service.StoryMngService;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author sue
 * @date 2020/11/24 22:41
 */

@RestController
public class StoryMngController {

    @Autowired
    private StoryMngService storyMngService;

    @PostMapping("story")
    public ResponseContainer addStory(@RequestBody @Valid StoryDTO storyDTO){
        storyMngService.saveStory(storyDTO);
        return ResponseContainer.ideality();
    }

    @GetMapping("story/{adminId}")
    public ResponseContainer queryStoryByAdminId(
            @PathVariable @Valid @NotNull(message = "管理员id不能为空") Integer adminId){
        List<WapitiStoryVO> wapitiStoryVOS = storyMngService.queryStoryByAdminId(adminId);
        return ResponseContainer.ideality(wapitiStoryVOS);
    }

    @PutMapping("story/{storyId}")
    public ResponseContainer updateStoryById(
            @PathVariable @Valid @NotNull(message = "事迹id不能为空") Integer storyId,
            @RequestBody @Valid StoryUpdateDTO storyUpdateDTO){

        storyMngService.updateStoryByAdminId(storyId,storyUpdateDTO);
        return ResponseContainer.ideality();

    }

    @DeleteMapping("story/{storyId}")
    public ResponseContainer deleteStoryById(
            @PathVariable @Valid @NotNull(message = "事迹id不能为空") Integer storyId
    ){

        storyMngService.deleteStoryByAdminId(storyId);
        return ResponseContainer.ideality();
    }


    @GetMapping("story/one/{storyId}")
    public ResponseContainer queryStoryByStoryId(
            @PathVariable @Valid @NotNull(message = "事迹id不能为空") Integer storyId
    ){

        WapitiStoryVO wapitiStoryVO = storyMngService.queryStoryById(storyId);
        return ResponseContainer.ideality(wapitiStoryVO);
    }

}
