
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.BadgeRepository;
import com.walkini.repositories.NormalUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/badge")
@CrossOrigin
public class BadgeController {
    private final BadgeRepository repository;
    private final NormalUserRepository normalUserRepository;

    public BadgeController(BadgeRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.normalUserRepository = normalUserRepository;
    }


    record CreationRequest(String badgeName, String badgeDescription, String badgeImage, String createdAt, String modifiedAt

    )  {
    }
    record UpdateRequest(Integer id, String badgeName, String badgeDescription, String badgeImage, String createdAt, String modifiedAt

    )  {
    }
    record SetBadgeToUserRequest(
            Integer userId,Integer badgeId

    )  {
    }


    ResponseModel response = new ResponseModel();



    @GetMapping("/getAllBadges")
    public List<BadgeModel> getAllBadges() {
        return repository.findAll();
    }
    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<BadgeModel> model=repository.findById(id);
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

    @PostMapping("/createBadges")
    public ResponseModel createBadges(@RequestBody CreationRequest request )  {
       List<BadgeModel> badgeModels=repository.findBybadgeName(request.badgeName());
        boolean exists =badgeModels.isEmpty();
        if(exists){
            BadgeModel badge  = new BadgeModel();
            badge.setBadgeName(request.badgeName());
            badge.setBadgeImage(request.badgeImage());
            badge.setBadgeDescription(request.badgeDescription());
            badge.setCreatedAt(request.createdAt());
            badge.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(badge);
            response.setMessage("badge Added Successfully");

            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(badge);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("badge already exist");
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


    @PutMapping("/updateBadge")
    public ResponseModel updateBadge(@RequestBody UpdateRequest request) {

        Optional<BadgeModel> badgeModel = repository.findById(request.id());
        if (badgeModel.isPresent()){
        BadgeModel badge=badgeModel.get();

            badge.setBadgeName(request.badgeName());
            badge.setBadgeImage(request.badgeImage());
            badge.setBadgeDescription(request.badgeDescription());
            badge.setCreatedAt(request.createdAt());
            badge.setModifiedAt(request.modifiedAt());

            repository.save(badge);
            response.setMessage("badge information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(false);
            response.setObject(badge);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("badge unfounded");
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
    @DeleteMapping("/deleteBadge{badgeId}")
    public void deleteBadge(@PathVariable("badgeId") int id) {
        repository.deleteById(id);
    }









    @PostMapping("/setBadgeToUser")
    public ResponseModel setBadgeToUserAPI(@RequestParam Integer id,@RequestParam Integer userId) {
        return setBadgeToUser(id,userId);
    }
    public ResponseModel setBadgeToUser(Integer id,Integer userId) {

        Optional<BadgeModel> badgeModel=repository.findById(id);
        if (badgeModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getBadges();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (!myList.contains(id.toString())){
                    myList.add(id.toString());
                    profile.get().setBadges(String.join("---",myList));
                    response.setMessage("the " + badgeModel.get().getBadgeName() + " badge added to user with mail " + profile.get().getEmail() + " Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getBadges());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user already had this badge");
                    response.setErrorType(ErrorResponseType.DataAlreadyExist);
                    response.setReturnedBoolean(false);
                    response.setObject(myList);
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                }

            }else{
                response.setMessage("No user found with this info");
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
        }else {
            response.setMessage("No badge found with this info");
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
    @PostMapping("/removeBadgeToUser")
    public ResponseModel removeBadgeToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
        removeBadgeToUser(id, userId);
        return response;
    }
    public ResponseModel removeBadgeToUser(Integer id,Integer userId){


        Optional<BadgeModel> badgeModel=repository.findById(id);
        if (badgeModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getBadges();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setBadges(String.join("---",myList));
                    response.setMessage("the "+badgeModel.get().getBadgeName()+" badge removed from the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getBoosts());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this badge");
                    response.setErrorType(ErrorResponseType.DataAlreadyExist);
                    response.setReturnedBoolean(false);
                    response.setObject(myList);
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                }

            }else{
                response.setMessage("No user found with this info");
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
        }else {
            response.setMessage("No badge found with this info");
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

}

