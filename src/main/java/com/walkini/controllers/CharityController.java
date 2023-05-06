
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CharityRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/charity")
@CrossOrigin
public class CharityController {
    private final CharityRepository repository;
    private final ProfileController profileController;

    public CharityController(CharityRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( String title, String image, String amount, String description, String currentAmount, Timestamp limitTime, Integer owner, Timestamp createdAt)  {
    }
    record UpdateRequest(Integer id, String title, String image, String amount, String description, String currentAmount, Timestamp limitTime, Integer owner, Timestamp modifiedAt )  {
    }
    Response response = new Response();

    @GetMapping("/donateToCharity")
    public Response donateToCharity() {
        return response;
    }



    @GetMapping("/getAllCharity")
    public List<CharityModel> getAllCharity() {
        return repository.findAll();
    }
    @GetMapping("/getCharity{charityId}")
    public Response getCharity(@RequestParam String charityId) {
        int id = Integer.parseInt(charityId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("charity founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("charity unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }

    @GetMapping("/getCharityByUser{userId}")
    public Response getCharityByUser(@RequestParam String userId) {
        int id = Integer.parseInt(userId);
        if (profileController.checkUserExist(userId)){

            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("charity for user founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findByownerEquals(id));
        }else{
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("charity for user not founded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);







        }
        return response;


    }
    @PostMapping("/createCharity")
    public Response createCharity(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("charityTitle", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<CharityModel> example = Example.<CharityModel>of(new CharityModel(request.title()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            CharityModel charity = new CharityModel();
          charity.setCreatedAt(request.createdAt());
          charity.setAmount(request.amount());
          charity.setImage(request.image());
          charity.setDescription(request.description());
          charity.setCurrentAmount(request.currentAmount());
          charity.setLimitTime(request.limitTime());
          charity.setTitle(request.title());
          charity.setOwner(request.owner());

            //ban
            //message
            repository.save(charity);
            response.setMessage("charity Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("charity already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateCharity")
    public Response updateCharity(@RequestBody UpdateRequest request) {
        CharityModel charity = new CharityModel();
        Optional<CharityModel> charityModel = repository.findById(request.id());
        if (charityModel.isPresent()){
            charity.setModifiedAt(request.modifiedAt());
            charity.setAmount(request.amount());
            charity.setImage(request.image());
            charity.setDescription(request.description());
            charity.setCurrentAmount(request.currentAmount());
            charity.setLimitTime(request.limitTime());
            charity.setTitle(request.title());
            charity.setOwner(request.owner());

            //ban
            //message
            repository.save(charity);
            response.setMessage("charity information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(charity);
        }else {
            response.setMessage("charity unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteCharity{charityId}")
    public void deleteCharity(@PathVariable("charityId") int id) {
        repository.deleteById(id);
    }
}

