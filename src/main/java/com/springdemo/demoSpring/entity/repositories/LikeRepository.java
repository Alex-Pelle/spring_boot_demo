package com.springdemo.demoSpring.entity.repositories;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.classes.Like;
import com.springdemo.demoSpring.entity.classes.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findByUser(User user);
    List<Like> findByArticle(Article article);
    Like findByUserAndArticle(User user, Article article);
}

