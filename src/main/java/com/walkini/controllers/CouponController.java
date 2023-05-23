
        package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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


    record CreationRequest(Integer id, String couponName, Integer couponOwner, Double couponReductionPercent, Integer couponQuantity, Integer couponLeftQuantity, Long couponAvailableDurationInSeconds, Boolean couponAvailable, Boolean couponOnlyForOwner, Boolean couponForBox, String createdAt, String modifiedAt){}
    record UpdateRequest(Integer id, String couponName, Integer couponOwner, Double couponReductionPercent, Integer couponQuantity, Integer couponLeftQuantity, Long couponAvailableDurationInSeconds, Boolean couponAvailable, Boolean couponOnlyForOwner, Boolean couponForBox, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();

    @GetMapping("/useCouponInProduct")
    public ResponseModel useCouponInProduct() {
        return response;
    }

    @GetMapping("/getAllCoupon")
    public List<CouponModel> getAllCoupon() {
        return repository.findAll();
    }

    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<CouponModel> model=repository.findById(id);
        if(model.isPresent()){
            response.setMessage("Exist");

            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(model);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }

    @PostMapping("/createCoupon")
    public ResponseModel createBox(@RequestBody CreationRequest request )  {

       List<CouponModel> couponModels=repository.findBycouponName(request.couponName());
        if(couponModels.isEmpty()){
          CouponModel coupon = new CouponModel();
        coupon.setCouponOnlyForOwner(request.couponOnlyForOwner);
        coupon.setModifiedAt(request.modifiedAt());
        coupon.setCreatedAt(request.createdAt());
        coupon.setCouponReductionPercent(request.couponReductionPercent());
        coupon.setCouponAvailableDurationInSeconds(request.couponAvailableDurationInSeconds());
        coupon.setCouponForBox(request.couponForBox());
        coupon.setCouponOwner(request.couponOwner());
        coupon.setCouponLeftQuantity(request.couponLeftQuantity());
        coupon.setCouponOnlyForOwner(request.couponOnlyForOwner());
        coupon.setCouponName(request.couponName());
        coupon.setCouponQuantity(request.couponQuantity());

            repository.save(coupon);
            response.setMessage("coupon Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(coupon);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("coupon already exist");
            response.setErrorType(ErrorResponseType.DataAlreadyExist);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }


    @PutMapping("/updateCoupon")
    public ResponseModel updateCoupon(@RequestBody UpdateRequest request) {

        Optional<CouponModel> couponModel = repository.findById(request.id());
        if (couponModel.isPresent()){
            CouponModel coupon = couponModel.get();
            coupon.setCouponOnlyForOwner(request.couponOnlyForOwner);
            coupon.setModifiedAt(request.modifiedAt());
            coupon.setCreatedAt(request.createdAt());
            coupon.setCouponReductionPercent(request.couponReductionPercent());
            coupon.setCouponAvailableDurationInSeconds(request.couponAvailableDurationInSeconds());
            coupon.setCouponForBox(request.couponForBox());
            coupon.setCouponOwner(request.couponOwner());
            coupon.setCouponLeftQuantity(request.couponLeftQuantity());
            coupon.setCouponOnlyForOwner(request.couponOnlyForOwner());
            coupon.setCouponName(request.couponName());
            coupon.setCouponQuantity(request.couponQuantity());
            repository.save(coupon);
            response.setMessage("coupon information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(coupon);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("coupon unfounded");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }
    @DeleteMapping("/deleteCoupon{couponId}")
    public void deleteCoupon(@PathVariable("couponId") int id) {
        repository.deleteById(id);
    }
}

