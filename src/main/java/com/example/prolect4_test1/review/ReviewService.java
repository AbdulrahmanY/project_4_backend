package com.example.prolect4_test1.review;

import com.example.prolect4_test1.game.Game;
import com.example.prolect4_test1.game.GameRepo;
import com.example.prolect4_test1.game_genre.Game_Genre;
import com.example.prolect4_test1.genre.Genre;
import com.example.prolect4_test1.user.User;
import com.example.prolect4_test1.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepo reviewRepo;
    private final UserRepo userRepo;
    private final GameRepo gameRepo;

    @Autowired
    public ReviewService(ReviewRepo reviewRepo, UserRepo userRepo, GameRepo gameRepo) {
        this.reviewRepo = reviewRepo;
        this.userRepo = userRepo;
        this.gameRepo = gameRepo;
    }

    public List<Review> getReviews(){return reviewRepo.findAll();}

    public Review getReviewId(String id){
        Long review_id = Long.parseLong(id);
        return reviewRepo.findById(review_id).orElse(null);
    }

    public void deleteReview(String id){
        Long review_id = Long.parseLong(id);
        reviewRepo.deleteById(review_id);
    }
    public Review saveReview(Review review, Long id_User, Long id_Game){

        User user = userRepo.findById(id_User).orElse(null);
        review.setUser(user);

        Game game=gameRepo.findById(id_Game).orElse(null);
        review.setGame(game);

        return reviewRepo.save(review);
    }
}
