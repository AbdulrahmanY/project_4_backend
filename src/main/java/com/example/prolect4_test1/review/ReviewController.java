package com.example.prolect4_test1.review;

import com.example.prolect4_test1.game_genre.Game_Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="review")
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public List<Review> getReviews(){return reviewService.getReviews();}

    @GetMapping("/{id}")
    public Review getReview(@PathVariable String id){return reviewService.getReviewId(id);}

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id){
        reviewService.deleteReview(id);
    }

    @PostMapping
    public Review addOne(@RequestBody Form form){
        return reviewService.saveReview(form.getReview(),form.getId_User(),form.getId_Game());
    }

}
class Form {

    private Review review;
    private Long id_User;
    private Long id_Game;

    public Form(Review review, Long id_User, Long id_Game) {
        this.review = review;
        this.id_User = id_User;
        this.id_Game = id_Game;
    }

    public Review getReview() {
        return review;
    }

    public Long getId_User() {
        return id_User;
    }

    public Long getId_Game() {
        return id_Game;
    }
}