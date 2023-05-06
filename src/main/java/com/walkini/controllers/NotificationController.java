
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.NotificationRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/notification")
@CrossOrigin
public class NotificationController {
    private final NotificationRepository repository;
    private final ProfileController profileController;

    public NotificationController(NotificationRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(String name, String image, String subtitle, Integer action, Timestamp createdAt, Timestamp modifiedAt) {  }
    record UpdateRequest(Integer id, String name, String image, String subtitle, Integer action, Timestamp createdAt, Timestamp modifiedAt) { }
    Response response = new Response();

    @GetMapping("/getAllNotificationForUser")
    public List<NotificationModel> getAllNotificationForUser() {
        return repository.findAll();
    }


    @GetMapping("/getAllNotification")
    public List<NotificationModel> getAllNotification() {
        return repository.findAll();
    }
    @GetMapping("/getNotification{notificationId}")
    public Response getNotification(@RequestParam String notificationId) {
        int id = Integer.parseInt(notificationId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("notification founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("notification unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }


    @PostMapping("/createNotification")
    public Response createNotification(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<NotificationModel> example = Example.<NotificationModel>of(new NotificationModel(request.name()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            NotificationModel notification = new NotificationModel();
           notification.setAction(request.action());
           notification.setCreatedAt(request.createdAt());
           notification.setImage(request.image());
           notification.setModifiedAt(request.modifiedAt());
           notification.setName(request.name());
           notification.setSubtitle(request.subtitle());

            //ban
            //message
            repository.save(notification);
            response.setMessage("notification Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("notification already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateNotification")
    public Response updateCoupon(@RequestBody UpdateRequest request) {
        NotificationModel notification = new NotificationModel();
        Optional<NotificationModel> notificationModel = repository.findById(request.id());
        if (notificationModel.isPresent()){
            notification.setAction(request.action());
            notification.setCreatedAt(request.createdAt());
            notification.setImage(request.image());
            notification.setModifiedAt(request.modifiedAt());
            notification.setName(request.name());
            notification.setSubtitle(request.subtitle());

            //ban
            //message
            repository.save(notification);
            response.setMessage("notification information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(notification);
        }else {
            response.setMessage("notification unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteNotification{notificationId}")
    public void deleteNotification(@PathVariable("notificationId") int id) {
        repository.deleteById(id);
    }
}

