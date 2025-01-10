package com.springdemo.demoSpring.entity.repositories;

import com.springdemo.demoSpring.entity.classes.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {

}
