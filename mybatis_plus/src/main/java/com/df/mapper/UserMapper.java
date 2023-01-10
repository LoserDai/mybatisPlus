package com.df.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @Author feng.dai
 * 告诉容器你是持久层的 @Repository是spring提供的注释，能够将该类注册成Bean
 * @Date 2022/10/25 14:51
 * @Project_Name mybatis_plus
 * @Package_Name com.df.mapper
 */

@Repository
public interface UserMapper extends BaseMapper {
}
