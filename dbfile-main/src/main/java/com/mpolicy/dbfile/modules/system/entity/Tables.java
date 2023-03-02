package com.mpolicy.dbfile.modules.system.entity;

import lombok.Data;

/**
 * <p> 数据库表信息 </p>
 *
 * @author : chenyu
 * @description :
 */
@Data
public class Tables {

    /**
     * 表名
     */
    private String name;
    /**
     * 表注释
     */
    private String comments;

}
