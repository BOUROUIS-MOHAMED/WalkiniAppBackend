package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.LastModificationDateRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/modificationDetector")
@CrossOrigin
public class LastModificationDateController {
    private final LastModificationDateRepository repository;






    ResponseModel response=new ResponseModel();

    public LastModificationDateController(LastModificationDateRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/setLastModificationDate")
    public ResponseModel setLastModificationDate(@RequestParam String date) {
        return setLastModificationDateNow(date);
    }
    ResponseModel setLastModificationDateNow(String date){
       List<LastModificationDateModel> modelList= repository.findAll();
       if (modelList.isEmpty()){
           LastModificationDateModel model=new LastModificationDateModel();
           model.setLastServerModificationDate(date);
           repository.save(model);
       }else {
           LastModificationDateModel model=modelList.get(0);
           model.setLastServerModificationDate(date);
           repository.save(model);
       }
       ResponseModel responseModel=new ResponseModel();
       responseModel.setMessage("the last modification date of this server is updated to "+date);
        responseModel.setThereIsAnError(false);
       return responseModel;
    }

    @GetMapping("/getLastModificationDate")
    public ResponseModel getLastModificationDate() {
        return getLastModificationDateNow();
    }
    ResponseModel getLastModificationDateNow(){
        List<LastModificationDateModel> modelList= repository.findAll();
        if (modelList.isEmpty()){
            ResponseModel responseModel=new ResponseModel();
            responseModel.setThereIsAnError(true);
            responseModel.setMessage("error please try again later ");
            return responseModel;
        }else {
            LastModificationDateModel model=modelList.get(0);
            ResponseModel responseModel=new ResponseModel();
            responseModel.setMessage(model.getLastServerModificationDate());
            responseModel.setThereIsAnError(false);
            return responseModel;
        }

    }
    @GetMapping("/getShouldIDownloadAppData")
    public ResponseModel getShouldIDownloadAppData(@RequestParam String date) {
        return getShouldIDownloadTheAppData(date);
    }
    ResponseModel getShouldIDownloadTheAppData(String date){
        List<LastModificationDateModel> modelList= repository.findAll();
        if (modelList.isEmpty()){
            ResponseModel responseModel=new ResponseModel();
            responseModel.setReturnedBoolean(true);
            responseModel.setThereIsAnError(false);
            responseModel.setMessage("true");
            return responseModel;
        }else {
            LastModificationDateModel model=modelList.get(0);
            LocalDateTime restoredDate=LocalDateTime.parse(model.getLastServerModificationDate());
            LocalDateTime userDate=LocalDateTime.parse(date);
            Boolean result=restoredDate.isAfter(userDate);
            ResponseModel responseModel=new ResponseModel();
            responseModel.setMessage(result.toString());
            responseModel.setThereIsAnError(false);
            responseModel.setReturnedBoolean(result);
            return responseModel;
        }

    }

}
