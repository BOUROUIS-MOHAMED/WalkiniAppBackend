package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.ProductRepository;
import com.walkini.repositories.ReviewRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/review")
@CrossOrigin
public class ReviewController {
    private final ReviewRepository repository;

    private final ProfileController profileController;

    private  final ProductRepository productRepository;


    public ReviewController(ReviewRepository repository, ProfileController profileController, ProductRepository productRepository) {
        this.repository = repository;

        this.profileController = profileController;
        this.productRepository = productRepository;
    }


    record CreationRequest(Integer id, Integer userId, Integer reviewedProduct, Double reviewValue, String createdAt, String modifiedAt) { }
    record UpdateRequest(Integer id, Integer userId, Integer reviewedProduct, Double reviewValue, String createdAt, String modifiedAt) { }
    ResponseModel response = new ResponseModel();



    @GetMapping("/getAllReviews")
    public List<ReviewModel> getAllItemReview() {
        return repository.findAll();
    }


    @GetMapping("/getThisProductReview{Id}")
    public ResponseModel getAllProductReviews(@RequestParam Integer Id) {
        response.setMessage("product reviews founded");
        response.setErrorType(ErrorResponseType.Nothing);
        response.setErrorCode("20000");
        response.setObject(repository.findByreviewedProductEquals(Id));
        response.setReturnedBoolean(true);
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
        response.setThereIsAnError(false);
        return response;


    }


    @GetMapping("/getThisUserReviews{Id}")
    public ResponseModel getThisUserReviews(@RequestParam Integer id) {
        if (profileController.checkUserExistById(id).getReturnedBoolean()){
            response.setMessage("reviews for user founded");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setErrorCode("20000");
            response.setObject(repository.findByuserIdEquals(id));
            response.setReturnedBoolean(true);
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);

        }else{

            response.setMessage("user not founded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setReturnedBoolean(false);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);







        }
        return response;


    }

    @PostMapping("/reviewThisProduct")
    public ResponseModel reviewThisProduct(@RequestBody CreationRequest request )  {
     Optional<ProductModel> productModel=productRepository.findById(request.reviewedProduct());
     if (productModel.isPresent()){
         List<ReviewModel>reviewModelList =repository.findByUserIdAndReviewedProduct(request.userId(),request.reviewedProduct());
         if(reviewModelList.isEmpty()){
             ReviewModel review = new ReviewModel();
             review.setCreatedAt(request.createdAt());
             review.setReviewedProduct(request.reviewedProduct());
             review.setReviewValue(request.reviewValue());
             review.setModifiedAt(request.createdAt());
             review.setUserId(request.userId());
             repository.save(review);
             response.setMessage("review Added Successfully");
             response.setErrorType(ErrorResponseType.Nothing);
             response.setErrorCode("20000");
             response.setObject(review);
             response.setReturnedBoolean(true);
             response.setThereIsAnError(false);
             response.setReturnedInteger(null);
             response.setReturnedList(null);
             response.setReturnedString(null);
             response.setReturnedMultipartFile(null);
             response.setThereIsAnError(false);
         }else {
             ReviewModel review=reviewModelList.get(0);
             review.setReviewValue(request.reviewValue());
             review.setModifiedAt(request.createdAt());
             repository.save(review);
             response.setMessage("review modified Successfully");
             response.setErrorType(ErrorResponseType.Nothing);
             response.setErrorCode("20000");
             response.setObject(review);
             response.setReturnedBoolean(true);
             response.setThereIsAnError(false);
             response.setReturnedInteger(null);
             response.setReturnedList(null);
             response.setReturnedString(null);
             response.setReturnedMultipartFile(null);
             response.setThereIsAnError(false);
         }
     }else {
         response.setMessage("this product is unavailable");
         response.setErrorType(ErrorResponseType.NoDataFound);
         response.setErrorCode("40000");
         response.setObject(null);
         response.setReturnedBoolean(false);
         response.setThereIsAnError(true);
         response.setReturnedInteger(null);
         response.setReturnedList(null);
         response.setReturnedString(null);
         response.setReturnedMultipartFile(null);
         response.setThereIsAnError(false);
     }
        return response;
    }

    @DeleteMapping("/deleteReview{reviewId}")
    public void deleteReview(@PathVariable("reviewId") int id) {
        repository.deleteById(id);
    }
}


