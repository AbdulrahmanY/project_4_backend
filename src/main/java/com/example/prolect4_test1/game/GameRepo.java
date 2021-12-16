package com.example.prolect4_test1.game;

import com.example.prolect4_test1.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {
    public Game findByName(String name);
}
