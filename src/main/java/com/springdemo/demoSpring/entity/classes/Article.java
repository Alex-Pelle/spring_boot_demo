package com.springdemo.demoSpring.entity.classes;
import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.List;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "article_id")
    private Long id;

    private LocalDate publication;
    private String contenu;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User auteur;
    @OneToMany(mappedBy = "article", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Like> likes;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getPublication() {
        return publication;
    }

    public void setPublication(LocalDate publication) {
        this.publication = publication;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public User getAuteur() {
        return auteur;
    }

    public void setAuteur(User auteur) {
        this.auteur = auteur;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }
}
