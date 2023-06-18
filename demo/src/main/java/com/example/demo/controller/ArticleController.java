package com.example.demo.controller;


import com.example.demo.dao.ArticleService;
import com.example.demo.entity.Article;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Web层，实现操作MongoDB
 **/
@RestController
@RequestMapping("/article")
@Api(tags = "文章操作")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @GetMapping("/test")
    public String test(@PathVariable("question") String question) {
        return "test...";
    }

    @PostMapping("/create")
    @ApiOperation("创建文章")
    public String create(@RequestBody Article article) {
        int result = articleService.create(article);
        if (result > 0) {
            return "文章创建成功";
        } else {
            return "文章创建失败";
        }
    }

    @PostMapping("/delete")
    @ApiOperation("批量删除文章")
    public String delete(@RequestParam("ids") List<String> ids) {
        int count = articleService.delete(ids);
        if (count > 0) {
            return "删除了" + count + "篇文章";
        } else {
            return "删除文章失败";
        }
    }

    @GetMapping("/list")
    @ApiOperation("查询")
    public List<Article> list(String id) {
        List<Article> list = articleService.list(id);
        return list;
    }

    @GetMapping ("/findByName")
    @ApiOperation("根据名字查询")
    public List<Article> findByNickName(String name) {
        List<Article> articleList = new ArrayList<>();
        System.out.println(name);
        articleList = articleService.findLIstByName(name);
        return articleList;
    }

    @PostMapping("/find")
    public List<Article> findLikeArticleList(){
        return articleService.findLikeArticleList();
    }

}


