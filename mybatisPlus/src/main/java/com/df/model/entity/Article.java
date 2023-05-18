package com.df.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/**
 * @Author feng.dai
 * @Date 2023/5/18 9:33
 * @Project_Name mybatisPlus
 * @Package_Name com.df.model.entity
 */
@Data
@Document(collection = "article") //指定对应的集合名
@Accessors(chain = true)
public class Article {
    @Id
    private String id;

    private String articleName;

    private String content;
}
