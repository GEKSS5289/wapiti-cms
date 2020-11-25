package com.wapiti.mapper;


import com.wapiti.domain.entity.WapitiRes;
import com.wapiti.domain.vo.WapitiResVO;
import com.wapiti.my.MyMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WapitiResMapper extends MyMapper<WapitiRes> {
    List<WapitiResVO> queryAll();
    List<WapitiResVO> queryNoCheck();
}