package com.example.prolect4_test1.review;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.user.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Review;

    private String comment;

    @JsonIgnoreProperties("reviews")
    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private User user;

    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private Game game;

    public Review() {
    }

    public Review(Long id_Review, String comment, User user, Game game) {
        this.id_Review = id_Review;
        this.comment = comment;
        this.user = user;
        this.game = game;
    }

    public Long getId_Review() {
        return id_Review;
    }

    public void setId_Review(Long id_Review) {
        this.id_Review = id_Review;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
