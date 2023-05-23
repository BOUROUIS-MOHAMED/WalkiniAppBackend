
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.MembershipTypeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/membershipType")
@CrossOrigin
public class MembershipTypeController {
    private final MembershipTypeRepository repository;


    public MembershipTypeController(MembershipTypeRepository repository) {
        this.repository = repository;

    }


    record CreationRequest(String name, String description, Double price, Integer badge, Integer membershipDurationInMonths, Integer modifiedAttribute, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String name, String description, Double price, Integer badge, Integer membershipDurationInMonths, Integer modifiedAttribute, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();



    @GetMapping("/getAllMembershipTypes")
    public List<MembershipTypeModel> getAllMembershipTypes() {
        return repository.findAll();
    }



    public Integer  initialMemberships(MembershipTypeModel membershipTypeModel){
      repository.save(membershipTypeModel);
        return membershipTypeModel.getId();
    }

    @PostMapping("/createMembershipType")
    public ResponseModel createMembershipType(@RequestBody CreationRequest request )  {

        List<MembershipTypeModel> membershipTypeModelList=repository.findByName(request.name());
        if(membershipTypeModelList.isEmpty()){
            MembershipTypeModel membership = new MembershipTypeModel();
            membership.setCreatedAt(request.createdAt());
            membership.setBadge(request.badge());
            membership.setMembershipDurationInMonths(request.membershipDurationInMonths());
            membership.setModifiedAt(request.modifiedAt());
            membership.setModifiedAttribute(request.modifiedAttribute());
            membership.setPrice(request.price());
            membership.setName(request.name());
            membership.setDescription(request.description());
            //ban
            //message
            repository.save(membership);
            response.setMessage("membership type Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(membership);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("membership type already exist");
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


    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<MembershipTypeModel> model=repository.findById(id);
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

    @PutMapping("/updateMembershipType")
    public ResponseModel updateMembershipType(@RequestBody UpdateRequest request) {

        Optional<MembershipTypeModel> membershipTypeModel = repository.findById(request.id());
        if (membershipTypeModel.isPresent()){
            MembershipTypeModel membership = membershipTypeModel.get();
            membership.setCreatedAt(request.createdAt());
            membership.setBadge(request.badge());
            membership.setMembershipDurationInMonths(request.membershipDurationInMonths());
            membership.setModifiedAt(request.modifiedAt());
            membership.setModifiedAttribute(request.modifiedAttribute());
            membership.setPrice(request.price());
            membership.setName(request.name());
            membership.setDescription(request.description());

            //ban
            //message
            repository.save(membership);
            response.setMessage("membership type information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(membership);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("membership type unfounded");
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
    @DeleteMapping("/deleteMembershipType{membershipTypeId}")
    public void deleteMembershipType(@PathVariable("membershipTypeId") int id) {
        repository.deleteById(id);
    }
}

