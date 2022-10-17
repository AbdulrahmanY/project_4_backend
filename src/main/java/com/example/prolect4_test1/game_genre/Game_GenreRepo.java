package com.example.prolect4_test1.game_genre;

import com.example.prolect4_test1.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Game_GenreRepo extends JpaRepository<Game_Genre, Long> {
}
