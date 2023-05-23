
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.InboxRepository;
import com.walkini.repositories.NormalUserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/inbox")
@CrossOrigin
public class InboxController {
    private final InboxRepository repository;
    private final NormalUserRepository normalUserRepository;


    public InboxController(InboxRepository repository, NormalUserRepository normalUserRepository) {
        this.repository = repository;

        this.normalUserRepository = normalUserRepository;
    }


    record CreationRequest( String title, String content, Boolean isGift, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String title, String content, Boolean isGift, String createdAt, String modifiedAt) {
    }
    ResponseModel response = new ResponseModel();
    @PostMapping("/setInboxToUser")
    public ResponseModel setInboxToUserAPI(@RequestParam Integer id,@RequestParam Integer userId) {
        return setInboxToUser(id,userId);
    }
    public ResponseModel setInboxToUser(Integer id,Integer userId) {

        Optional<InboxModel> inboxModel=repository.findById(id);
        if (inboxModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getInbox();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (!myList.contains(id.toString())){
                    myList.add(id.toString());
                    profile.get().setInbox(String.join("---",myList));
                    response.setMessage("the "+ inboxModel.get().getTitle()+ " inbox message added to user with mail "+profile.get().getEmail() + " Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getInbox());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user already had this inbox");
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
            response.setMessage("No inbox found with this info");
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
    @PostMapping("/removeInboxToUser")
    public ResponseModel removeInboxToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
        removeInboxToUser(id, userId);
        return response;
    }
    public ResponseModel removeInboxToUser(Integer id,Integer userId){


        Optional<InboxModel> inboxModel=repository.findById(id);
        if (inboxModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getInbox();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setInbox(String.join("---",myList));
                    response.setMessage("the "+inboxModel.get().getTitle()+" inbox removed from the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getInbox());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this inbox");
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
            response.setMessage("No inbox found with this info");
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
    @GetMapping("/markInboxAsSeen")
    public ResponseModel markInboxAsSeenApi(@RequestParam Integer id,@RequestParam Integer userId) {
        return  markInboxAsSeen(id,userId);
    }


    public ResponseModel markInboxAsSeen(Integer id,Integer userId) {

        Optional<InboxModel> inboxModel=repository.findById(id);
        if (inboxModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getInbox();
                String strSeen= profile.get().getSeenInbox();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                List<String> mySeenList = new ArrayList<String>(Arrays.asList(strSeen.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                   mySeenList.add(id.toString());
                   profile.get().setSeenInbox(String.join("---",mySeenList));
                    profile.get().setInbox(String.join("---",myList));
                    response.setMessage("the "+inboxModel.get().getTitle()+" inbox marked as seen for the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getInbox());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this inbox");
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
            response.setMessage("No inbox found with this info");
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


    @GetMapping("/getAllInbox")
    public List<InboxModel> getAllInbox() {
        return repository.findAll();
    }

    @PostMapping("/createInbox")
    public ResponseModel createInbox(@RequestBody CreationRequest request )  {

       List<InboxModel> inboxModels=repository.findBytitle(request.title());
        if(inboxModels.isEmpty()){
            InboxModel inbox = new InboxModel();
            inbox.setCreatedAt(request.createdAt());
            inbox.setTitle(request.title());
            inbox.setModifiedAt(request.modifiedAt());
            inbox.setContent(request.content());
            inbox.setGift(request.isGift());


            //ban
            //message
            repository.save(inbox);
            response.setMessage("inbox Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(inbox);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("inbox already exist");
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


    @PutMapping("/updateInbox")
    public ResponseModel updateInbox(@RequestBody UpdateRequest request) {

        Optional<InboxModel> inboxModel = repository.findById(request.id());
        if (inboxModel.isPresent()){
            InboxModel inbox = inboxModel.get();
            inbox.setCreatedAt(request.createdAt());
            inbox.setTitle(request.title());
            inbox.setModifiedAt(request.modifiedAt());
            inbox.setContent(request.content());
            inbox.setGift(request.isGift());
            repository.save(inbox);
            response.setMessage("inbox information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(inbox);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("inbox unfounded");
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
    @DeleteMapping("/deleteInbox{inboxId}")
    public void deleteInbox(@PathVariable("inboxId") int id) {
        repository.deleteById(id);
    }
}

