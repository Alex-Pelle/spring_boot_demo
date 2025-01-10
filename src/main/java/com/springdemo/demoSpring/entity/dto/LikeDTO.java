package com.springdemo.demoSpring.entity.dto;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.classes.Like;
import com.springdemo.demoSpring.entity.classes.User;

import java.time.LocalDate;
import java.util.List;

public class LikeDTO {

    private Article article;
    private boolean isLiked;
    private User user;

    public LikeDTO(Like like) {
        this.article = like.getArticle();
        this.isLiked = like.getIsLiked();
        this.user = like.getUser();
    }

    public Article getArticle() {
        return article;
    }


    public boolean isLiked() {
        return isLiked;
    }



    public User getUser() {
        return user;
    }


}
