package com.wapiti.mapper;


import com.wapiti.domain.entity.WapitiTask;
import com.wapiti.domain.vo.WapitiTaskVO;
import com.wapiti.my.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WapitiTaskMapper extends MyMapper<WapitiTask> {
    List<WapitiTaskVO> queryAll(@Param("paramsId")Integer publisherId);
    List<WapitiTaskVO> queryByExecutorIdAll(@Param("paramsId")Integer publisherId);
}