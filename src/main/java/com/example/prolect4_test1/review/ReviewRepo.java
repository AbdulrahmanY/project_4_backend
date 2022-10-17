package com.example.prolect4_test1.review;

import com.example.prolect4_test1.game_genre.Game_Genre;
import com.example.prolect4_test1.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

}
