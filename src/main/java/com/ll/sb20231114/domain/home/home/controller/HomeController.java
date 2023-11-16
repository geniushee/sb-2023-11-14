package com.ll.sb20231114.domain.home.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/") // 해당 주소로 연결(?)
    public String goArticleList(){
        return "redirect:/article/list";
    }
}
