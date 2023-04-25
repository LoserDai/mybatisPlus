package com.df.model.enums;

/**
 * @Author feng.dai
 * @Date 2023/3/7 9:53
 * @Project_Name mybatisPlus
 * @Package_Name com.df.model.enums
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 举报状态枚举类
 */
public enum ReportStatusEnum {
        DEFAULT("未处理", 0),
        HANDLED("已处理",1),
        ERROR("异常",2);
    private final String text;
    private final int value;

    ReportStatusEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     * @return
     */
    public static List<Integer> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    public String getText() {
        return text;
    }

    public int getValue() {
        return value;
    }
}
