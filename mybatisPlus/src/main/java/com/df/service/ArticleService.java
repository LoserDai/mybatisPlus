package com.df.service;

import com.df.model.entity.Article;

import java.util.List;

/**
 * @Author feng.dai
 * @Date 2023/5/18 10:08
 * @Project_Name mybatisPlus
 * @Package_Name com.df.service
 */
public interface ArticleService {

    int create(Article article);

    int delete(String id);

    Article find(String id);
}
