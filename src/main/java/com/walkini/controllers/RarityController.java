
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.RarityRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/rarity")
@CrossOrigin
public class RarityController {
    private final RarityRepository repository;

    public RarityController(RarityRepository repository) {
        this.repository = repository;

    }


    record CreationRequest(Integer id, String name, String rarityColor, Double rarityPercent, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, String rarityColor, Double rarityPercent, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();



    public Double returnRarity(Integer id) {
        Optional<RarityModel> rarityModel=repository.findById(id);
        if (rarityModel.isPresent()){
            return rarityModel.get().getRarityPercent();
        }else {
            return 0.0;
        }
    }


    @GetMapping("/getAllRarity")
    public List<RarityModel> getAllRarity() {
        return repository.findAll();
    }

    @PostMapping("/createRarity")
    public ResponseModel createRarity(@RequestBody CreationRequest request )  {

      List<RarityModel>rarityModelList=repository.findByname(request.name());
        if(rarityModelList.isEmpty()){
            RarityModel rarity = new RarityModel();
           rarity.setRarityColor(request.rarityColor());

           rarity.setRarityPercent(request.rarityPercent());
           rarity.setCreatedAt(request.createdAt());
           rarity.setName(request.name());
           rarity.setModifiedAt(request.modifiedAt());


            //ban
            //message
            repository.save(rarity);
            response.setMessage("rarity Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(rarity);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("rarity already exist");
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


    @PutMapping("/updateRarity")
    public ResponseModel updateRariry(@RequestBody UpdateRequest request) {

        Optional<RarityModel> rarityModel = repository.findById(request.id());
        if (rarityModel.isPresent()){
            RarityModel rarity = rarityModel.get();
            rarity.setRarityColor(request.rarityColor());
            rarity.setRarityPercent(request.rarityPercent());
            rarity.setCreatedAt(request.createdAt());
            rarity.setName(request.name());
            rarity.setModifiedAt(request.modifiedAt());

            //ban
            //message
            repository.save(rarity);
            response.setMessage("rarity information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(rarity);

            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("rarity unfounded");
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
    @DeleteMapping("/deleteRarity{rarityId}")
    public void deleteRarity(@PathVariable("rarityId") int id) {
        repository.deleteById(id);
    }
    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<RarityModel> model=repository.findById(id);
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

}

