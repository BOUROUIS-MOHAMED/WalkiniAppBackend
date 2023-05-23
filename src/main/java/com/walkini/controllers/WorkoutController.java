package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.NormalUserRepository;
import com.walkini.repositories.WorkoutPartRepository;
import com.walkini.repositories.WorkoutRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/workout")
@CrossOrigin
public class WorkoutController {
    private final WorkoutRepository repository;
    private final WorkoutPartRepository workoutPartRepository;
    private  final NormalUserRepository normalUserRepository;





    ResponseModel response=new ResponseModel();

    public WorkoutController(WorkoutRepository repository, WorkoutPartRepository workoutPartRepository, NormalUserRepository normalUserRepository) {
        this.repository = repository;
        this.workoutPartRepository = workoutPartRepository;
        this.normalUserRepository = normalUserRepository;
    }

    @GetMapping("/getWorkoutById/{id}")
    public ResponseModel getById(@PathVariable Integer id) {
        Optional<WorkoutModel> model=repository.findById(id);
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
    @GetMapping("/getWorkoutPartById/{id}")
    public ResponseModel getWorkoutPartById(@PathVariable Integer id) {
        Optional<WorkoutPartModel> model=workoutPartRepository.findById(id);
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

    @PostMapping("/setWorkoutToUser")
    public ResponseModel setWorkoutToUserAPI(@RequestParam Integer id, @RequestParam Integer userId) {
        return setWorkoutToUser(id,userId);
    }
    public ResponseModel setWorkoutToUser(Integer id,Integer userId) {

        Optional<WorkoutModel> workoutModel=repository.findById(id);
        if (workoutModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getWorkouts();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (!myList.contains(id.toString())){
                    myList.add(id.toString());
                    profile.get().setWorkouts(String.join("---",myList));
                    response.setMessage("the "+workoutModel.get().getWorkoutName()+ " workout added to user with mail\"+profile.get().getEmail() +\" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getWorkouts());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user already had this workout");
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
            response.setMessage("No workout found with this info");
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
    @PostMapping("/removeWorkoutToUser")
    public ResponseModel removeWorkoutToUserApi(@RequestParam Integer id,@RequestParam Integer userId) {
        removeWorkoutToUser(id, userId);
        return response;
    }
    public ResponseModel removeWorkoutToUser(Integer id,Integer userId){


        Optional<WorkoutModel> workoutModel=repository.findById(id);
        if (workoutModel.isPresent()){
            Optional<NormalUserModel> profile= normalUserRepository.findById(userId);
            if (profile.isPresent()){
                String str= profile.get().getWorkouts();
                List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
                if (myList.contains(id.toString())){
                    myList.remove(id.toString());
                    profile.get().setWorkouts(String.join("---",myList));
                    response.setMessage("the "+workoutModel.get().getWorkoutName()+" workout removed from the user with mail "+profile.get().getEmail() +" Successfully");
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setReturnedBoolean(true);
                    response.setObject(profile);
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedInteger(null);
                    response.setReturnedList(myList);
                    response.setReturnedString(profile.get().getWorkouts());
                    response.setReturnedMultipartFile(null);
                } else {
                    response.setMessage("this user dont have this workout");
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
            response.setMessage("No workout found with this info");
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


    record CreationRequest(Integer id, String workoutName, String workoutMainImage, String workoutParts, Boolean workoutIsFree, Boolean priceInEmerald, Double workoutPrice, String workoutDescription, Double workoutTimeInMinutes, String workoutFocusedBodyPart, String createdAt, String modifiedAt) {
    }
    record UpdateRequest(Integer id, String workoutName, String workoutMainImage, String workoutParts, Boolean workoutIsFree, Boolean priceInEmerald, Double workoutPrice, String workoutDescription, Double workoutTimeInMinutes, String workoutFocusedBodyPart, String createdAt, String modifiedAt) {
    }

    @GetMapping("/getAllWorkouts")
    public List<WorkoutModel> getAllWorkouts() {
        return repository.findAll();
    }

    @PostMapping("/createWorkout")
    public ResponseModel createWorkout(@RequestBody CreationRequest request )  {

        List<WorkoutModel> workoutModelList=repository.findByWorkoutName(request.workoutName());
        if(workoutModelList.isEmpty()){
            WorkoutModel workoutModel = new WorkoutModel();
            workoutModel.setWorkoutDescription(request.workoutDescription());
            workoutModel.setWorkoutMainImage(request.workoutMainImage());
            workoutModel.setWorkoutIsFree(request.workoutIsFree());
            workoutModel.setWorkoutParts(request.workoutParts());
            workoutModel.setWorkoutName(request.workoutName());
            workoutModel.setWorkoutPrice(request.workoutPrice());
            workoutModel.setWorkoutTimeInMinutes(request.workoutTimeInMinutes());
            workoutModel.setWorkoutFocusedBodyPart(request.workoutFocusedBodyPart());
            workoutModel.setCreatedAt(request.createdAt());
            workoutModel.setPriceInEmerald(request.priceInEmerald());
            workoutModel.setModifiedAt(request.modifiedAt());

            repository.save(workoutModel);
            response.setMessage("workout Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(workoutModel);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("workout already exist");
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


    @PutMapping("/updateWorkout")
    public ResponseModel workout(@RequestBody UpdateRequest request) {

        Optional<WorkoutModel> workoutModelList = repository.findById(request.id());
        if (workoutModelList.isPresent()){
            WorkoutModel workoutModel = workoutModelList.get();
            workoutModel.setWorkoutDescription(request.workoutDescription());
            workoutModel.setWorkoutMainImage(request.workoutMainImage());
            workoutModel.setWorkoutIsFree(request.workoutIsFree());
            workoutModel.setWorkoutParts(request.workoutParts());
            workoutModel.setWorkoutName(request.workoutName());
            workoutModel.setWorkoutPrice(request.workoutPrice());
            workoutModel.setWorkoutTimeInMinutes(request.workoutTimeInMinutes());
            workoutModel.setWorkoutFocusedBodyPart(request.workoutFocusedBodyPart());
            workoutModel.setCreatedAt(request.createdAt());
            workoutModel.setPriceInEmerald(request.priceInEmerald());
            workoutModel.setModifiedAt(request.modifiedAt());

            //ban
            //message
            repository.save(workoutModel);
            response.setMessage("workout information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(workoutModel);

            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("workout unfounded");
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
    @DeleteMapping("/deleteWorkout{WorkoutId}")
    public void deleteWorkout(@PathVariable("WorkoutId") int id) {
        repository.deleteById(id);
    }




    record WorkoutPartsCreationRequest(Integer id, String workoutPartDescription, String workoutPartVideo, String workoutPartSound, Double workoutPartCaloriesBurned, Double workoutPartDurationInSeconds, String createdAt, String modifiedAt) {
    }
    record WorkoutPartsUpdateRequest(Integer id, String workoutPartDescription, String workoutPartVideo, String workoutPartSound, Double workoutPartCaloriesBurned, Double workoutPartDurationInSeconds, String createdAt, String modifiedAt) {
    }

    @GetMapping("/getAllWorkoutParts")
    public List<WorkoutPartModel> getAllWorkoutParts() {
        return workoutPartRepository.findAll();
    }

    @PostMapping("/createWorkoutParts")
    public ResponseModel createWorkoutParts(@RequestBody WorkoutPartsCreationRequest request )  {

            WorkoutPartModel workoutModel = new WorkoutPartModel();
            workoutModel.setWorkoutPartDescription(request.workoutPartDescription());
            workoutModel.setWorkoutPartVideo(request.workoutPartVideo());
            workoutModel.setWorkoutPartSound(request.workoutPartSound());
            workoutModel.setWorkoutPartCaloriesBurned(request.workoutPartCaloriesBurned());
            workoutModel.setWorkoutPartDurationInSeconds(request.workoutPartDurationInSeconds());
            workoutModel.setCreatedAt(request.createdAt());
            workoutModel.setModifiedAt(request.modifiedAt());

            workoutPartRepository.save(workoutModel);
            response.setMessage("workout part Added Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(workoutModel);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        return response;
    }


    @PutMapping("/updateWorkoutPart")
    public ResponseModel updateWorkoutPart(@RequestBody WorkoutPartsUpdateRequest request) {

        Optional<WorkoutPartModel> workoutModelList = workoutPartRepository.findById(request.id());
        if (workoutModelList.isPresent()){
            WorkoutPartModel workoutModel = workoutModelList.get();
            workoutModel.setWorkoutPartDescription(request.workoutPartDescription());
            workoutModel.setWorkoutPartVideo(request.workoutPartVideo());
            workoutModel.setWorkoutPartSound(request.workoutPartSound());
            workoutModel.setWorkoutPartCaloriesBurned(request.workoutPartCaloriesBurned());
            workoutModel.setWorkoutPartDurationInSeconds(request.workoutPartDurationInSeconds());
            workoutModel.setCreatedAt(request.createdAt());
            workoutModel.setModifiedAt(request.modifiedAt());


            //ban
            //message
            workoutPartRepository.save(workoutModel);
            response.setMessage("workout part information updated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(workoutModel);

            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }else {
            response.setMessage("workout unfounded");
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
    @DeleteMapping("/deleteWorkoutPart{WorkoutId}")
    public void deleteWorkoutPart(@PathVariable("WorkoutId") int id) {
        workoutPartRepository.deleteById(id);
    }
}
