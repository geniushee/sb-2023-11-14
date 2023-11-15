package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.global.rsData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ArticleController {

    private final ArticleService articleService = new ArticleService();



    @GetMapping("article/write")
    public String articlewrite(){
        return "article/write";

    }

    @PostMapping("article/write")
    @ResponseBody
    public rsData<Article> articlewrite(
            String title,
            String body){
        Article article = articleService.write(title, body);
        return new rsData<>("COMPLETE","%d번 글이 작성되었습니다.",
                article);

    }

    @GetMapping("article/getLastArticle")
    @ResponseBody
    public Article articleGetLastArticle(){
        return articleService.findLastArticle();
    }

    @GetMapping("article/getArticles")
    @ResponseBody
    public List<Article> articleGetArticles(){
        return articleService.findAll();
    }

}
