
        package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.ActionModel;
import com.walkini.models.BoostsModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.Response;
import com.walkini.repositories.BoostRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/boost")
@CrossOrigin
public class BoostsController {
    private final BoostRepository repository;

    public BoostsController(BoostRepository repository) {
        this.repository = repository;
    }


    record CreationRequest(Integer id, String name, String description, String image, Long duration, String price, String modifiedAttributes, Boolean boostInBoxOrNot, Integer boostRarity, Timestamp createdAt

    )  {
    }
    record UpdateRequest(Integer id, String name, String description, String image, Long duration, String price, String modifiedAttributes, Boolean boostInBoxOrNot, Integer boostRarity, Timestamp modifiedAt

    )  {
    }
    record SetBoostToUserRequest(
            Integer userId,Integer boostId

    )  {
    }
    Response response = new Response();

    @PostMapping("/setBoostToUser")
    public Response setBoostToUser() {

        return response;
    }
    @PostMapping("/removeBoostToUser")
    public Response removeBoostToUser() {

        return response;
    }


    @GetMapping("/getAllBoosts")
    public List<BoostsModel> getAllBoosts() {
        return repository.findAll();
    }

    @PostMapping("/createBoost")
    public Response createBoost(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("boostName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<BoostsModel> example = Example.<BoostsModel>of(new BoostsModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            BoostsModel boost = new BoostsModel();
           boost.setCreatedAt(request.createdAt());
            boost.setName(request.name());
            boost.setBoostRarity(request.boostRarity());
            boost.setDescription(request.description());
            boost.setBoostInBoxOrNot(request.boostInBoxOrNot());
            boost.setImage(request.image());
            boost.setBoostDurationInSeconds(request.duration());
            boost.setModifiedAttributes(request.modifiedAttributes());
            boost.setPrice(request.price());
            //ban
            //message
            repository.save(boost);
            response.setMessage("boost Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("boost already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateBoost")
    public Response updateBoost(@RequestBody UpdateRequest request) {
        BoostsModel boost = new BoostsModel();
        Optional<BoostsModel> boostsModel = repository.findById(request.id());
        if (boostsModel.isPresent()){

            boost.setModifiedAt(request.modifiedAt());
            boost.setName(request.name());
            boost.setBoostRarity(request.boostRarity());
            boost.setDescription(request.description());
            boost.setBoostInBoxOrNot(request.boostInBoxOrNot());
            boost.setImage(request.image());
            boost.setBoostDurationInSeconds(request.duration());
            boost.setModifiedAttributes(request.modifiedAttributes());
            boost.setPrice(request.price());
            //ban
            //message
            repository.save(boost);
            response.setMessage("boost information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(boost);
        }else {
            response.setMessage("action unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteBoost{boostId}")
    public void deleteBoost(@PathVariable("boostId") int id) {
        repository.deleteById(id);
    }
}

