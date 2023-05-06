package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.controllers.ProfileController;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.ReviewRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/coupon")
@CrossOrigin
public class ReviewController {
    private final ReviewRepository repository;
    private final ProfileController profileController;

    public ReviewController(ReviewRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(Integer id, int userId, Integer reviewedProduct, String reviewValue, Timestamp createdAt, Timestamp modifiedAt) { }
    record UpdateRequest(Integer id, int userId, Integer reviewedProduct, String reviewValue, Timestamp createdAt, Timestamp modifiedAt) { }
    Response response = new Response();

    @GetMapping("/getAllItemReview")
    public List<ReviewModel> getAllItemReview() {
        return repository.findAll();
    }

    @GetMapping("/getAllReview")
    public List<ReviewModel> getAllReview() {
        return repository.findAll();
    }
    @GetMapping("/getReview{couponId}")
    public Response getReview(@RequestParam String reviewId) {
        int id = Integer.parseInt(reviewId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("review founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("review unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }
    @GetMapping("/getAllProductReview{Id}")
    public Response getAllProductReview(@RequestParam Integer Id) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("product reviews founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByreviewedProductEquals(Id));

        return response;


    }


    @GetMapping("/getAllUserReviews{Id}")
    public Response getAllProductReview(@RequestParam String Id) {
        int id = Integer.parseInt(Id);
        if (profileController.checkUserExist(Id)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("reviews for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByuserIdEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("reviews for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);







        }
        return response;


    }

    @PostMapping("/createReview")
    public Response createReview(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("userId", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ReviewModel> example = Example.<ReviewModel>of(new ReviewModel(request.reviewedProduct(),request.userId()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            ReviewModel review = new ReviewModel();
           review.setCreatedAt(request.createdAt());
           review.setReviewedProduct(review.getReviewedProduct());
           review.setReviewValue(review.getReviewValue());
           review.setModifiedAt(request.createdAt());
           review.setUserId(request.userId());


            //ban
            //message
            repository.save(review);
            response.setMessage("review Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("review already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateReview")
    public Response updateReview(@RequestBody UpdateRequest request) {
        ReviewModel review = new ReviewModel();
        Optional<ReviewModel> reviewModel = repository.findById(request.id());
        if (reviewModel.isPresent()){
            review.setCreatedAt(request.createdAt());
            review.setReviewedProduct(review.getReviewedProduct());
            review.setReviewValue(review.getReviewValue());
            review.setModifiedAt(request.createdAt());
            review.setUserId(request.userId());

            //ban
            //message
            repository.save(review);
            response.setMessage("review information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(review);
        }else {
            response.setMessage("review unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteReview{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int id) {
        repository.deleteById(id);
    }
}


