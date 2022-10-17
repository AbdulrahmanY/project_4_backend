package com.example.prolect4_test1.genre;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="genres")
@CrossOrigin("*")
public class GenreController {

    private final GenreService genreService;

    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping
    public List<Genre> getGenres(){return genreService.getGenrs();}

    @GetMapping("/{name}")
    public Genre getGenreName(@PathVariable String name){
        return genreService.getGenreName(name);
    }

    @PostMapping
    public Genre addGenre(@RequestBody Genre genre){return genreService.addGenre(genre);}

    @PutMapping("/{id}")
    public void updateGenre(@PathVariable String id, @RequestBody Genre data){
        genreService.updateGenre(id, data);
    }

//    @DeleteMapping("/{id}")
//    public void deleteGenre(@PathVariable String id){
//        genreService.deleteGenre(id);
//    }
}
