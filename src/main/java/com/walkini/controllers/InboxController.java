
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CouponRepository;
import com.walkini.repositories.InboxRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/inbox")
@CrossOrigin
public class InboxController {
    private final InboxRepository repository;
    private final ProfileController profileController;

    public InboxController(InboxRepository repository, ProfileController profileController) {
        this.repository = repository;
        this.profileController = profileController;
    }


    record CreationRequest(String title, String content, String image, Integer firstAction, Integer secondAction, Boolean isGift, Boolean isCollected, Boolean isSeen, Integer collectGiftButtonAction, Timestamp createdAt) {
    }
    record UpdateRequest(Integer id, String title, String content, String image, Integer firstAction, Integer secondAction, Boolean isGift, Boolean isCollected, Boolean isSeen, Integer collectGiftButtonAction, Timestamp createdAt, Timestamp modifiedAt) {
    }
    Response response = new Response();

    @GetMapping("/markInboxAsSeen")
    public Response markInboxAsSeen() {
        return response;
    }


    @GetMapping("/getAllInbox")
    public List<InboxModel> getAllInbox() {
        return repository.findAll();
    }
    @GetMapping("/getInbox{inboxId}")
    public Response getInbox(@RequestParam String inboxId) {
        int id = Integer.parseInt(inboxId);

        if (repository.existsById(id)) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("inbox founded");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("inbox unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }


    @PostMapping("/createInbox")
    public Response createInbox(@RequestBody CreationRequest request )  {

        ExampleMatcher matching = ExampleMatcher.matching()
                .withMatcher("title", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<InboxModel> example = Example.<InboxModel>of(new InboxModel(request.title()), matching);
        boolean exists = repository.exists(example);
        if(exists){
            InboxModel inbox = new InboxModel();
            inbox.setCreatedAt(request.createdAt());
            inbox.setCollected(request.isCollected());
            inbox.setContent(request.content());
            inbox.setGift(request.isGift());
            inbox.setImage(request.image());
            inbox.setSeen(request.isSeen());
            inbox.setContent(request.content());
            inbox.setCollectGiftButtonAction(request.collectGiftButtonAction());
            inbox.setFirstAction(request.firstAction());
            inbox.setSecondAction(request.secondAction());
            inbox.setTitle(request.title());


            //ban
            //message
            repository.save(inbox);
            response.setMessage("inbox Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("inbox already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PutMapping("/updateInbox")
    public Response updateInbox(@RequestBody UpdateRequest request) {
        InboxModel inbox = new InboxModel();
        Optional<InboxModel> inboxModel = repository.findById(request.id());
        if (inboxModel.isPresent()){
            inbox.setModifiedAt(request.modifiedAt());
            inbox.setCreatedAt(request.createdAt());
            inbox.setCollected(request.isCollected());
            inbox.setContent(request.content());
            inbox.setGift(request.isGift());
            inbox.setImage(request.image());
            inbox.setSeen(request.isSeen());
            inbox.setContent(request.content());
            inbox.setCollectGiftButtonAction(request.collectGiftButtonAction());
            inbox.setFirstAction(request.firstAction());
            inbox.setSecondAction(request.secondAction());
            inbox.setTitle(request.title());

            //ban
            //message
            repository.save(inbox);
            response.setMessage("inbox information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(inbox);
        }else {
            response.setMessage("inbox unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteInbox{inboxId}")
    public void deleteInbox(@PathVariable("inboxId") int id) {
        repository.deleteById(id);
    }
}

