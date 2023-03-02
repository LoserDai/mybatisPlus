package com.mpolicy.dbfile.modules.system.entity;

import lombok.Data;

/**
 * <p> 数据库表字段信息 </p>
 *
 * @author : chenyu
 * @description :
 */
@Data
public class TableFileds {

    /**
     * 字段名
     */
    private String field;
    /**
     * 字段属性
     */
    private String type;
    /**
     * 是否为空
     */
    private String length;
    /**
     * 主键
     */
    private String key;
    /**
     * 字段说明
     */
    private String comments;
    /**
     * 默认值
     */
    private String Default;

}
