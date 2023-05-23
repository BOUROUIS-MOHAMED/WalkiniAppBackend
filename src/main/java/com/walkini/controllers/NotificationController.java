
package com.walkini.controllers;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Notification;
import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.NormalUserRepository;
import com.walkini.repositories.NotificationRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/notification")
@CrossOrigin
public class NotificationController {
    private final NotificationRepository repository;
    private final NormalUserRepository normalUserRepository;

    private FirebaseMessaging firebaseMessaging;

    public NotificationController(NotificationRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.normalUserRepository = normalUserRepository;
    }
    record CreationRequest(Integer id, String name, String image, Boolean notificationHasImage, String subtitle, Integer action, String createdAt, String modifiedAt) {  }
    record UpdateRequest(Integer id, String name, String image, Boolean notificationHasImage, String subtitle, Integer action, String createdAt, String modifiedAt) { }
    ResponseModel response = new ResponseModel();














    @PostMapping("/setNotificationToUser")
    public ResponseModel setNotificationToUserAPI(@RequestParam Integer id,@RequestParam Integer userId) {
        return setNotificationToUser(id,userId);
    }
    public ResponseModel setNotificationToUser(Integer id,Integer userId) {

        Optional<NotificationModel> notificationModel=repository.findById(id);
        if (notificationModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getReceivedNotification();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (!myList.contains(id.toString())){
                    myList.add(id.toString());
                    profile.get().setReceivedNotification(String.join("---",myList));
                    response.setMessage("the "+ notificationModel.get().getName()+ " notification message added to user with mail "+profile.get().getEmail() + " Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getReceivedNotification());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user already had this notification");
                    response.setErrorType(ErrorResponseType.DataAlreadyExist);
                    response.setReturnedBoolean(false);
                    response.setObject(myList);
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                }

            }else{
                response.setMessage("No user found with this info");
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
        }else {
            response.setMessage("No notification found with this info");
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
    @PostMapping("/removeNotificationToUser")
    public ResponseModel removeNotificationToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
        removeNotificationToUser(id, userId);
        return response;
    }
    public ResponseModel removeNotificationToUser(Integer id,Integer userId){


        Optional<NotificationModel> notificationModel=repository.findById(id);
        if (notificationModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getReceivedNotification();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setReceivedNotification(String.join("---",myList));
                    response.setMessage("the "+notificationModel.get().getName()+" notification removed from the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getReceivedNotification());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this notification");
                    response.setErrorType(ErrorResponseType.DataAlreadyExist);
                    response.setReturnedBoolean(false);
                    response.setObject(myList);
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                }

            }else{
                response.setMessage("No user found with this info");
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
        }else {
            response.setMessage("No notification found with this info");
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


    @GetMapping("/getAllNotificationForUser")
    public List<NotificationModel> getAllNotificationForUser() {
        return repository.findAll();
    }


    @GetMapping("/getAllNotification")
    public ResponseModel getAllNotification() {
        List<NotificationModel> notificationModelList= repository.findAll();
        response.setMessage("notifications");
        response.setErrorType(ErrorResponseType.Nothing);
        response.setReturnedBoolean(true);
        response.setObject(notificationModelList);
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
        return response;
    }

    @PostMapping("/createNotification")
    public ResponseModel createNotification(@RequestBody CreationRequest request )  {


            NotificationModel notification = new NotificationModel();
           notification.setAction(request.action());
           notification.setCreatedAt(request.createdAt());
           notification.setImage(request.image());
           notification.setModifiedAt(request.modifiedAt());
           notification.setName(request.name());
           notification.setSubtitle(request.subtitle());
           notification.setNotificationHasImage(request.notificationHasImage());
            repository.save(notification);
            response.setMessage("notification Added Successfully");
        response.setErrorType(ErrorResponseType.Nothing);
        response.setReturnedBoolean(true);
        response.setObject(notification);
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
        return response;
    }


    @PutMapping("/updateNotification")
    public ResponseModel updateCoupon(@RequestBody UpdateRequest request) {

        Optional<NotificationModel> notificationModel = repository.findById(request.id());
        if (notificationModel.isPresent()){
            NotificationModel notification = notificationModel.get();
            notification.setAction(request.action());
            notification.setCreatedAt(request.createdAt());
            notification.setImage(request.image());
            notification.setModifiedAt(request.modifiedAt());
            notification.setName(request.name());
            notification.setSubtitle(request.subtitle());
            notification.setNotificationHasImage(request.notificationHasImage());

            repository.save(notification);
            response.setMessage("notification information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(notification);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("notification unfounded");
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
    @DeleteMapping("/deleteNotification{notificationId}")
    public void deleteNotification(@PathVariable("notificationId") int id) {
        repository.deleteById(id);
    }
}

