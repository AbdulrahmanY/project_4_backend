package com.example.prolect4_test1.game;

import com.example.prolect4_test1.game_genre.Game_Genre;
import com.example.prolect4_test1.genre.Genre;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @Column(name = "description",length = 3000)
    private String description;


    public Game() {
    }

    public Game(Long id_Game, String name, Boolean pc, Boolean ps, Boolean xbox, String release_data, String img, String description) {
        this.id_Game = id_Game;
        this.name = name;
        this.pc = pc;
        this.ps = ps;
        this.xbox = xbox;
        this.release_data = release_data;
        this.img = img;
        this.description = description;
        //this.game_genres = game_genres;
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

//    public List<Game_Genre> getGame_genres() {
//        return game_genres;
//    }
//
//    public void setGame_genres(List<Game_Genre> game_genres) {
//        this.game_genres = game_genres;
//    }
}
