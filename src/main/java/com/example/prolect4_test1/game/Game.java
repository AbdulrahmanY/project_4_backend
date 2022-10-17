package com.example.prolect4_test1.game;


import com.example.prolect4_test1.genre.Genre;
import com.example.prolect4_test1.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Game;
    private String name;
    private Boolean pc=false;
    private Boolean ps=false;
    private Boolean xbox=false;
    private String release_data;
    private String img;
    private String developer;
    private String publisher;
    @Column(name = "description",length = 3000)
    private String description;

    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_Genre")
    private List<Genre> genre=new ArrayList<>();

    @JsonIgnoreProperties("game")
    @OneToMany(mappedBy = "game",cascade = CascadeType.ALL)
    private List<Review> reviews;

    public Game() {
    }

    public Game(Long id_Game, String name, Boolean pc, Boolean ps, Boolean xbox, String release_data, String img, String developer, String publisher, String description, List<Genre> genre, List<Review> reviews) {
        this.id_Game = id_Game;
        this.name = name;
        this.pc = pc;
        this.ps = ps;
        this.xbox = xbox;
        this.release_data = release_data;
        this.img = img;
        this.developer = developer;
        this.publisher = publisher;
        this.description = description;
        this.genre = genre;
        this.reviews = reviews;
    }

    public Long getId_Game() {
        return id_Game;
    }

    public void setId_Game(Long id_Game) {
        this.id_Game = id_Game;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_data() {
        return release_data;
    }

    public void setRelease_data(String release_data) {
        this.release_data = release_data;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getPc() {
        return pc;
    }

    public void setPc(Boolean pc) {
        this.pc = pc;
    }

    public Boolean getPs() {
        return ps;
    }

    public void setPs(Boolean ps) {
        this.ps = ps;
    }

    public Boolean getXbox() {
        return xbox;
    }

    public void setXbox(Boolean xbox) {
        this.xbox = xbox;
    }

    public List<Genre> getGenre() {
        return genre;
    }

    public void setGenre(List<Genre> genre) {
        this.genre = genre;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
