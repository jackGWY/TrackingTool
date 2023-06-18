package com.example.demo.dao;


import com.example.demo.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * ArticleService实现类
 **/
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    /**
     * 添加文章
     *
     * @param article
     * @return
     */
    @Override
    public int create(Article article) {
        Article save = articleRepository.save(article);
        return 1;
    }

    /**
     * 删除文章
     *
     * @param ids
     */
    @Override
    public int delete(List<String> ids) {
        List<Article> deleteList = new ArrayList<>();

        for(String id:ids){
            Article article = new Article();
            article.setId(id);
            deleteList.add(article);
        }
        articleRepository.deleteAll(deleteList);

        return ids.size();
    }

    /**
     * 查询文章
     * @param id
     * @return
     */
    @Override
    public List<Article> list(String id) {
        return articleRepository.findByid(id);
    }

    @Override
    public List<Article> findLIstByName(String name) {
        List<Article> articleList = new ArrayList<>();
        Article article = new Article();
        System.out.println(name);
        article.setArticleName(name);
//        article.setContent("find by name content");
//        article.setId("123456755");
        Example<Article> articleExample = Example.of(article);
        articleList = articleRepository.findAll(articleExample);
        System.out.println(articleList);
        return articleList;
    }

    public List<Article> findLikeArticleList(){
        List<Article> articleList = new ArrayList<>();
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase(true);
        Article article = new Article();
        article.setArticleName("o");

        Example<Article> articleExample = Example.of(article, matcher);
        articleList = articleRepository.findAll(articleExample);
        System.out.println(articleList);
        return articleList;
    }
}

