
        package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
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
public class CouponController {
    private final CouponRepository repository;
    private final ProfileController profileController;

    public CouponController(CouponRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(Integer couponName, Integer couponOwner, Boolean couponForAllProducts, Boolean couponForBox, Integer couponReductionPercent, String couponQuantity, Integer couponLeftQuantity, Long couponAvailableDuration, Boolean couponAvailable,Timestamp createdAt) {
    }
    record UpdateRequest(Integer id, Integer couponName, Integer couponOwner, Boolean couponForAllProducts, Boolean couponForBox, Integer couponReductionPercent, String couponQuantity, Integer couponLeftQuantity, Long couponAvailableDuration, Boolean couponAvailable, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/useCouponInProduct")
    public Response useCouponInProduct() {
        return response;
    }

    @GetMapping("/getAllCoupon")
    public List<CouponModel> getAllCoupon() {
        return repository.findAll();
    }
    @GetMapping("/getCoupon{couponId}")
    public Response getBox(@RequestParam String couponId) {
        int id = Integer.parseInt(couponId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("coupon founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("coupon unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }
    @GetMapping("/getCouponByOwner{Id}")
    public Response getCouponByOwner(@RequestParam String Id) {
        int id = Integer.parseInt(Id);
        if (profileController.checkUserExist(Id)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("coupon for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findBycouponOwnerEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("coupon for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);







        }
        return response;


    }

    @PostMapping("/createCoupon")
    public Response createBox(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("couponName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<CouponModel> example = Example.<CouponModel>of(new CouponModel(request.couponName()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            CouponModel coupon = new CouponModel();
          coupon.setCouponAvailable(request.couponAvailable());
          coupon.setCouponForBox(request.couponForBox());
          coupon.setCouponName(request.couponName());
          coupon.setCouponOwner(request.couponOwner());
          coupon.setCouponQuantity(request.couponQuantity());
          coupon.setCreatedAt(request.createdAt());
          coupon.setCouponAvailableDuration(request.couponAvailableDuration());
          coupon.setCouponAvailable(request.couponAvailable());
          coupon.setCouponLeftQuantity(request.couponLeftQuantity());
          coupon.setCouponReductionPercent(request.couponReductionPercent());

            //ban
            //message
            repository.save(coupon);
            response.setMessage("coupon Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("coupon already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateCoupon")
    public Response updateCoupon(@RequestBody UpdateRequest request) {
        CouponModel coupon = new CouponModel();
        Optional<CouponModel> couponModel = repository.findById(request.id());
        if (couponModel.isPresent()){
            coupon.setCouponAvailable(request.couponAvailable());
            coupon.setCouponForBox(request.couponForBox());
            coupon.setCouponName(request.couponName());
            coupon.setCouponOwner(request.couponOwner());
            coupon.setCouponQuantity(request.couponQuantity());
            coupon.setCreatedAt(request.createdAt());
            coupon.setCouponAvailableDuration(request.couponAvailableDuration());
            coupon.setCouponAvailable(request.couponAvailable());
            coupon.setCouponLeftQuantity(request.couponLeftQuantity());
            coupon.setCouponReductionPercent(request.couponReductionPercent());
            coupon.setModifiedAt(request.modifiedAt());

            //ban
            //message
            repository.save(coupon);
            response.setMessage("coupon information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(coupon);
        }else {
            response.setMessage("coupon unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteCoupon{couponId}")
    public void deleteCoupon(@PathVariable("couponId") int id) {
        repository.deleteById(id);
    }
}

