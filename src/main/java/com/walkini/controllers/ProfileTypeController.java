
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.ProfileTypeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/profileType")
@CrossOrigin
public class ProfileTypeController {
    private final ProfileTypeRepository repository;
    private final ProfileController profileController;

    public ProfileTypeController(ProfileTypeRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( String profileTypeName, Timestamp createdAt, Timestamp modifiedAt) {}
    record UpdateRequest(Integer id, String profileTypeName, Timestamp createdAt, Timestamp modifiedAt){}
    Response response = new Response();

    @GetMapping("/getAllProfileType")
    public List<ProfileTypeModel> getAllProfileType() {
        return repository.findAll();
    }
    @GetMapping("/getProfileType{Id}")
    public Response getProfileType(@RequestParam String Id) {
        int id = Integer.parseInt(Id);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("profile type founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("profile type unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }


    @PostMapping("/createProfileType")
    public Response createBox(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("profileTypeName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileTypeModel> example = Example.<ProfileTypeModel>of(new ProfileTypeModel(request.profileTypeName()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            ProfileTypeModel profileType = new ProfileTypeModel();
            profileType.setProfileTypeName(request.profileTypeName());
            profileType.setCreatedAt(request.createdAt());
            profileType.setModifiedAt(request.createdAt());



            //ban
            //message
            repository.save(profileType);
            response.setMessage("profile type Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("profile already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateProfileType")
    public Response updateCoupon(@RequestBody UpdateRequest request) {
        ProfileTypeModel profileType = new ProfileTypeModel();
        Optional<ProfileTypeModel> profileTypeModel = repository.findById(request.id());
        if (profileTypeModel.isPresent()){
            profileType.setProfileTypeName(request.profileTypeName());
            profileType.setCreatedAt(request.createdAt());
            profileType.setModifiedAt(request.createdAt());

            repository.save(profileType);
            response.setMessage("profile type information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(profileType);
        }else {
            response.setMessage("profile type unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteProfileType{profileTypeId}")
    public void deleteProfileType(@PathVariable("profileTypeId") int id) {
        repository.deleteById(id);
    }
}

