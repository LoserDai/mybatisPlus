package com.df.service;

import com.df.model.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

/**
 * @Author feng.dai
 * @Date 2023/5/18 10:10
 * @Project_Name mybatisPlus
 * @Package_Name com.df.service
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private MongoTemplate template;

    @Override
    public int create(Article article) {
        Article save = template.save(article);
        return 1;
    }

    @Override
    public int delete(String id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));
        template.remove(query,Article.class);
        return 1;
    }

    @Override
    public Article find(String id) {
        Article byId = template.findById(id, Article.class);
        return byId;
    }
}
