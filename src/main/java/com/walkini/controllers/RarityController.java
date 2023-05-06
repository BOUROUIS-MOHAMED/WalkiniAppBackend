
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.RarityRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/rarity")
@CrossOrigin
public class RarityController {
    private final RarityRepository repository;
    private final ProfileController profileController;

    public RarityController(RarityRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( String name, String rarityColor, String rarityPercent, String rarityLevel, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, String rarityColor, String rarityPercent, String rarityLevel, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/getAllRarity")
    public List<RarityModel> getAllCoupon() {
        return repository.findAll();
    }

    @PostMapping("/createRarity")
    public Response createRarity(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("Name", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<RarityModel> example = Example.<RarityModel>of(new RarityModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            RarityModel rarity = new RarityModel();
           rarity.setRarityColor(request.rarityColor());
           rarity.setRarityLevel(request.rarityLevel());
           rarity.setRarityPercent(request.rarityPercent());
           rarity.setCreatedAt(request.createdAt());
           rarity.setName(request.name());
           rarity.setModifiedAt(request.modifiedAt());


            //ban
            //message
            repository.save(rarity);
            response.setMessage("rarity Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("rarity already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateRarity")
    public Response updateRariry(@RequestBody UpdateRequest request) {
        RarityModel rarity = new RarityModel();
        Optional<RarityModel> rarityModel = repository.findById(request.id());
        if (rarityModel.isPresent()){
            rarity.setRarityColor(request.rarityColor());
            rarity.setRarityLevel(request.rarityLevel());
            rarity.setRarityPercent(request.rarityPercent());
            rarity.setCreatedAt(request.createdAt());
            rarity.setName(request.name());
            rarity.setModifiedAt(request.modifiedAt());

            //ban
            //message
            repository.save(rarity);
            response.setMessage("rarity information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(rarity);
        }else {
            response.setMessage("rarity unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteRarity{rarityId}")
    public void deleteRarity(@PathVariable("rarityId") int id) {
        repository.deleteById(id);
    }
}

