package com.wapiti.service;

import com.wapiti.domain.dto.TaskDTO;
import com.wapiti.domain.entity.WapitiAdmin;
import com.wapiti.domain.entity.WapitiTask;
import com.wapiti.domain.vo.WapitiTaskVO;
import com.wapiti.mapper.WapitiTaskMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author sue
 * @date 2020/11/24 22:42
 */

@Service
public class TaskMngService {

    @Autowired
    private WapitiTaskMapper wapitiTaskMapper;
    /**
     * 增加任务
     */
    public void addTask(TaskDTO taskDTO){
        WapitiTask wapitiTask = new WapitiTask();
        BeanUtils.copyProperties(taskDTO,wapitiTask);
        wapitiTask.setCreatedTime(new Date());
        wapitiTask.setTaskStatus(0);
        wapitiTask.setFinishTime(null);
        wapitiTaskMapper.insert(wapitiTask);
    }
    /**
     * 废除任务
     */
    public void abolition(Integer taskId){
        WapitiTask wapitiTask = new WapitiTask();
        wapitiTask.setId(taskId);
        wapitiTask.setTaskStatus(2);
        wapitiTask.setFinishTime(new Date());
        wapitiTaskMapper.updateByPrimaryKeySelective(wapitiTask);
    }
    /**
     * 完成任务
     */
    public void finish(Integer taskId){

        WapitiTask wapitiTask1 = new WapitiTask();
        wapitiTask1.setId(taskId);
        WapitiTask wapitiTask2 = wapitiTaskMapper.selectByPrimaryKey(wapitiTask1);

        if(wapitiTask1.getTaskStatus()==2){
            return;
        }

        WapitiTask wapitiTask = new WapitiTask();
        wapitiTask.setId(taskId);
        wapitiTask.setTaskStatus(1);
        wapitiTask.setFinishTime(new Date());
        wapitiTaskMapper.updateByPrimaryKeySelective(wapitiTask);
    }

    //TODO:前端遮罩层添加
    /**
     * 查询任务
     */
    public List<WapitiTaskVO> queryTaskByPublisherIdAll(Integer publisherId){

        List<WapitiTaskVO> wapitiTaskVOS = wapitiTaskMapper.queryAll(publisherId);
        return wapitiTaskVOS;
    }

    public List<WapitiTaskVO> queryTaskByExecutorIdAll(Integer executorId){
        List<WapitiTaskVO> wapitiTaskVOS = wapitiTaskMapper.queryByExecutorIdAll(executorId);
        return wapitiTaskVOS;
    }
}
