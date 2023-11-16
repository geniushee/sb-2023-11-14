package com.ll.sb20231114.domain.article.article.service;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 저는 단 한번만 생성되고, 그 이후에는 재사용 되는 객체입니다. component와 차이가 없다
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired // 생성자가 단독이라면 Autowired 생략가능
    public ArticleService(ArticleRepository articleRepository){
        this.articleRepository = articleRepository;
    }

    public Article write(String title, String body) {
        Article article = new Article(title, body);
        articleRepository.save(article);
        return article;
    }

    public Article findLastArticle() {
        return articleRepository.findLastArticle();
    }

    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    public Optional<Article> getById(long id) {
        Optional<Article> oparticle = articleRepository.getById(id);
        return oparticle;
    }

    public void removeById(long id) {
        articleRepository.removeById(id);
    }

    public void modify(long id, String title, String body) {
        Article article = articleRepository.getById(id).get();
        article.setTitle(title);
        article.setBody(body);


    }
}
