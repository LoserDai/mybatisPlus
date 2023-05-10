package com.df.model.entity;

/**
 * @Author feng.dai
 * @Date 2023/3/2 12:24
 * @Project_Name mybatisPlus
 * @Package_Name com.df.pojo
 */
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableLogic
    //是否被删除
    private Integer isDeleted;

    private Integer groupId;
}
