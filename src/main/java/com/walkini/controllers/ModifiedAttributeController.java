
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.ModifiedAttributeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/modifiedAttribute")
@CrossOrigin
public class ModifiedAttributeController {
    private final ModifiedAttributeRepository repository;
    private final ProfileController profileController;

    public ModifiedAttributeController(ModifiedAttributeRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, String maxVisitPerDay, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, String maxVisitPerDay, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/getAllModifiedAttribute")
    public List<ModifiedAttributeModel> getAllModifiedAttribute() {
        return repository.findAll();
    }
    @GetMapping("/getModifiedAttribute{modifiedAttributeId}")
    public Response getModifiedAttribute(@RequestParam String modifiedId) {
        int id = Integer.parseInt(modifiedId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("modifiedAttribute founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("modifiedAttribute unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }


    @PostMapping("/createModifiedAttribute")
    public Response createModifiedAttribute(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ModifiedAttributeModel> example = Example.<ModifiedAttributeModel>of(new ModifiedAttributeModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            ModifiedAttributeModel modifiedAttribute = new ModifiedAttributeModel();
        modifiedAttribute.setCreatedAt(request.createdAt());
        modifiedAttribute.setMaxBoxPerDay(request.maxBoxPerDay());
        modifiedAttribute.setName(request.name());
        modifiedAttribute.setMaxStepsLimit(request.maxStepsLimit());
        modifiedAttribute.setMaxVisitPerDay(request.maxVisitPerDay());
        modifiedAttribute.setStepsMultiplayer(request.stepsMultiplayer());
        modifiedAttribute.setModifiedAt(request.createdAt());

            //ban
            //message
            repository.save(modifiedAttribute);
            response.setMessage("modified attribute Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("modified attribute already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateModifiedAttribute")
    public Response updateModifiedAttribute(@RequestBody UpdateRequest request) {
        ModifiedAttributeModel modifiedAttribute = new ModifiedAttributeModel();
        Optional<ModifiedAttributeModel> modifiedAttributeModel = repository.findById(request.id());
        if (modifiedAttributeModel.isPresent()){
            modifiedAttribute.setCreatedAt(request.createdAt());
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
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(modifiedAttribute);
        }else {
            response.setMessage("modifiedAttribute unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteModifiedAttribute{modifiedAttributeId}")
    public void deleteModifiedAttribute(@PathVariable("modifiedAttributeId") int id) {
        repository.deleteById(id);
    }
}

