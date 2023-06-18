package com.example.demo.dao;



import com.example.demo.entity.Article;

import java.util.ArrayList;
import java.util.List;

public interface ArticleService {

    /**
     * 添加文章
     * @param article
     * @return
     */
    int create(Article article);

    /**
     * 删除文章
     */

    int delete(List<String> ids);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    List<Article> list(String id);

    List<Article> findLIstByName(String name);

    List<Article> findLikeArticleList();
}

