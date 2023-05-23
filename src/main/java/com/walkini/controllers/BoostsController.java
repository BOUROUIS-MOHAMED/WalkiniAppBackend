
        package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.BoostRepository;
import com.walkini.repositories.NormalUserRepository;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/boost")
@CrossOrigin
public class BoostsController {
    private final BoostRepository repository;
    private final NormalUserRepository normalUserRepository;

    public BoostsController(BoostRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.normalUserRepository = normalUserRepository;
    }


    record CreationRequest(
             String name, String description, String image, Long boostDurationInSeconds, Double price, String modifiedAttributes, Boolean boostInBoxOrNot, Integer boostRarity, String createdAt, String modifiedAt
    )  {
    }
    record UpdateRequest(Integer id, String name, String description, String image, Long boostDurationInSeconds, Double price, String modifiedAttributes, Boolean boostInBoxOrNot, Integer boostRarity, String createdAt, String modifiedAt

    )  {
    }
    record SetBoostToUserRequest(
            Integer userId,Integer boostId

    )  {
    }
    ResponseModel response = new ResponseModel();



    @PostMapping("/setBoostToUser")
    public ResponseModel setBoostToUserAPI(@RequestParam Integer id,@RequestParam Integer userId) {
        return setBoostToUser(id,userId);
    }
    public ResponseModel setBoostToUser(Integer id,Integer userId) {

        Optional<BoostsModel> boostsModel=repository.findById(id);
     if (boostsModel.isPresent()){
         Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
         if (profile.isPresent()){
             String str= profile.get().getBoosts();
             List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
             if (!myList.contains(id.toString())){
                 myList.add(id.toString());
                 profile.get().setBoosts(String.join("---",myList));
                 response.setMessage("the\"+boostsModel.get().getName()+\" boost added to user with mail\"+profile.get().getEmail() +\" Successfully");
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
                 response.setMessage("this user already had this boost");
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
         response.setMessage("No boost found with this info");
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
    @PostMapping("/removeBoostToUser")
    public ResponseModel removeBoostToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
removeBoostToUser(id, userId);
        return response;
    }
    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<BoostsModel> model=repository.findById(id);
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
    public ResponseModel removeBoostToUser(Integer id,Integer userId){


        Optional<BoostsModel> boostsModel=repository.findById(id);
        if (boostsModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getBoosts();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setBoosts(String.join("---",myList));
                    response.setMessage("the "+boostsModel.get().getName()+" boost removed from the user with mail "+profile.get().getEmail() +" Successfully");
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
                    response.setMessage("this user dont have this boost");
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
            response.setMessage("No boost found with this info");
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





    @GetMapping("/getAllBoosts")
    public List<BoostsModel> getAllBoosts() {
        return repository.findAll();
    }

    @PostMapping("/createBoost")
    public ResponseModel createBoost(@RequestBody CreationRequest request )  {
        List<BoostsModel> boostModels=repository.findByName(request.name());
        if(boostModels.isEmpty()){
            BoostsModel boost = new BoostsModel();
            boost.setCreatedAt(request.createdAt());
            boost.setModifiedAt(request.modifiedAt());
            boost.setName(request.name());
            boost.setBoostRarity(request.boostRarity());
            boost.setDescription(request.description());
            boost.setBoostInBoxOrNot(request.boostInBoxOrNot());
            boost.setImage(request.image());
            boost.setModifiedAttributes(request.modifiedAttributes());
            boost.setPrice(request.price());
            boost.setBoostDurationInSeconds(request.boostDurationInSeconds());
            //ban
            //message
            repository.save(boost);
            response.setMessage("boost created Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(boost);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("boost already exist");
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


    @PutMapping("/updateBoost")
    public ResponseModel updateBoost(@RequestBody UpdateRequest request) {

        Optional<BoostsModel> boostsModel = repository.findById(request.id());
        if (boostsModel.isPresent()){
            BoostsModel boost =boostsModel.get();
            boost.setCreatedAt(request.createdAt());
            boost.setModifiedAt(request.modifiedAt());
            boost.setName(request.name());
            boost.setBoostRarity(request.boostRarity());
            boost.setDescription(request.description());
            boost.setBoostInBoxOrNot(request.boostInBoxOrNot());
            boost.setImage(request.image());
            boost.setModifiedAttributes(request.modifiedAttributes());
            boost.setPrice(request.price());
            boost.setBoostDurationInSeconds(request.boostDurationInSeconds());
            //ban
            //message
            repository.save(boost);
            response.setMessage("boost information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(boost);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("boost unfounded");
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
    @DeleteMapping("/deleteBoost{boostId}")
    public void deleteBoost(@PathVariable("boostId") int id) {
        repository.deleteById(id);
    }
}

