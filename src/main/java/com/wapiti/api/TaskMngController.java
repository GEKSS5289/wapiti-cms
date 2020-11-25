package com.wapiti.api;

import com.wapiti.domain.dto.TaskDTO;
import com.wapiti.domain.vo.WapitiTaskVO;
import com.wapiti.service.TaskMngService;
import com.wapiti.support.response.ResponseContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author sue
 * @date 2020/11/24 22:41
 */
@RestController
public class TaskMngController {
    @Autowired
    private TaskMngService taskMngService;

    @PostMapping("task")
    public ResponseContainer releaseTask(@RequestBody @Valid TaskDTO taskDTO){
        taskMngService.addTask(taskDTO);
        return ResponseContainer.ideality();
    }

    @PutMapping("task/finish/{taskId}")
    public ResponseContainer finishTask(@PathVariable @Valid Integer taskId){
        taskMngService.finish(taskId);
        return ResponseContainer.ideality();
    }

    @PutMapping("task/abolish/{taskId}")
    public ResponseContainer abolishTask(@PathVariable @Valid Integer taskId){
        taskMngService.abolition(taskId);
        return ResponseContainer.ideality();
    }

    @GetMapping("task/rel/{publisherId}")
    public ResponseContainer queryTaskByAdminId(@PathVariable @Valid Integer publisherId){
        List<WapitiTaskVO> wapitiTaskVOS = taskMngService.queryTaskByPublisherIdAll(publisherId);
        return ResponseContainer.ideality(wapitiTaskVOS);
    }

    @GetMapping("task/me/{executorId}")
    public ResponseContainer queryTaskBy(@PathVariable @Valid Integer executorId){
        List<WapitiTaskVO> wapitiTaskVOS = taskMngService.queryTaskByExecutorIdAll(executorId);
        return ResponseContainer.ideality(wapitiTaskVOS);
    }


}
