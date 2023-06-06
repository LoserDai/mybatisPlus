package com.df.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author feng.dai
 * @Date 2023/5/17 12:29
 * @Project_Name get-qq-master
 * @Package_Name com.df.dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
    private Long id;
    private String nickName;
    private String email;
    private Integer age;
    private Integer level;
    private String sign;
    private String sex;
    private String remark;
}
