package com.ll.sb20231114.domain.article.article.controller;

import com.ll.sb20231114.domain.article.article.entity.Article;
import com.ll.sb20231114.domain.article.article.service.ArticleService;
import com.ll.sb20231114.global.Rq;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Validated
public class ArticleController {
    private final ArticleService articleService;
    private final Rq rq;


    @GetMapping("/article/list")
    public String articleList(Model model) {
        List<Article> articles = articleService.findAll();
        model.addAttribute("articles", articles);
        return "article/list";
    }

    @GetMapping("/article/detail/{id}")
    public String articledetail(Model model,
                                @PathVariable long id) {
        Article article = articleService.getById(id).get();
        model.addAttribute("article", article);
        return "article/detail";
    }


//    @PostMapping("article/write")
//    @ResponseBody
//    public RsData<Article> articlewrite(
//            @NotBlank(message="제목 넣어줭") String title,
//            @NotBlank String body){
//        if(title == null || title.trim().length() == 0){
//            return new RsData<>(
//                    "f-1",
//                    "제목을 입력해주세요."
//            );
//        }
//        if(body == null || body.trim().length() == 0){
//            throw new IllegalArgumentException("내용을 입력해주세요.");
//        }
//
//        Article article = articleService.write(title, body);
//        return new RsData<>("COMPLETE","%d번 글이 작성되었습니다.",
//                article);
//
//    }
//

    @GetMapping("/article/write")
    public String articlewrite() {
        return "article/write";
    }

    @Data
    public static class WriteForm {
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("/article/write")
    public String articlewrite(
            @Valid WriteForm writeForm) {

        Article article = articleService.write(writeForm.title, writeForm.body);
        return rq.redirect("/article/list", "%d번 게시물이 생성되었습니다.".formatted(article.getId()));

    }

    @GetMapping("/article/modify/{id}")
    public String articelModify(
            Model model,
            @PathVariable long id) {
        Article article = articleService.getById(id).get();
        model.addAttribute("article", article);
        return "article/modify";
    }

    @Data
    public static class ModifyForm{
        @NotBlank
        private String title;
        @NotBlank
        private String body;
    }

    @PostMapping("/article/modify/{id}")
    public String articlemodify(
            @Valid ModifyForm modifyForm,
        @PathVariable long id) {

        articleService.modify(id, modifyForm.title, modifyForm.body);

        return rq.redirect("/article/list", "id %d번 게시물이 수정되었습니다.".formatted(id));
    }



    @PostMapping("/article/delete/{id}")
    public String articleRemove(@PathVariable long id) {
        articleService.removeById(id);
        return rq.redirect("/article/list","Id %d번 게시글이 삭제되었습니다.".formatted(id));
    }

    @GetMapping("/article/getLastArticle")
    @ResponseBody
    public Article articleGetLastArticle() {
        return articleService.findLastArticle();
    }

    @GetMapping("/article/getArticles")
    @ResponseBody
    public List<Article> articleGetArticles() {
        return articleService.findAll();
    }

}
