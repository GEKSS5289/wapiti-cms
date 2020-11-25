package com.wapiti.my;


import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author sue
 * @date 2020/8/28 13:24
 */

public interface MyMapper<T> extends Mapper<T>, MySqlMapper {
}
