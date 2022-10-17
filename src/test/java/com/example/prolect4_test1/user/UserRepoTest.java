package com.example.prolect4_test1.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.junit.jupiter.api.Assertions.*;
@DataJdbcTest
class UserRepoTest {

    private UserRepo userRepo;

    @Autowired
    public UserRepoTest(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    void itShouldFindByUsername() {
    }
}