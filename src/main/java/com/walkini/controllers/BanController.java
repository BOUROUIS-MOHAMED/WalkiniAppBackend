package com.walkini.controllers;


import com.walkini.models.*;
import com.walkini.repositories.BanRepository;
import com.walkini.repositories.ProfileRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

import com.walkini.AppConstants;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/ban")
@CrossOrigin
public class BanController {
    private final BanRepository repository;
    private final ProfileRepository profileRepository;

    public BanController(BanRepository repository, ProfileRepository profileRepository) {
        this.repository = repository;
        this.profileRepository = profileRepository;
    }



    record NewBanRequest(String name, String description, String image, String reason, Long banDuration, String message, Timestamp createdAt)  {
    }
    record UpdateBanRequest(Integer id,String name, String description, String image, String reason, Long banDuration, String message, Timestamp modifiedAt)  {
    }

    @GetMapping("/getAllBans")
    public List<BanModel> getAllBans() {
        return repository.findAll();
    }

    @PostMapping("/createABan")
    public Response createABan(@RequestBody NewBanRequest request )  {

        ExampleMatcher banNameMatching = ExampleMatcher.matching()
                .withMatcher("banName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<BanModel> example = Example.<BanModel>of(new BanModel(request.name()), banNameMatching);
        boolean banExists = repository.exists(example);
        if(banExists){
            BanModel ban = new BanModel();
            ban.setCreatedAt(request.createdAt());
            ban.setDescription(request.description());
            ban.setReason(request.reason());
            ban.setImage(request.image());
            ban.setName(request.name());
            ban.setMessage(request.message());
            ban.setBanDurationInSeconds(request.banDuration());

            //ban
            //message
            repository.save(ban);
            response.setMessage("ban Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("ban already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateBan")
    public Response updateBan(@RequestBody UpdateBanRequest request) {
        BanModel ban = new BanModel();
        Optional<BanModel> banModel = repository.findById(request.id());
        if (banModel.isPresent()){
            ban.setDescription(request.description());
            ban.setReason(request.reason());
            ban.setImage(request.image());
            ban.setName(request.name());
            ban.setMessage(request.message());
            ban.setBanDurationInSeconds(request.banDuration());
            ban.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(ban);
            response.setMessage("ban information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("ban unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteBan{banId}")
    public void deleteBan(@PathVariable("banId") int id) {
        repository.deleteById(id);
    }


    @GetMapping("/giveUserABan")
    public Response giveUserABan(@RequestParam String userId,@RequestParam Integer banDetails,@RequestParam Long banDuration)  {
            int id = Integer.parseInt(userId);
        ProfileModel profile = new ProfileModel();
        Optional<ProfileModel> profileModel = profileRepository.findById(id);
        if (profileModel.isPresent()){
            profile.setBanned(true);
            profile.setBanDetails(banDetails);
            profile.setBanDurationInSeconds(banDuration);
            //ban
            //message
            profileRepository.save(profile);
            response.setMessage("user Banned Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("error in banned this user");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;


    }
    @GetMapping("/removeUserBan")
    public Response removeUserBan(@RequestParam String userId)  {
        int id = Integer.parseInt(userId);
        ProfileModel profile = new ProfileModel();
        Optional<ProfileModel> profileModel = profileRepository.findById(id);
        if (profileModel.isPresent()){
            profile.setBanned(false);
            profile.setBanDetails(null);
            profile.setBanDurationInSeconds(null);
            //ban
            //message
            profileRepository.save(profile);
            response.setMessage("user Banned Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("error in banned this user");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;


    }



    public Boolean checkBanFunction(@RequestParam String userId) {
        int id = Integer.parseInt(userId);
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
        ProfileModel profile = new ProfileModel();
        Optional<ProfileModel> profileModel = profileRepository.findById(id);
        if (profileModel.isPresent()){
            return profileModel.get().getBanned();
    }else {


    return  profileModel.get().getBanned();
    }}

    @GetMapping("/checkBan{x}")
    public Response checkBan(@RequestParam String userId) {



        int id = Integer.parseInt(userId);



        if (checkBanFunction(userId)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("user is banned");
            response.setErrorCode(40000);
            response.setThereIsAnError(false);


        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("user is not banned");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
        }
        return response;
    }
    Response response = new Response();



}
