package com.springdemo.demoSpring.service;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.classes.User;
import com.springdemo.demoSpring.entity.repositories.ArticleRepository;
import com.springdemo.demoSpring.entity.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final UserRepository userRepository;

    public ArticleService(ArticleRepository articleRepository, UserRepository userRepository) {
        this.articleRepository = articleRepository;
        this.userRepository = userRepository;
    }

    public Article createArticle(Article article) {
        User user = userRepository.findById(article.getAuteur().getId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return articleRepository.save(article);
    }
}

