package com.df.mapper.mysql;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.df.model.entity.Customer;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author feng.dai
 * @Date 2023/5/17 12:28
 * @Project_Name get-qq-master
 * @Package_Name com.df.mapper
 */
@Mapper
public interface CustomerMapper extends BaseMapper<Customer> {
}
