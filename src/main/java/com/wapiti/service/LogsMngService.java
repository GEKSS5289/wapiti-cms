package com.wapiti.service;

import com.wapiti.domain.entity.WapitiLog;
import com.wapiti.domain.vo.WapitiLogVO;
import com.wapiti.mapper.WapitiLogMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sue
 * @date 2020/11/24 22:48
 */
@Service
public class LogsMngService {

    @Autowired
    private WapitiLogMapper wapitiLogMapper;


    /**
     * 增加日志
     */
    public void addLogs(Integer admin,String content){
        WapitiLog wapitiLog = new WapitiLog();
        wapitiLog.setCreatedTiem(new Date());
        wapitiLog.setAdminId(admin);
        wapitiLog.setLogContent(content);
        wapitiLogMapper.insert(wapitiLog);
    }


    public List<WapitiLogVO> queryLogsByAdminId(){

        Example example = new Example(WapitiLog.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createdTiem").desc();

        List<WapitiLog> wapitiLogs = wapitiLogMapper.selectByExample(example);

        List<WapitiLogVO> collect = wapitiLogs.stream().map(w -> {
            WapitiLogVO wapitiLogVO = new WapitiLogVO();
            BeanUtils.copyProperties(w, wapitiLogVO);
            return wapitiLogVO;
        }).collect(Collectors.toList());

        return collect;

    }

}
