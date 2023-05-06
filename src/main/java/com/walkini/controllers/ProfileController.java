package com.walkini.controllers;


import com.walkini.models.*;
import com.walkini.repositories.ProfileAdditionalInformationRepository;
import com.walkini.repositories.ProfileRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.walkini.AppConstants;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/profile")
@CrossOrigin
public class ProfileController {
    private final ProfileRepository repository;
    private final ProfileAdditionalInformationRepository profileAdditionalInformationRepository;


    public ProfileController(ProfileRepository repository, ProfileAdditionalInformationRepository profileAdditionalInformationRepository) {
        this.repository = repository;

        this.profileAdditionalInformationRepository = profileAdditionalInformationRepository;
    }
    record TestApiRequest(Integer id,
                                      String string
                                     ) {
    }


    @PostMapping("/testApi")

    public Response testPostApi(@RequestBody ProfileModel profileModel) {

            response.setMessage("api tested Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);


        return response;
    }
    @GetMapping("/testApi")
    public Response testGetApi(@RequestBody ProfileModel profileModel) {
        response.setMessage("api tested Successfully");
        response.setErrorCode(20000);
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(profileModel);
        return response;
    }
    @PutMapping("/testApi")
    public Response testPutApi(@RequestBody ProfileModel profileModel) {
        response.setMessage("api post tested Successfully");
        response.setErrorCode(20000);
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(profileModel);
        return response;
    }
    @DeleteMapping("/testApi")
    public Response testDeleteApi(@RequestBody TestApiRequest request) {
        response.setMessage("api tested Successfully");
        response.setErrorCode(20000);
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(request);
        return response;
    }

    record LoginRequest(String email,
                          String phoneNumber,

                        String password
    ) {
    }
    @PostMapping("/login")
    public Response login(@RequestBody LoginRequest request) {
        System.out.println(request);
      /*  ExampleMatcher phoneNumberMatching = ExampleMatcher.matching()
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileModel> example = Example.<ProfileModel>of(new ProfileModel(request.phoneNumber()), phoneNumberMatching);
        ExampleMatcher emailMatching = ExampleMatcher.matching()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileModel> emailExample = Example.<ProfileModel>of(new ProfileModel(request.email()), emailMatching);
        boolean userExists = repository.exists(example) || repository.exists(emailExample);
        System.out.println(repository.exists(example));
        System.out.println(repository.exists(emailExample));*/
        System.out.println(request.phoneNumber());
        System.out.println(request.email());
        System.out.println(request.password());

        List<ProfileModel> profileModelChecker=   repository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
        if (!profileModelChecker.isEmpty()){
         List<ProfileModel> profileModelList=   repository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
         ProfileModel profileModel= profileModelList.get(0);
         System.out.println("this is the restored one "+profileModelList);
            System.out.println("this is the password for the restored one "+profileModel.getSecretPassword());
            System.out.println("this is the password sended  "+request.password());
            System.out.println("this is the equals one "+Objects.equals(profileModel.getSecretPassword(), request.password()));
            System.out.println(("this is the  one " + (profileModel.getSecretPassword()).toString().equals(request.password().toString())));

         if ((profileModel.getSecretPassword()).toString().equals(request.password().toString())){
             response.setErrorType(ErrorResponseType.Nothing);
             response.setMessage("user logged In");
             response.setErrorCode(20000);
             response.setThereIsAnError(false);
             response.setObject(repository.findById(profileModel.getId()));
         }else{
             response.setErrorType(ErrorResponseType.NoDataFound);
             response.setMessage("password mismatching");
             response.setErrorCode(40000);
             response.setThereIsAnError(true);
             response.setObject(null);
         }
        }else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("user unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setObject(null);
        }

        return response;


    }
    record CheckUserExistRequest(String email,
                        String phoneNumber

    ) {
    }

    @PostMapping("/checkUserExist")
    public Response checkUserExist(@RequestBody CheckUserExistRequest request) {
        ExampleMatcher phoneNumberMatching = ExampleMatcher.matching()
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileModel> example = Example.<ProfileModel>of(new ProfileModel(request.phoneNumber()), phoneNumberMatching);
        ExampleMatcher emailMatching = ExampleMatcher.matching()
                .withMatcher("email", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileModel> emailExample = Example.<ProfileModel>of(new ProfileModel(request.email()), phoneNumberMatching);
        boolean userExists = repository.exists(example) || repository.exists(emailExample);
        if (userExists){
                response.setErrorType(ErrorResponseType.Nothing);
                response.setMessage("true");
                response.setErrorCode(20000);
                response.setThereIsAnError(false);
        }else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
        }
        return response;


    }


    @GetMapping("/checkUserExist{userId}")
    public Boolean checkUserExist(@PathVariable String userId) {
        int id = Integer.parseInt(userId);
        if (repository.existsById(id)) {
    return true;

        } else {
           return  false;
        }

    }

    @GetMapping("/getAllUsers")
    public List<ProfileModel> getAllUsers() {
        return repository.findAll();
    }

    @GetMapping("/getUser{x}")
    public Response getUser(@RequestParam String userId) {
        int id = Integer.parseInt(userId);

        if (repository.existsById(id)) {
             response.setErrorType(ErrorResponseType.Nothing);
             response.setMessage("user founded");
             response.setErrorCode(20000);
             response.setThereIsAnError(false);
             response.setObject(repository.findById(id));

        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("user unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
        }
        return response;


    }


    Response response = new Response();

    record AdditionalUserInformationRequest(
            Integer id,
            String height, String weight, String goals, Boolean hadProblems,String problems
    ){

    }

    record NewNormalProfileRequest(String firstName,
                                   String lastName,
                                   String phoneNumber,
                                   String email,
                                   String secretPassword,
                                   String image,
                                   String gender,
                                   Timestamp birthday,
                                   Double latitude,
                                   Double longitude,
                                   String boosts,
                                   Boolean isBanned,
                                   Integer banDetails,
                                   Long banDurationInSeconds,
                                   String qrCode,
                                   String secretKey,
                                   String token,
                                   String emeraldBalance,
                                   String coinBalance,
                                   String totalSteps,
                                   String coupons,
                                   String boxes,
                                   int additionalInformationId,
                                   String places,
                                   String score,
                                   String nationality,
                                   Integer membership,
                                   Timestamp lastMembershipActivationDate,
                                   Boolean isPartner,
                                   String reviewsId,
                                   String inbox,
                                   Timestamp createdAt,
                                   Timestamp modifiedAt) {
    }

    @GetMapping("/buyMembership")
    public Response buyMembership() {
        return response;
    }
    @PostMapping("/createNormalUser")
    public Response createNormalUserProfile(@RequestBody NewNormalProfileRequest request) {

        ExampleMatcher phoneNumberMatching = ExampleMatcher.matching()
                .withMatcher("phoneNumber", ExampleMatcher.GenericPropertyMatchers.ignoreCase());
        Example<ProfileModel> example = Example.<ProfileModel>of(new ProfileModel(request.phoneNumber()), phoneNumberMatching);
        boolean userExists = repository.exists(example);

        if(!userExists){
            ProfileModel profile = new ProfileModel();
            profile.setFirstName(request.firstName());
            profile.setEmail(request.email());
            profile.setLastName(request.lastName());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setSecretPassword(request.secretPassword());
            profile.setGender(request.gender());
            profile.setBirthday(request.birthday());
            profile.setLatitude(request.latitude());
            profile.setLongitude(request.longitude());
            profile.setMembership(0);
            profile.setBanned(false);
            profile.setBoosts("");
            profile.setCoinBalance("0");
            profile.setEmeraldBalance("0");
            profile.setBanDurationInSeconds((request.banDurationInSeconds()));
            profile.setCoupons("");
            profile.setPlaces("");
            profile.setPartner(false);
            profile.setImage(request.image());
            profile.setQrCode(request.email()+request.phoneNumber());
            String sK = (request.phoneNumber()+request.email()+LocalDateTime.now());
            String sc="";
            for (int i=0;i<sK.length();i++){
                char character = sK.charAt(i); // This gives the character 'a'
                sc=sc+Integer.toString((int) character);

            }
            profile.setSecretKey(sc);
            String str = (request.phoneNumber()+request.email()+LocalDateTime.now().toString());
            String tok="";
            for (int i=0;i<str.length();i++){
                tok=tok+ (String.valueOf(str.charAt(i)));
            }
            profile.setToken(tok);
            profile.setTotalSteps("0");
            profile.setScore("5");
            profile.setNationality(request.nationality());
            profile.setCreatedAt(request.createdAt());
            profile.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(profile);
            response.setMessage("user Added Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setObject(profile);
        }else {
            response.setMessage("user already exist");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }


    @PostMapping("/createAdditionalUserInformation")
    public Response createAdditionalUserInformation(@RequestBody AdditionalUserInformationRequest request) {

        ProfileAdditionalInformationModel profileAdditionalInformationModel = new ProfileAdditionalInformationModel();
        profileAdditionalInformationModel.setGoals(request.goals());
        profileAdditionalInformationModel.setHeight(request.height());
        profileAdditionalInformationModel.setHadProblems(request.hadProblems());
        profileAdditionalInformationModel.setWeight(request.weight());
        profileAdditionalInformationModel.setProblems(request.problems());

        profileAdditionalInformationRepository.save(profileAdditionalInformationModel);
        response.setMessage("profile additional information Added Successfully");
        response.setErrorCode(20000);
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(profileAdditionalInformationModel);

        return response;
    }






    /******************************************************************************************************************/



    record UpdateNormalProfileRequest(Integer id,
                                      String firstName,
                                      String lastName,
                                      String secretPassword,
                                      String image,
                                      Timestamp birthday,
                                      Double latitude,
                                      Double longitude,
                                      Timestamp modifiedAt) {
    }

    /****UPDATE NORMAL USER****/
    @PutMapping("/updateNormalUser")
    public Response updateNormalUserProfile(@RequestBody UpdateNormalProfileRequest request) {

        boolean userExists = repository.existsById(request.id());
        ProfileModel profile = new ProfileModel();
        Optional<ProfileModel> profileModel = repository.findById(request.id());
        if (profileModel.isPresent()){
            profile.setFirstName(request.firstName());
            profile.setLastName(request.lastName());
            profile.setSecretPassword(request.secretPassword());
            profile.setBirthday(request.birthday());
            profile.setLatitude(request.latitude());
            profile.setLongitude(request.longitude());
            profile.setModifiedAt(request.modifiedAt());
            //ban
            //message
            repository.save(profile);
            response.setMessage("user information updated Successfully");
            response.setErrorCode(20000);
            response.setThereIsAnError(false);
            response.setErrorType(ErrorResponseType.Nothing);
        }else {
            response.setMessage("user unfounded");
            response.setErrorCode(40000);
            response.setThereIsAnError(true);
            response.setErrorType(ErrorResponseType.Nothing);
        }
        return response;
    }
    @DeleteMapping("/deleteNormalUser{customerId}")
    public void deleteNormalUser(@PathVariable("customerId") int id) {
        repository.deleteById(id);
    }


}
