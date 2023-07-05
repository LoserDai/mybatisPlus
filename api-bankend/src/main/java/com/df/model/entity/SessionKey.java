package com.df.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author feng.dai
 * @Date 2023/5/17 12:56
 * @Project_Name get-qq-master
 * @Package_Name com.df.dto
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SessionKey implements Serializable {

    private Integer id;
    private String sessionkey;
    private String createdate;
}
