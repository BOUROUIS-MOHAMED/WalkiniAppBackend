package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.ActionModel;
import com.walkini.models.BanModel;
import com.walkini.models.ErrorResponseType;
import com.walkini.models.Response;
import com.walkini.repositories.ActionRepository;
import com.walkini.repositories.ProfileRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
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


    record NewActionRequest(String name, String route, Timestamp createdAt)  {
    }
    record UpdateActionRequest(Integer id,String name, String route, Timestamp modifiedAt)  {
    }
    Response response = new Response();




    @GetMapping("/getAllAction")
    public List<ActionModel> getAllActions() {
        return repository.findAll();
    }

    @PostMapping("/createAction")
    public Response createAction(@RequestBody NewActionRequest request )  {

        ExampleMatcher actionNameMatching = ExampleMatcher.matching()
                .withMatcher("actionName", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ActionModel> example = Example.<ActionModel>of(new ActionModel(request.name()), actionNameMatching);
        boolean actionExists = repository.exists(example);
        if(actionExists){
            ActionModel action = new ActionModel();
            action.setCreatedAt(request.createdAt());
            action.setName(request.name());
            action.setRoute(request.route());
            //ban
            //message
            repository.save(action);
            response.setMessage("action Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("action already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateAction")
    public Response updateAction(@RequestBody UpdateActionRequest request) {
        ActionModel action = new ActionModel();
        Optional<ActionModel> actionModel = repository.findById(request.id());
        if (actionModel.isPresent()){

            action.setName(request.name());
            action.setRoute(request.route());
            action.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(action);
            response.setMessage("action information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(action);
        }else {
            response.setMessage("action unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteAction{actionId}")
    public void deleteAction(@PathVariable("actionId") int id) {
        repository.deleteById(id);
    }
}

