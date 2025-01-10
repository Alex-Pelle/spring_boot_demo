package com.springdemo.demoSpring.service;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.classes.Like;
import com.springdemo.demoSpring.entity.classes.User;
import com.springdemo.demoSpring.entity.repositories.ArticleRepository;
import com.springdemo.demoSpring.entity.repositories.LikeRepository;
import com.springdemo.demoSpring.entity.repositories.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final ArticleRepository articleRepository;

    public LikeService(LikeRepository likeRepository, UserRepository userRepository, ArticleRepository articleRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.articleRepository = articleRepository;
    }

    public Like likeOrDislikeArticle(Like likeParam) {

        User user = userRepository.findById(likeParam.getUser().getId().intValue())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Article article = articleRepository.findById(likeParam.getArticle().getId().intValue())
                .orElseThrow(() -> new RuntimeException("Article not found"));


        Optional<Like> existingLike = Optional.ofNullable(likeRepository.findByUserAndArticle(user, article));

        Like like;
        if (existingLike.isPresent()) {

            like = existingLike.get();
        } else {

            like = new Like();
            like.setUser(user);
            like.setArticle(article);
        }
        like.setIsLiked(likeParam.getIsLiked());
        return likeRepository.save(like);
    }
}

