package com.wapiti.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.wapiti.common.constatnt.SMSCode;
import com.wapiti.common.constatnt.TokenParameter;
import com.wapiti.common.enums.ErrorEnums;
import com.wapiti.common.utils.ExceptionPerformer;
import com.wapiti.common.utils.IPUtil;
import com.wapiti.common.utils.RedisOperator;
import com.wapiti.common.utils.SMSUtils;
import com.wapiti.domain.dto.AdminDTO;
import com.wapiti.domain.dto.AdminLoginDTO;
import com.wapiti.domain.entity.WapitiAdmin;
import com.wapiti.domain.vo.WapitiAdminVO;
import com.wapiti.mapper.WapitiAdminMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sue
 * @date 2020/11/24 22:42
 */

@Service
public class AdminMngService {

    @Autowired
    private WapitiAdminMapper wapitiAdminMapper;

    @Autowired
    private RedisOperator redisOperator;

    @Autowired
    private SMSUtils smsUtils;

    /**
     *
     * 增加用户
     */
    public void addAdmin(AdminDTO adminDTO){

        Example example = new Example(WapitiAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("adminAccount",adminDTO.getAdminAccount());
        WapitiAdmin wapitiAdmin1 = wapitiAdminMapper.selectOneByExample(example);

        if(wapitiAdmin1 != null){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_EXIST);
        }

        Date date = new Date();
        WapitiAdmin wapitiAdmin = new WapitiAdmin();
        BeanUtils.copyProperties(adminDTO,wapitiAdmin);
        wapitiAdmin.setIsDel(false);
        wapitiAdmin.setIsRoot(false);
        wapitiAdmin.setIsFreeze(false);
        wapitiAdmin.setCreatedTime(date);
        wapitiAdmin.setUpdatedTime(date);
        wapitiAdminMapper.insert(wapitiAdmin);



    }
    /**
     * 冻结用户
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void freezeOrStart(Integer adminId) {
        WapitiAdmin wapitiAdmin= new WapitiAdmin();
        wapitiAdmin.setId(adminId);
        WapitiAdmin wapitiAdmintemp = wapitiAdminMapper.selectByPrimaryKey(wapitiAdmin);
        if(wapitiAdmintemp == null){
            ExceptionPerformer.Execute(ErrorEnums.NOT_FOUND_RESOURCE);
        }
        wapitiAdmintemp.setIsFreeze(!wapitiAdmintemp.getIsFreeze());
        wapitiAdminMapper.updateByPrimaryKey(wapitiAdmintemp);
    }
    /**
     * 删除用户
     */

    public void deleteAdmin(Integer adminId) {
        WapitiAdmin wapitiRes = new WapitiAdmin();
        wapitiRes.setId(adminId);
        wapitiRes.setIsDel(true);
        wapitiAdminMapper.updateByPrimaryKeySelective(wapitiRes);
    }

    //TODO:前端遮罩层添加


    /**
     * 查询用户
     */
    public List<WapitiAdminVO> queryAllAdmin(){
        Example example = new Example(WapitiAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createdTime").desc();
        criteria.andEqualTo("isDel",false);

        List<WapitiAdmin> wapitiAdmins = wapitiAdminMapper.selectByExample(example);
        List<WapitiAdminVO> collect = wapitiAdmins.stream().map(WapitiAdmin::toWapitiAdminVO).collect(Collectors.toList());
        return collect;
    }

    /**
     * 升级用户
     */
    public void upOrThawLevelAdmin(Integer adminId) {
        WapitiAdmin wapitiAdmin= new WapitiAdmin();
        wapitiAdmin.setId(adminId);
        WapitiAdmin wapitiAdmintemp = wapitiAdminMapper.selectByPrimaryKey(wapitiAdmin);
        if(wapitiAdmintemp == null){
            ExceptionPerformer.Execute(ErrorEnums.NOT_FOUND_RESOURCE);
        }
        wapitiAdmintemp.setIsRoot(!wapitiAdmintemp.getIsRoot());
        wapitiAdminMapper.updateByPrimaryKey(wapitiAdmintemp);
    }


    public String login(AdminLoginDTO adminLoginDTO){
        Example example = new Example(WapitiAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createdTime").desc();
        criteria.andEqualTo("adminAccount",adminLoginDTO.getAdminAccount());
        criteria.andEqualTo("isFreeze",false);
        criteria.andEqualTo("isDel",false);
        WapitiAdmin wapitiAdmin1 = wapitiAdminMapper.selectOneByExample(example);

        if(wapitiAdmin1 == null){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_EXCEPTION);
        }

        String code = redisOperator.get(SMSCode.SMS_CODE + ":" + adminLoginDTO.getAdminAccount());

        if(!code.equals(adminLoginDTO.getSmsCode())){
            ExceptionPerformer.Execute(ErrorEnums.SMSCODE_ERROR);
        }


        Algorithm algorithm = Algorithm.HMAC256(TokenParameter.JWT_KEY);

        String token = JWT.create()
                .withClaim("adminId",wapitiAdmin1.getId())
                .withClaim("isRoot",wapitiAdmin1.getIsRoot())
                .withClaim("name",wapitiAdmin1.getAdminName())
                .withClaim("face",wapitiAdmin1.getAdminFace())
//                .withExpiresAt(new Date(System.currentTimeMillis()+200))
                .sign(algorithm);
        return token;

    }


    public void sendSms(String phone, HttpServletRequest request){


        Example example = new Example(WapitiAdmin.class);
        Example.Criteria criteria = example.createCriteria();
        example.orderBy("createdTime").desc();
        criteria.andEqualTo("adminAccount",phone);
        criteria.andEqualTo("isFreeze",false);
        criteria.andEqualTo("isDel",false);
        WapitiAdmin wapitiAdmin1 = wapitiAdminMapper.selectOneByExample(example);

        if(wapitiAdmin1 == null){
            ExceptionPerformer.Execute(ErrorEnums.ADMIN_EXCEPTION);
        }

        //获得用户IP
        String userIp = IPUtil.getRequestIp(request);

//        根据用户ip进行限制，限制用户在60秒内只能获得一次验证码
        redisOperator.setnx60s(SMSCode.SMS_ADMIN_IP+":"+userIp,userIp);

        //随机短信验证码
        String random = (int)((Math.random()*9+1)*1000)+"";

        //TODO:调试暂时不开
//        smsUtils.sendSMS(phone,random);

        //将验证码存入redis，用于后续验证
        redisOperator.set(SMSCode.SMS_CODE+":"+phone,random,60);

    }
}
