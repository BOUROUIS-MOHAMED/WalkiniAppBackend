
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.ModifiedAttributeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/modifiedAttribute")
@CrossOrigin
public class ModifiedAttributeController {
    private final ModifiedAttributeRepository repository;

    public ModifiedAttributeController(ModifiedAttributeRepository repository) {
        this.repository = repository;
    }


    record CreationRequest( Integer id, String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, Integer maxVisitPerDay, Integer maxAskForConvertPerDay, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, Integer maxVisitPerDay, Integer maxAskForConvertPerDay, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();

    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<ModifiedAttributeModel> model=repository.findById(id);
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


    public Integer  initialModifiedAttribute(ModifiedAttributeModel modifiedAttributeModel){
        repository.save(modifiedAttributeModel);
        return modifiedAttributeModel.getId();
    }

    @GetMapping("/getAllModifiedAttribute")
    public List<ModifiedAttributeModel> getAllModifiedAttribute() {
        return repository.findAll();
    }
    @PostMapping("/createModifiedAttribute")
    public ResponseModel createModifiedAttribute(@RequestBody CreationRequest request )  {

List<ModifiedAttributeModel> modifiedAttributeModelList=repository.findByname(request.name());

        if(modifiedAttributeModelList.isEmpty()){
        ModifiedAttributeModel modifiedAttribute = new ModifiedAttributeModel();
        modifiedAttribute.setCreatedAt(request.createdAt());
        modifiedAttribute.setMaxAskForConvertPerDay(request.maxAskForConvertPerDay());
        modifiedAttribute.setMaxBoxPerDay(request.maxBoxPerDay());
        modifiedAttribute.setName(request.name());
        modifiedAttribute.setMaxStepsLimit(request.maxStepsLimit());
        modifiedAttribute.setMaxVisitPerDay(request.maxVisitPerDay());
        modifiedAttribute.setStepsMultiplayer(request.stepsMultiplayer());
        modifiedAttribute.setModifiedAt(request.createdAt());

            repository.save(modifiedAttribute);
            response.setMessage("modified attribute Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(modifiedAttribute);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("modified attribute already exist");
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


    @PutMapping("/updateModifiedAttribute")
    public ResponseModel updateModifiedAttribute(@RequestBody UpdateRequest request) {
        ModifiedAttributeModel modifiedAttribute = new ModifiedAttributeModel();
        Optional<ModifiedAttributeModel> modifiedAttributeModel = repository.findById(request.id());
        if (modifiedAttributeModel.isPresent()){
            modifiedAttribute.setCreatedAt(request.createdAt());
            modifiedAttribute.setMaxAskForConvertPerDay(request.maxAskForConvertPerDay());
            modifiedAttribute.setMaxBoxPerDay(request.maxBoxPerDay());
            modifiedAttribute.setName(request.name());
            modifiedAttribute.setMaxStepsLimit(request.maxStepsLimit());
            modifiedAttribute.setMaxVisitPerDay(request.maxVisitPerDay());
            modifiedAttribute.setStepsMultiplayer(request.stepsMultiplayer());
            modifiedAttribute.setModifiedAt(request.createdAt());

            //ban
            //message
            repository.save(modifiedAttribute);
            response.setMessage("modified attribute information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(modifiedAttribute);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("modifiedAttribute unfounded");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(modifiedAttribute);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }
    @DeleteMapping("/deleteModifiedAttribute{modifiedAttributeId}")
    public void deleteModifiedAttribute(@PathVariable("modifiedAttributeId") int id) {
        repository.deleteById(id);
    }
}

