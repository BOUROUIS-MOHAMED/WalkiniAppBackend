package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.ActionModel;
import com.walkini.models.BadgeModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.ResponseModel;
import com.walkini.repositories.ActionRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/action")
@CrossOrigin
public class ActionController {
    private final ActionRepository repository;



    public ActionController(ActionRepository repository) {
        this.repository = repository;

    }


    record NewActionRequest(String name, String route, String createdAt, String modifiedAt)  {
    }
    record UpdateActionRequest(Integer id, String name, String route, String createdAt, String modifiedAt)  {
    }
    ResponseModel response = new ResponseModel();




    @GetMapping("/getAllAction")
    public List<ActionModel> getAllActions() {
        return repository.findAll();
    }

    @PostMapping("/createAction")
    public ResponseModel createAction(@RequestBody NewActionRequest request )  {
      List<ActionModel> actionModelList= repository.findByName(request.name());
        if(actionModelList.isEmpty()){
            ActionModel action = new ActionModel();
            action.setCreatedAt(request.createdAt());
            action.setName(request.name());

            action.setRoute(request.route());
            action.setModifiedAt(request.modifiedAt());
            repository.save(action);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(action);
            response.setMessage("action created successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setMessage("action already exist");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }


    @PutMapping("/updateAction")
    public ResponseModel updateAction(@RequestBody UpdateActionRequest request) {

        Optional<ActionModel> actionModel = repository.findById(request.id());
        if (actionModel.isPresent()){
            ActionModel action = actionModel.get();
            String previousName=actionModel.get().getName();
            action.setName(request.name());
            action.setRoute(request.route());
            action.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(action);
            response.setMessage("action named"+previousName +" updated successfully with the new route "+request.route());
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("action unfounded");
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
    @DeleteMapping("/deleteAction{actionId}")
    public ResponseModel deleteAction(@PathVariable("actionId") int id) {
        Optional<ActionModel> actionModel=repository.findById(id);
        if (actionModel.isPresent()){
        repository.deleteById(id);
            response.setMessage("action "+actionModel.get().getName()+ " deleted successfuly");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
    }else{
            response.setMessage("action unfounded,delete operation failled");
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
    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<ActionModel> model=repository.findById(id);
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

