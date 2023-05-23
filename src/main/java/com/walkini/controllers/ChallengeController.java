
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.BadgeModel;
import com.walkini.models.ChallengeModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.ResponseModel;
import com.walkini.repositories.ChallengeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/challenge")
@CrossOrigin
public class ChallengeController {
    private final ChallengeRepository repository;

    public ChallengeController(ChallengeRepository repository) {
        this.repository = repository;
    }


    record CreationRequest(String name, String description, String image, String target, String coinPrize, String couponPrize, String boostPrize, String createdAt, String modifiedAt

    )  {
    }
    record UpdateRequest(Integer id, String name, String description, String image, String target, String coinPrize, String couponPrize, String boostPrize, String createdAt, String modifiedAt

    )  {
    }
    ResponseModel response = new ResponseModel();


    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<ChallengeModel> model=repository.findById(id);
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

    @GetMapping("/getAllChallenges")
    public List<ChallengeModel> getAllChallenges() {
        return repository.findAll();
    }

    @PostMapping("/createChallenge")
    public ResponseModel createChallenge(@RequestBody CreationRequest request )  {
        List<ChallengeModel> challengeModels=repository.findByname(request.name());

        if(challengeModels.isEmpty()){
            ChallengeModel challenge  = new ChallengeModel();

            challenge.setTarget(request.target());
            challenge.setName(request.name());
            challenge.setImage(request.image());

            challenge.setCoinPrize(request.coinPrize());
            challenge.setDescription(request.description());
            challenge.setCreatedAt(request.createdAt());
            challenge.setModifiedAt(request.modifiedAt());
            repository.save(challenge);
            response.setMessage("challenge created successfully ");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(challenge);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("challenge already exist");
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


    @PutMapping("/updateChallenge")
    public ResponseModel updateChallenge(@RequestBody UpdateRequest request) {

        Optional<ChallengeModel> challengeModel = repository.findById(request.id());
        if (challengeModel.isPresent()){
            ChallengeModel challenge=challengeModel.get();

            challenge.setTarget(request.target());
            challenge.setName(request.name());
            challenge.setImage(request.image());

            challenge.setCoinPrize(request.coinPrize());
            challenge.setDescription(request.description());
            challenge.setCreatedAt(request.createdAt());
            challenge.setModifiedAt(request.modifiedAt());

            repository.save(challenge);
            response.setMessage("challenge information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(false);
            response.setObject(challenge);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("challenge unfounded");
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
    @DeleteMapping("/deleteChallenge{challengeId}")
    public void deleteChallenge(@PathVariable("challengeId") int id) {
        repository.deleteById(id);
    }
}

