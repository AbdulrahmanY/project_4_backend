package com.example.prolect4_test1.genre;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    private final GenreRepo genreRepo;

    @Autowired
    public GenreService(GenreRepo genreRepo) {
        this.genreRepo = genreRepo;
    }

    public List<Genre> getGenrs(){return genreRepo.findAll();}

    public Genre getGenreName(String name){return genreRepo.findByName(name);}

    public Genre addGenre(Genre genre){return genreRepo.save(genre);}

    public void updateGenre(String id,Genre data){
        Long genre_id = Long.parseLong(id);
        Genre genre = genreRepo.findById(genre_id).orElse(null);

        if (genre != null){
            genre.setName(data.getName());
            genreRepo.save(genre);
        }
    }
//    public void deleteGenre(String id){
//        Long genre_id = Long.parseLong(id);
//        genreRepo.deleteById(genre_id);
//    }
}
