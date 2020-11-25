package com.wapiti.service;

import com.wapiti.domain.dto.StoryDTO;
import com.wapiti.domain.dto.StoryUpdateDTO;
import com.wapiti.domain.entity.WapitiStory;
import com.wapiti.domain.vo.WapitiStoryVO;
import com.wapiti.mapper.WapitiStoryMapper;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sue
 * @date 2020/11/24 22:42
 */
@Service
public class StoryMngService {

    @Autowired
    private WapitiStoryMapper wapitiStoryMapper;
    /**
     * 增加事迹
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void saveStory(StoryDTO storyDTO){

        Date date = new Date();
        WapitiStory wapitiStory = new WapitiStory();
        BeanUtils.copyProperties(storyDTO,wapitiStory);
        wapitiStory.setCreatedTime(date);
        wapitiStory.setIsDel(false);
        wapitiStory.setUpdatedTime(date);
        wapitiStoryMapper.insert(wapitiStory);

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<WapitiStoryVO> queryStoryByAdminId(Integer adminId){

        Example example = new Example(WapitiStory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adminId",adminId);
        example.orderBy("createdTime").desc();
        List<WapitiStory> wapitiStories = wapitiStoryMapper.selectByExample(example);
        List<WapitiStoryVO> collect = wapitiStories
                .stream()
                .map(WapitiStory::toWapitiStoryVO)
                .collect(Collectors.toList());

        return collect;
    }

    /**
     * 删除事迹
     */

    @Transactional(propagation = Propagation.REQUIRED)
    public void deleteStoryByAdminId(Integer storyId){

        WapitiStory wapitiStory = new WapitiStory();
        wapitiStory.setId(storyId);
        wapitiStoryMapper.delete(wapitiStory);

    }

    //TODO:前端遮罩层添加
    /**
     * 修改事迹
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateStoryByAdminId(Integer storyId, StoryUpdateDTO storyUpdateDTO){
        WapitiStory wapitiStory = new WapitiStory();
        BeanUtils.copyProperties(storyUpdateDTO,wapitiStory);
        wapitiStory.setId(storyId);
        wapitiStoryMapper.updateByPrimaryKeySelective(wapitiStory);
    }


    /**
     * 通过storyById查询
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    public WapitiStoryVO queryStoryById(Integer storyId){

        Example example = new Example(WapitiStory.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("id",storyId);

        WapitiStory wapitiStory = wapitiStoryMapper.selectOneByExample(example);
        return wapitiStory.toWapitiStoryVO();

    }

}
