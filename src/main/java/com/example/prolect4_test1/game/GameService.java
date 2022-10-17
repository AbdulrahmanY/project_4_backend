package com.example.prolect4_test1.game;

import com.example.prolect4_test1.genre.Genre;
import com.example.prolect4_test1.genre.GenreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepo gameRepo;
    private final GenreRepo genreRepo;

    @Autowired
    public GameService(GameRepo gameRepo, GenreRepo genreRepo) {
        this.gameRepo = gameRepo;
        this.genreRepo = genreRepo;
    }

    public List <Game> getGames(){return gameRepo.findAll();}

//    public Game getGameName (String name){return gameRepo.findByName(name);}

    public Game getGameId (String id){
        Long id_Game = Long.parseLong(id);
        return gameRepo.findById(id_Game).orElse(null);
    }

    public Game addGame(Game game){

        return gameRepo.save(game);}

    public void updateGame(String id, Game data){
        Long game_id = Long.parseLong(id);
        Game game = gameRepo.findById(game_id).orElse(null);

        if (game != null){
            game.setName(data.getName());
            game.setImg(data.getImg());
            game.setDescription(data.getDescription());
            gameRepo.save(game);
        }
    }

    public void deleteGame(String id){
        Long game_id = Long.parseLong(id);
        gameRepo.deleteById(game_id);
    }
}
