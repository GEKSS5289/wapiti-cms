package com.wapiti.service;

import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.FileEjector;
import com.wapiti.domain.entity.WapitiRes;
import com.wapiti.domain.vo.WapitiResVO;
import com.wapiti.mapper.WapitiAdminMapper;
import com.wapiti.mapper.WapitiResMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tk.mybatis.mapper.entity.Example;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sue
 * @date 2020/11/24 22:42
 */
@Service
public class ResourceMngService {

    @Autowired
    private WapitiResMapper wapitiResMapper;

    @Autowired
    private FileEjector fileEjector;





    /**
     * 增加资源
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void uploadFile(Integer adminId, MultipartFile file) throws IOException {


        String resultPath = fileEjector.launch(file);

        Date date = new Date();
        WapitiRes tempFile = new WapitiRes();
        long fileSize = file.getSize()/1024;
        tempFile.setResName(file.getOriginalFilename());
        tempFile.setResSize(fileSize);
        tempFile.setResStatus(0);
        tempFile.setResDel(true);
        tempFile.setUpdatedTime(date);
        tempFile.setCreatedTime(date);
        tempFile.setPublishId(adminId);
        tempFile.setResPath(resultPath);
        tempFile.setResType(false);

        wapitiResMapper.insert(tempFile);


    }

    /**
     * 禁用资源或恢复资源
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateResStatus(Integer resId) {
        WapitiRes wapitiRes = new WapitiRes();
        wapitiRes.setId(resId);
        WapitiRes wapitiRestemp = wapitiResMapper.selectByPrimaryKey(wapitiRes);
        if(wapitiRestemp == null){
            ExceptionPerformer.Execute(ErrorEnums.NOT_FOUND_RESOURCE);
        }
        wapitiRestemp.setResDel(!wapitiRestemp.getResDel());
        wapitiResMapper.updateByPrimaryKey(wapitiRestemp);
    }

    //TODO:前端遮罩层添加
    /**
     * 查询资源
     */


    public List<WapitiResVO> queryAllResInfo() {

        List<WapitiResVO> wapitiResVOS = wapitiResMapper.queryAll();
        return wapitiResVOS;
    }

    /**
     * 查询待审核的资源
     */

    public List<WapitiResVO> queryNoCheckRes() {

//        Example example = new Example(WapitiResVO.class);
//        Example.Criteria criteria = example.createCriteria();
//        example.orderBy("createdTime").desc();
//        criteria.andEqualTo("resStatus",0);
//
//        List<WapitiResVO> collect = wapitiResMapper.selectByExample(example)
//                .stream()
//                .map(WapitiRes::toWapitiResVO)
//                .collect(Collectors.toList());
//
//        return collect;
        List<WapitiResVO> wapitiResVOS = wapitiResMapper.queryNoCheck();
        return wapitiResVOS;
    }


    /**
     * 资源审核通过
     * @param resId
     */
    public void passRes(Integer resId) {
        WapitiRes wapitiRes = new WapitiRes();
        wapitiRes.setId(resId);
        wapitiRes.setResStatus(2);
        wapitiResMapper.updateByPrimaryKeySelective(wapitiRes);
    }

    /**
     * 资源审核不通过
     * @param resId
     */
    public void noPassRes(Integer resId) {
        WapitiRes wapitiRes = new WapitiRes();
        wapitiRes.setId(resId);
        wapitiRes.setResStatus(1);
        wapitiResMapper.updateByPrimaryKeySelective(wapitiRes);
    }
}
