package com.example.prolect4_test1.game;

import com.example.prolect4_test1.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="games")
@CrossOrigin("*")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames(){return gameService.getGames();}

//    @GetMapping("/{name}")
//    public Game getGameName(@PathVariable String name){
//        return gameService.getGameName(name);
//    }

    @GetMapping("/{id}")
    public Game getGameId(@PathVariable String id){return gameService.getGameId(id);}

    @PostMapping
    public Game addGame(@RequestBody Game game){return gameService.addGame(game);}

    @PutMapping("/{id}")
    public void updateGame(@PathVariable String id, @RequestBody Game data){
        gameService.updateGame(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteGame(@PathVariable String id){
        gameService.deleteGame(id);
    }

}
