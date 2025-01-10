package com.springdemo.demoSpring.entity.dto;

import com.springdemo.demoSpring.entity.classes.Article;
import com.springdemo.demoSpring.entity.classes.Like;
import com.springdemo.demoSpring.entity.classes.User;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.List;

public class ArticleDTO {

    private LocalDate publication;
    private String contenu;
    private User auteur;
    private List<Like> likes;

    public ArticleDTO(Article article) {
        this.publication = article.getPublication();
        this.contenu = article.getContenu();
        this.auteur = article.getAuteur();
        this.likes = article.getLikes();
    }

    public LocalDate getPublication() {
        return publication;
    }

    public String getContenu() {
        return contenu;
    }

    public User getAuteur() {
        return auteur;
    }

    public List<Like> getLikes() {
        return likes;
    }
}
