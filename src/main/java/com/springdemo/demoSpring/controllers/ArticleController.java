package com.springdemo.demoSpring.controllers;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.repositories.ArticleRepository;
import com.springdemo.demoSpring.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller // This means that this class is a Controller
@RestController
@RequestMapping(path="/articles") // This means URL's start with /demo (after Application path)
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewArticle (@RequestBody Article article) {
        this.articleService.createArticle(article);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Article> getAllArticle() {
        // This returns a JSON or XML with the users
        return articleRepository.findAll();
    }
}
