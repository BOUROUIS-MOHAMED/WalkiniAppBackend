
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.PlaceRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/place")
@CrossOrigin
public class PlaceController {
    private final PlaceRepository repository;
    private final ProfileController profileController;

    public PlaceController(PlaceRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(String name, double latitude, double longitude, String description, Integer rarity, String image, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, double latitude, double longitude, String description, Integer rarity, String image, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();
    @PostMapping("/checkIfUserReachThePosition")
    public Response checkIfUserReachThePosition() {
        return response;
    }

    @PostMapping("/userTakeThePosition")
    public Response userTakeThePosition() {
        return response;
    }

    @PostMapping("/startThePositionCounterForThisUser")
    public Response startThePositionCounterForThisUser() {
        return response;
    }



    @GetMapping("/getAllPlaces")
    public List<PlaceModel> getAllPlaces() {
        return repository.findAll();
    }
    @GetMapping("/getPlace{placeId}")
    public Response getPlace(@RequestParam String placeId) {
        int id = Integer.parseInt(placeId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("place founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("place unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }

    @PostMapping("/createPlace")
    public Response createPlace(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("latitude", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<PlaceModel> example = Example.<PlaceModel>of(new PlaceModel(request.latitude(),request.longitude()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            PlaceModel place = new PlaceModel();
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
            response.setMessage("place Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("place already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updatePlace")
    public Response updatePlace(@RequestBody UpdateRequest request) {
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
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(place);
        }else {
            response.setMessage("place unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deletePlace{placeId}")
    public void deletePlace(@PathVariable("placeId") int id) {
        repository.deleteById(id);
    }
}

