
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.MembershipTypeRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/membershipType")
@CrossOrigin
public class MembershipTypeController {
    private final MembershipTypeRepository repository;
    private final ProfileController profileController;

    public MembershipTypeController(MembershipTypeRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest( String name, String description, String color, String price, String badge, Long duration, Integer modifiedAttribute, Timestamp createdAt, Timestamp modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, String description, String color, String price, String badge, Long duration, Integer modifiedAttribute, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();



    @GetMapping("/getAllMembershipTypes")
    public List<MembershipTypeModel> getAllMembershipTypes() {
        return repository.findAll();
    }
    @GetMapping("/getMembershipType{membershipId}")
    public Response getMembershipType(@RequestParam String membershipId) {
        int id = Integer.parseInt(membershipId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("membership type founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("membership type unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }

    @PostMapping("/createMembershipType")
    public Response createMembershipType(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("membershipName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<MembershipTypeModel> example = Example.<MembershipTypeModel>of(new MembershipTypeModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            MembershipTypeModel membership = new MembershipTypeModel();
           membership.setCreatedAt(request.createdAt());
           membership.setBadge(request.badge());
           membership.setColor(request.color());
           membership.setDescription(request.description());
           membership.setMembershipDurationInSeconds(request.duration());
           membership.setName(request.name());
           membership.setPrice(request.price());
           membership.setModifiedAttribute(request.modifiedAttribute());
            //ban
            //message
            repository.save(membership);
            response.setMessage("membership type Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("membership type already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateMembershipType")
    public Response updateMembershipType(@RequestBody UpdateRequest request) {
        MembershipTypeModel membership = new MembershipTypeModel();
        Optional<MembershipTypeModel> membershipTypeModel = repository.findById(request.id());
        if (membershipTypeModel.isPresent()){
            membership.setCreatedAt(request.createdAt());
            membership.setBadge(request.badge());
            membership.setColor(request.color());
            membership.setDescription(request.description());
            membership.setMembershipDurationInSeconds(request.duration());
            membership.setName(request.name());
            membership.setPrice(request.price());
            membership.setModifiedAttribute(request.modifiedAttribute());
            membership.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(membership);
            response.setMessage("membership type information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(membership);
        }else {
            response.setMessage("membership type unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteMembershipType{membershipTypeId}")
    public void deleteMembershipType(@PathVariable("membershipTypeId") int id) {
        repository.deleteById(id);
    }
}

