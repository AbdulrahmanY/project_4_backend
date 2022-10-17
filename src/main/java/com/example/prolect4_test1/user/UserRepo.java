package com.example.prolect4_test1.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    public User findByUsername(String username);
    public User findByEmail(String email);
}
