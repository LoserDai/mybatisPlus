package com.df.controller;

import com.df.model.entity.Article;
import com.df.service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @Author feng.dai
 * @Date 2023/5/18 10:19
 * @Project_Name mybatisPlus
 * @Package_Name com.df.controller
 */
@RestController
@RequestMapping("/article")
@Api(tags = "mongodb操作文章")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/create")
    @ApiOperation("创建文章")
    public String create(@RequestBody Article article){
        int i = articleService.create(article);
       return  i > 0 ? "创建成功" : "创建失败";
    }

    @PostMapping("/delete")
    @ApiOperation("批量删除文章")
    public String delete(@RequestParam("id") String id){
        int delete = articleService.delete(id);
        return delete > 0 ? "删除了" + delete : "失败!";
    }

    @GetMapping("/get")
    @ApiOperation("查询")
    public Article get(@RequestParam("id") String id){
        Article list = articleService.find(id);
        return list;
    }
}
