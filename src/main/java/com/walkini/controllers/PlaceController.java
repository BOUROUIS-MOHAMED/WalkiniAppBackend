
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.NormalUserRepository;
import com.walkini.repositories.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/place")
@CrossOrigin
public class PlaceController {
    private final PlaceRepository repository;

    private final NormalUserRepository normalUserRepository;

    public PlaceController(PlaceRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;

        this.normalUserRepository = normalUserRepository;
    }


    record CreationRequest(Integer id, String name, Double latitude, Double longitude, String description, Integer rarity, String image, String productPrize, String coinPrize, String couponPrize, String boostPrize, Integer owner, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, Double latitude, Double longitude, String description, Integer rarity, String image, String productPrize, String coinPrize, String couponPrize, String boostPrize, Integer owner, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();
    @PostMapping("/scanQrCodeByPlaceOwner")
    public ResponseModel checkIfUserReachThePosition() {
        return response;
    }

    @PostMapping("/userTakeThePosition")
    public ResponseModel userTakeThePosition() {
        return response;
    }

    @PostMapping("/startThePositionCounterForThisUser")
    public ResponseModel startThePositionCounterForThisUser() {
        return response;
    }


    @PostMapping("/setPlaceToUser")
    public ResponseModel setPlaceToUserAPI(@RequestParam Integer id,@RequestParam Integer userId) {
        return setPlaceToUser(id,userId);
    }
    public ResponseModel setPlaceToUser(Integer id,Integer userId) {

        Optional<PlaceModel> placeModel=repository.findById(id);
        if (placeModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getPlaces();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (!myList.contains(id.toString())){
                    myList.add(id.toString());
                    profile.get().setPlaces(String.join("---",myList));
                    response.setMessage("the "+placeModel.get().getName()+ " place added to user with mail "+profile.get().getEmail() + " Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getPlaces());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user already had this place");
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
            response.setMessage("No place found with this info");
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
    @PostMapping("/removePlaceToUser")
    public ResponseModel removePlaceToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
        removePlaceToUser(id, userId);
        return response;
    }
    public ResponseModel removePlaceToUser(Integer id,Integer userId){


        Optional<PlaceModel> placeModel=repository.findById(id);
        if (placeModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getPlaces();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setPlaces(String.join("---",myList));
                    response.setMessage("the "+placeModel.get().getName()+" place removed from the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getPlaces());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this place");
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
            response.setMessage("No place found with this info");
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

    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<PlaceModel> model=repository.findById(id);
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
    @GetMapping("/getAllPlaces")
    public List<PlaceModel> getAllPlaces() {
        return repository.findAll();
    }
    @PostMapping("/createPlace")
    public ResponseModel createPlace(@RequestBody CreationRequest request )  {

        List<PlaceModel> placeModelList=repository.findByName(request.name());
        if(placeModelList.isEmpty()){
            PlaceModel place = new PlaceModel();

          place.setOwner(request.owner());
          place.setModifiedAt(request.modifiedAt());
          place.setLongitude(request.longitude());
          place.setLatitude(request.latitude());

          place.setCoinPrize(request.coinPrize());
          place.setDescription(request.description());
          place.setImage(request.image());
          place.setName(request.name());
          place.setRarity(request.rarity());

          place.setCreatedAt(request.createdAt());

            repository.save(place);
            response.setMessage("place Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(place);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("place already exist");
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


    @PutMapping("/updatePlace")
    public ResponseModel updatePlace(@RequestBody UpdateRequest request) {
        PlaceModel place = new PlaceModel();
        Optional<PlaceModel> placeModel = repository.findById(request.id());
        if (placeModel.isPresent()){
            place.setCreatedAt(request.createdAt());
            place.setDescription(request.description());
            place.setImage(request.image());
            place.setLatitude(request.latitude());
            place.setLongitude(request.longitude());
            place.setName(request.name());
            place.setRarity(request.rarity());
            place.setModifiedAt(request.createdAt());

            //ban
            //message
            repository.save(place);
            response.setMessage("place information updated Successfully");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(true);
            response.setObject(place);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("place unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }
    @DeleteMapping("/deletePlace{placeId}")
    public void deletePlace(@PathVariable("placeId") int id) {
        repository.deleteById(id);
    }
}

