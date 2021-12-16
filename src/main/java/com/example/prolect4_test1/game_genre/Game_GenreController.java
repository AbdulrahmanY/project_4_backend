package com.example.prolect4_test1.game_genre;

import com.example.prolect4_test1.game.GameRepo;
import com.example.prolect4_test1.genre.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="game_genre")
@CrossOrigin("*")
public class Game_GenreController {

    private final Game_GenreService game_genreService;


    @Autowired
    public Game_GenreController(Game_GenreService game_genreService) {
        this.game_genreService = game_genreService;
    }

    @GetMapping
    public List<Game_Genre> getAll(){return game_genreService.getAll();}

    @GetMapping("/{id}")
    public Game_Genre getGame_Genre(@PathVariable String id){
        return game_genreService.getGame_Genre(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable String id){
        game_genreService.deleteGame_Genre(id);
    }

    @PostMapping
    public Game_Genre addOne(@RequestBody Form form){
        return game_genreService.saveGame_Genre(form.getGame_genre(),form.getId_Game(),form.getId_Genre());
    }
}

class Form{

    private Game_Genre game_genre;
    private Long id_Game;
    private Long id_Genre;

    public Form(Game_Genre game_genre, Long id_Game, Long id_Genre) {
        this.game_genre = game_genre;
        this.id_Game = id_Game;
        this.id_Genre = id_Genre;
    }

    public Game_Genre getGame_genre() {
        return game_genre;
    }

    public Long getId_Game() {
        return id_Game;
    }

    public Long getId_Genre() {
        return id_Genre;
    }
}