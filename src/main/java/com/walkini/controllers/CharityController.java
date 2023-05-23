
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.CharityRepository;
import com.walkini.repositories.WaitingCharityManagingListRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/charity")
@CrossOrigin
public class CharityController {
    private final CharityRepository repository;
    private final WaitingCharityManagingListRepository waitingCharityManagingListRepository;

    public CharityController(CharityRepository repository, WaitingCharityManagingListRepository waitingCharityManagingListRepository) {
        this.repository = repository;
        this.waitingCharityManagingListRepository = waitingCharityManagingListRepository;

    }


    record CreationRequest(Integer id, String title, String image, String description, String target, String score,
                           Boolean inEmerald, String category, String currentAmount, String limitDay, Double latitude,
                           Double longitude, Integer owner, String createdAt, String modifiedAt) {
    }

    record UpdateRequest(Integer id, String title, String image, String description, String target, String score,
                         Boolean inEmerald, String category, String currentAmount, String limitDay, Double latitude,
                         Double longitude, Integer owner, String createdAt, String modifiedAt) {
    }

    ResponseModel response = new ResponseModel();

    @GetMapping("/donateToCharity")
    public ResponseModel donateToCharity() {
        return response;
    }

    @GetMapping("/getCharityDemandById/{id}")
    public ResponseModel getCharityDemandById(@PathVariable Integer id) {
        Optional<WaitingCharityManagingListModel> model=waitingCharityManagingListRepository.findById(id);
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
    @GetMapping("/getById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<CharityModel> model=repository.findById(id);
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

    @GetMapping("/getAllCharity")
    public List<CharityModel> getAllCharity() {
        return repository.findAll();
    }

    @GetMapping("/getAllCharityDemand")
    public List<WaitingCharityManagingListModel> getAllCharityDemand() {
        return waitingCharityManagingListRepository.findAll();
    }


    //
    //
    //
    //
    @PostMapping("/acceptAddCharity{id}")
    public ResponseModel acceptAddCharity(@PathVariable("id") int id) {
        Optional<WaitingCharityManagingListModel> waitingCharityManagingListModel = waitingCharityManagingListRepository.findById(id);
        if (waitingCharityManagingListModel.isPresent()) {
            if (waitingCharityManagingListModel.get().getRequestType() == requestType.add) {
                List<CharityModel> charityModelList = repository.findByTitle(waitingCharityManagingListModel.get().getTitle());
                if (charityModelList.isEmpty()) {
                    CharityModel charity = new CharityModel();
                    charity.setCreatedAt(waitingCharityManagingListModel.get().getCreatedAt());
                    charity.setModifiedAt(waitingCharityManagingListModel.get().getModifiedAt());
                    charity.setTarget(waitingCharityManagingListModel.get().getTarget());
                    charity.setLongitude(waitingCharityManagingListModel.get().getLongitude());
                    charity.setLimitDay(waitingCharityManagingListModel.get().getLimitDay());
                    charity.setLatitude(waitingCharityManagingListModel.get().getLatitude());
                    charity.setInEmerald(waitingCharityManagingListModel.get().getInEmerald());
                    charity.setCategory(waitingCharityManagingListModel.get().getCategory());
                    charity.setImage(waitingCharityManagingListModel.get().getImage());
                    charity.setDescription(waitingCharityManagingListModel.get().getDescription());
                    charity.setCurrentAmount(waitingCharityManagingListModel.get().getCurrentAmount());
                    charity.setTitle(waitingCharityManagingListModel.get().getTitle());
                    charity.setOwner(waitingCharityManagingListModel.get().getOwner());
                    charity.setScore(waitingCharityManagingListModel.get().getScore());
                    repository.save(charity);
                    waitingCharityManagingListRepository.deleteById(id);
                    response.setMessage("charity Added Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(charity);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(null);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("charity already exist");
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
            } else {
                response.setMessage("the request type is not add ");
                response.setErrorType(ErrorResponseType.DataCorrupted);
                response.setReturnedBoolean(false);
                response.setObject(null);
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            }

        } else {
            response.setMessage("no charity found in the waiting list with this id");
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


    //
    //
    //
    //
    @PostMapping("/createCharity")
    public ResponseModel createNewCharity(@RequestBody CreationRequest request) {
        List<CharityModel> charityModelList = repository.findByTitle(request.title());
        if (charityModelList.isEmpty()) {
            WaitingCharityManagingListModel charity = new WaitingCharityManagingListModel();
            charity.setRequestType(requestType.add);
            charity.setCreatedAt(request.createdAt());
            charity.setModifiedAt(request.modifiedAt());
            charity.setTarget(request.target());
            charity.setLongitude(request.longitude());
            charity.setLimitDay(request.limitDay());
            charity.setLatitude(request.latitude());
            charity.setInEmerald(request.inEmerald());
            charity.setCategory(request.category());
            charity.setImage(request.image());
            charity.setDescription(request.description());
            charity.setCurrentAmount(request.currentAmount());
            charity.setTitle(request.title());
            charity.setOwner(request.owner());
            charity.setScore(request.score());
            waitingCharityManagingListRepository.save(charity);
            response.setMessage("charity Added Successfully to waiting list");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(charity);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("charity already exist in waiting list");
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


    /******************************************************************************************************************/



    /****UPDATE PRODUCT****/
    @PutMapping("/updateProduct")
    public ResponseModel updateProduct(@RequestBody UpdateRequest request) {
        Optional<CharityModel> charityModel = repository.findById(request.id());
        if (charityModel.isPresent()) {
            List<WaitingCharityManagingListModel> waitingCharityManagingListModelList = waitingCharityManagingListRepository.findByModifiedCharityId(request.id());
            if (waitingCharityManagingListModelList.isEmpty()) {
                WaitingCharityManagingListModel charity = new WaitingCharityManagingListModel();
                charity.setModifiedCharityId(request.id());
                charity.setRequestType(requestType.modify);
                charity.setCreatedAt(request.createdAt());
                charity.setModifiedAt(request.modifiedAt());
                charity.setTarget(request.target());
                charity.setLongitude(request.longitude());
                charity.setLimitDay(request.limitDay());
                charity.setLatitude(request.latitude());
                charity.setInEmerald(request.inEmerald());
                charity.setCategory(request.category());
                charity.setImage(request.image());
                charity.setDescription(request.description());
                charity.setCurrentAmount(request.currentAmount());
                charity.setTitle(request.title());
                charity.setOwner(request.owner());
                charity.setScore(request.score());
                waitingCharityManagingListRepository.save(charity);
                response.setMessage("charity Added Successfully to waiting list");
                response.setErrorType(ErrorResponseType.Nothing);
                response.setReturnedBoolean(true);
                response.setObject(charity);
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setReturnedInteger(null);
                response.setReturnedList(null);
                response.setReturnedString(null);
                response.setReturnedMultipartFile(null);
            } else {
                response.setMessage("already there is a modify request for this charity,please wait or call the support team");
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
        } else {
            response.setMessage("charity unfounded");
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

    @PutMapping("/acceptUpdateCharity{id}")
    public ResponseModel acceptUpdateCharity(@PathVariable("id") Integer id) {
        Optional<WaitingCharityManagingListModel> waitingCharityManagingListModel = waitingCharityManagingListRepository.findById(id);
        if (waitingCharityManagingListModel.isPresent()) {
            if (waitingCharityManagingListModel.get().getRequestType() == requestType.modify) {
                Optional<CharityModel> charityModelList = repository.findById(waitingCharityManagingListModel.get().getModifiedCharityId());
                if (!charityModelList.isPresent()) {
                    CharityModel charity = charityModelList.get();
                    charity.setCreatedAt(waitingCharityManagingListModel.get().getCreatedAt());
                    charity.setModifiedAt(waitingCharityManagingListModel.get().getModifiedAt());
                    charity.setTarget(waitingCharityManagingListModel.get().getTarget());
                    charity.setLongitude(waitingCharityManagingListModel.get().getLongitude());
                    charity.setLimitDay(waitingCharityManagingListModel.get().getLimitDay());
                    charity.setLatitude(waitingCharityManagingListModel.get().getLatitude());
                    charity.setInEmerald(waitingCharityManagingListModel.get().getInEmerald());
                    charity.setCategory(waitingCharityManagingListModel.get().getCategory());
                    charity.setImage(waitingCharityManagingListModel.get().getImage());
                    charity.setDescription(waitingCharityManagingListModel.get().getDescription());
                    charity.setCurrentAmount(waitingCharityManagingListModel.get().getCurrentAmount());
                    charity.setTitle(waitingCharityManagingListModel.get().getTitle());
                    charity.setOwner(waitingCharityManagingListModel.get().getOwner());
                    charity.setScore(waitingCharityManagingListModel.get().getScore());
                    repository.save(charity);
                    waitingCharityManagingListRepository.deleteById(id);
                    response.setMessage("charity modified Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(charity);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(null);
                    response.setReturnedString(null);
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("no charity found with this id");
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

            } else {
                response.setMessage("cant perform update request in add request");
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

        } else {
            response.setMessage("no charity found in the waiting list with this id");
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

    //
    @DeleteMapping("/deleteCharity{charityId}")
    public void deleteCharity(@PathVariable("charityId") int id) {
        repository.deleteById(id);
    }
    @DeleteMapping("/refuseCreateOrDeleteCharityDemand{demandId}")
    public void refuseCreateOrDeleteCharityDemand(@PathVariable("demandId") int id) {
        waitingCharityManagingListRepository.deleteById(id);
    }

}

