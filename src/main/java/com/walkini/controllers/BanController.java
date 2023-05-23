package com.walkini.controllers;


import com.walkini.models.*;
import com.walkini.repositories.BanRepository;
import com.walkini.repositories.NormalUserRepository;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

import com.walkini.AppConstants;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/ban")
@CrossOrigin
public class BanController {
    private final BanRepository repository;
    private final NormalUserRepository normalUserRepository;

    public BanController(BanRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.normalUserRepository = normalUserRepository;
    }


    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<BanModel> model=repository.findById(id);
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
    record NewBanRequest(String name, String description, String reason, Long banDurationInSeconds, String message, String createdAt, String modifiedAt)  {
    }
    record UpdateBanRequest(Integer id, String name, String description, String reason, Long banDurationInSeconds, String message, String createdAt, String modifiedAt)  {
    }

    @GetMapping("/getAllBans")
    public List<BanModel> getAllBans() {
        return repository.findAll();
    }

    @PostMapping("/createABan")
    public ResponseModel createABan(@RequestBody NewBanRequest request )  {
        List<BanModel> banModels=repository.findByName(request.name());



        if(banModels.isEmpty()){
            BanModel ban = new BanModel();
            ban.setCreatedAt(request.createdAt());
            ban.setDescription(request.description());
            ban.setReason(request.reason());
            ban.setModifiedAt(request.modifiedAt());
            ban.setName(request.name());
            ban.setMessage(request.message());
            ban.setBanDurationInSeconds(request.banDurationInSeconds());

            repository.save(ban);
            response.setMessage("ban Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(ban);
            response.setErrorCode("20000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("ban already exist");
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


    @PutMapping("/updateBan")
    public ResponseModel updateBan(@RequestBody UpdateBanRequest request) {

        Optional<BanModel> banModel = repository.findById(request.id());
        if (banModel.isPresent()){
            BanModel ban = banModel.get();
            ban.setCreatedAt(request.createdAt());
            ban.setDescription(request.description());
            ban.setReason(request.reason());
            ban.setModifiedAt(request.modifiedAt());
            ban.setName(request.name());
            ban.setMessage(request.message());
            ban.setBanDurationInSeconds(request.banDurationInSeconds());
            //ban
            //message
            repository.save(ban);
            response.setMessage("ban information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(ban);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("ban unfounded");
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
    @DeleteMapping("/deleteBan{banId}")
    public void deleteBan(@PathVariable("banId") int id) {
        repository.deleteById(id);
    }


    @GetMapping("/giveUserABan")
    public ResponseModel giveUserABan(@RequestParam Integer userId, @RequestParam Integer banDetails)  {
        Optional<NormalUserModel> profile = normalUserRepository.findById(userId);

        if (profile.isPresent()){
            boolean banStatus = profile.get().getBanned();
            Integer banDetailsStatus = profile.get().getBanInfo();
            if (banStatus){
              if(banDetailsStatus==banDetails){
                      response.setMessage("This user Already banned with this details");
                      response.setErrorType(ErrorResponseType.DataAlreadyExist);
                      response.setReturnedBoolean(false);
                      response.setObject(null);
                      response.setErrorCode("40000");
                      response.setThereIsAnError(true);
                      response.setReturnedInteger(null);
                      response.setReturnedList(null);
                      response.setReturnedString(null);
                      response.setReturnedMultipartFile(null);


              }else {
                  profile.get().setBanned(true);
                  profile.get().setBanInfo(banDetails);
                  response.setMessage("This user ban details is changed");
                  response.setErrorType(ErrorResponseType.Nothing);
                  response.setReturnedBoolean(true);
                  response.setObject(profile);
                  response.setErrorCode("20000");
                  response.setThereIsAnError(false);
                  response.setReturnedInteger(null);
                  response.setReturnedList(null);
                  response.setReturnedString(null);
                  response.setReturnedMultipartFile(null);
              }
            }else{
                profile.get().setBanned(true);
                profile.get().setBanInfo(banDetails);
                response.setMessage("This user banned successfully");
                response.setErrorType(ErrorResponseType.Nothing);
                response.setReturnedBoolean(true);
                response.setObject(profile);
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }
            normalUserRepository.save(profile.get());
        }else {
            response.setMessage("no user found with this information");
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
    @GetMapping("/removeUserBan")
    public ResponseModel removeUserBan(@RequestParam Integer userId)  {


        Optional<NormalUserModel> profileModel = normalUserRepository.findById(userId);
        if (profileModel.isPresent()){

            NormalUserModel profile =profileModel.get();
            if (profile.getBanned()){
                profile.setBanned(false);
                profile.setBanInfo(null);

                //ban
                //message
                normalUserRepository.save(profile);
                response.setMessage("user Ban removed Successfully");
                response.setErrorType(ErrorResponseType.Nothing);
                response.setReturnedBoolean(true);
                response.setObject(profile);
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }else {
                response.setMessage("This user already unbanned");
                response.setErrorType(ErrorResponseType.StatusError);
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
            response.setMessage("no user found ");
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



    public Boolean checkBanFunction(@RequestParam Integer userId) {

      /*  List<BanModel> banHistory= repository.findByUserBannedIdEquals(id);
        for (BanModel banModel:banHistory
             ) {
           Duration delay= banModel.getBanDuration();
           LocalDateTime firstBanDay=banModel.getCreatedAt().toLocalDateTime();
           Timestamp lastBanDay=Timestamp.valueOf( firstBanDay.plus(delay));
           if (lastBanDay.after(Timestamp.valueOf(LocalDateTime.now()))){
               ProfileModel car = new ProfileModel();
               Optional<ProfileModel> profileModel = profileRepository.findById(id);
               car.setBanned(true);
               return true;
           }*/
        NormalUserModel profile = new NormalUserModel();
        Optional<NormalUserModel> profileModel = normalUserRepository.findById(userId);
        if (profileModel.isPresent()){
            return profileModel.get().getBanned();
    }else {
    return null;
    }}

    ResponseModel response = new ResponseModel();



}
