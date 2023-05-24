package com.df.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author feng.dai
 * @Date 2023/5/9 17:09
 * @Project_Name mybatisPlus
 * @Package_Name com.df.model.entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserGroup implements Serializable {
    private Long id;

    private String groupName;
}
