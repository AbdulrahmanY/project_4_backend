package com.example.prolect4_test1.genre;

import com.example.prolect4_test1.game_genre.Game_Genre;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "genres")
public class Genre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Genre;
    private String name;

//    @OneToMany(mappedBy = "genre")
//    private List<Game_Genre> game_genres=new ArrayList<>();

    public Genre() {
    }

    public Genre(Long id_Genre, String name) {
        this.id_Genre = id_Genre;
        this.name = name;
        //this.game_genres = game_genres;
    }

    public Long getId_Genre() {
        return id_Genre;
    }

    public void setId_Genre(Long id_Genre) {
        this.id_Genre = id_Genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Game_Genre> getGame_genres() {
//        return game_genres;
//    }
//
//    public void setGame_genres(List<Game_Genre> game_genres) {
//        this.game_genres = game_genres;
//    }
}
