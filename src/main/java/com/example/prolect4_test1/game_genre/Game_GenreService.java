package com.example.prolect4_test1.game_genre;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.game.GameRepo;
import com.example.prolect4_test1.genre.Genre;
import com.example.prolect4_test1.genre.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Game_GenreService {

    private final Game_GenreRepo game_genreRepo;
    private final GameRepo gameRepo;
    private final GenreRepo genreRepo;

    @Autowired
    public Game_GenreService(Game_GenreRepo game_genreRepo, GameRepo gameRepo, GenreRepo genreRepo) {
        this.game_genreRepo = game_genreRepo;
        this.gameRepo = gameRepo;
        this.genreRepo = genreRepo;
    }

    public List<Game_Genre> getAll(){return game_genreRepo.findAll();}


    public Game_Genre getGame_Genre(String id){
        Long game_genre_id = Long.parseLong(id);
        return game_genreRepo.findById(game_genre_id).orElse(null);
    }

    public void deleteGame_Genre(String id){
        Long game_genre_id = Long.parseLong(id);
        game_genreRepo.deleteById(game_genre_id);
    }

    public Game_Genre saveGame_Genre(Game_Genre game_genre,Long id_Game, Long id_Genre){

        Game game = gameRepo.findById(id_Game).orElse(null);
        game_genre.setGame(game);

        Genre genre=genreRepo.findById(id_Genre).orElse(null);
        game_genre.setGenre(genre);

        return game_genreRepo.save(game_genre);
    }
}
