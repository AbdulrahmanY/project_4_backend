package com.example.prolect4_test1.genre;

import com.example.prolect4_test1.game.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre, Long> {
    public Genre findByName(String name);
}
