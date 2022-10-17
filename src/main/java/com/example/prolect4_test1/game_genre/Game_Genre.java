package com.example.prolect4_test1.game_genre;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.genre.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "game_genre")
public class Game_Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private Game game;

    @ManyToOne(fetch=FetchType.EAGER,optional = true)
    private Genre genre;


    public Game_Genre() {
    }

    public Game_Genre(Long id, Game game, Genre genre) {
        this.id = id;
        this.game = game;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}
