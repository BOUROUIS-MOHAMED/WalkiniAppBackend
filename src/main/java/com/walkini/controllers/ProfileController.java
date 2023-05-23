package com.walkini.controllers;


import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.AssociationRepository;
import com.walkini.repositories.NormalUserRepository;
import com.walkini.repositories.PartnerRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/profile")
@CrossOrigin
public class ProfileController {
    private final NormalUserRepository normalUserRepository;
    private final PartnerRepository partnerRepository;
    private final AssociationRepository associationRepository;


    public ProfileController(NormalUserRepository normalUserRepository, PartnerRepository partnerRepository, AssociationRepository associationRepository) {
        this.normalUserRepository = normalUserRepository;

        this.partnerRepository = partnerRepository;
        this.associationRepository = associationRepository;
    }

    record TestApiRequest(Integer id,
                          String string
    ) {
    }
    @GetMapping("/getPartnerById/{id}")
    public ResponseModel getPartnerById(@PathVariable Integer id) {
        Optional<PartnerModel> model=partnerRepository.findById(id);
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
    @GetMapping("/getAssociationById/{id}")
    public ResponseModel getAssociationById(@PathVariable Integer id) {
        Optional<AssociationModel> model=associationRepository.findById(id);
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
    @GetMapping("/getNormalUserById/{id}")
    public ResponseModel getNormalUserById(@PathVariable Integer id) {
        Optional<NormalUserModel> model=normalUserRepository.findById(id);
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


    @PostMapping("/testApi")
    public ResponseModel testPostApi() {

        response.setMessage("api tested Successfully");
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);


        return response;
    }

    @GetMapping("/testApi")
    public ResponseModel testGetApi(@RequestBody NormalUserModel normalUserModel) {
        response.setMessage("api tested Successfully");
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(normalUserModel);
        return response;
    }

    @PutMapping("/testApi")
    public ResponseModel testPutApi(@RequestBody NormalUserModel normalUserModel) {
        response.setMessage("api post tested Successfully");
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setErrorType(ErrorResponseType.Nothing);
        response.setObject(normalUserModel);
        return response;
    }

    @DeleteMapping("/testApi")
    public ResponseModel testDeleteApi(@RequestBody TestApiRequest request) {
        response.setMessage("api tested Successfully");
        response.setErrorCode("20000");
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

    @PostMapping("/loginNormalUser")
    public ResponseModel loginNormalUser(@RequestBody LoginRequest request) {
        System.out.println(request);

        List<NormalUserModel> profileModelChecker = normalUserRepository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
        if (!profileModelChecker.isEmpty()) {
            List<NormalUserModel> profileModelList = normalUserRepository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
            NormalUserModel profileModel = profileModelList.get(0);
            if ((profileModel.getSecretPassword()).toString().equals(request.password().toString())) {
                response.setErrorType(ErrorResponseType.Nothing);
                response.setMessage("user logged In");
                response.setErrorCode("20000");
                response.setThereIsAnError(false);
                response.setObject(normalUserRepository.findById(profileModel.getId()));
            } else {
                response.setErrorType(ErrorResponseType.NoDataFound);
                response.setMessage("password mismatching");
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setObject(null);
            }
        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("no user found with this information");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setObject(null);
        }

        return response;


    }
    @PostMapping("/loginPartner")
    public ResponseModel loginPartner(@RequestBody LoginRequest request) {
        System.out.println(request);
        List<PartnerModel> partnerModels = partnerRepository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
        if (!partnerModels.isEmpty()) {
            PartnerModel partner = partnerModels.get(0);
            if (partner.getActivated()){
                if ((partner.getSecretPassword()).equals(request.password())) {
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setMessage("user logged In");
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedBoolean(true);
                    response.setObject(partnerRepository.findById(partner.getId()));
                } else {
                    response.setErrorType(ErrorResponseType.NoDataFound);
                    response.setMessage("password mismatching");
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedBoolean(false);
                    response.setObject(null);
                }
            }else {
                response.setErrorType(ErrorResponseType.DataCorrupted);
                response.setMessage("This account is under construction, please wait until we contact you");
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedBoolean(false);
                response.setObject(null);

            }


        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("no user found with this information");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setObject(null);
        }

        return response;


    }
    @PostMapping("/loginAssociation")
    public ResponseModel loginAssociation(@RequestBody LoginRequest request) {
        System.out.println(request);
        List<AssociationModel> associationModels = associationRepository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
        if (!associationModels.isEmpty()) {
            AssociationModel association = associationModels.get(0);
            if (association.getActivated()){
                if ((association.getSecretPassword()).equals(request.password())) {
                    response.setErrorType(ErrorResponseType.Nothing);
                    response.setMessage("user logged In");
                    response.setErrorCode("20000");
                    response.setThereIsAnError(false);
                    response.setReturnedBoolean(true);
                    response.setObject(associationRepository.findById(association.getId()));
                } else {
                    response.setErrorType(ErrorResponseType.NoDataFound);
                    response.setMessage("password mismatching");
                    response.setErrorCode("40000");
                    response.setThereIsAnError(true);
                    response.setReturnedBoolean(false);
                    response.setObject(null);
                }
            }else {
                response.setErrorType(ErrorResponseType.DataCorrupted);
                response.setMessage("This account is under construction, please wait until we contact you");
                response.setErrorCode("40000");
                response.setThereIsAnError(true);
                response.setReturnedBoolean(false);
                response.setObject(null);

            }


        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setMessage("no user found with this information");
            response.setErrorCode("40000");
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
    public ResponseModel checkUserExist(@RequestBody CheckUserExistRequest request) {
        List<NormalUserModel> normalUserModelList = normalUserRepository.findByEmailOrPhoneNumber(request.email(), request.phoneNumber());
        if (!normalUserModelList.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(normalUserModelList.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
        }
        return response;


    }

    public ResponseModel checkUserExistById(Integer id) {
        Optional<NormalUserModel> normalUserModelList = normalUserRepository.findById(id);

        if (!normalUserModelList.isPresent()) {
            response.setMessage("true");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setErrorCode("20000");
            response.setObject(normalUserModelList.get());
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        } else {

            response.setMessage("false");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;


    }

    public ResponseModel checkUserExistByEmail(String checker) {
        List<NormalUserModel> normalUserModelList = normalUserRepository.findByEmail(checker);
        if (!normalUserModelList.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(normalUserModelList.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }

    public ResponseModel checkUserExistByEmailAndPhone(String phone, String email) {
        List<NormalUserModel> normalUserModelList = normalUserRepository.findByEmailOrPhoneNumber(email, phone);
        if (!normalUserModelList.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(normalUserModelList.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;
    }

    public ResponseModel checkUserExistByPhone(String checker) {
        List<NormalUserModel> normalUserModelList = normalUserRepository.findByPhoneNumber(checker);
        if (!normalUserModelList.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(normalUserModelList.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }


    public Boolean checkNormalUserExistByIds(Integer userId) {

        if (normalUserRepository.existsById(userId)) {
            return true;

        } else {
            return false;
        }

    }

    @GetMapping("/checkNormalUserExistById{userId}")
    public Boolean checkNormalUserExistById(@PathVariable Integer userId) {
        if (normalUserRepository.existsById(userId)) {
            return true;
        } else {
            return false;
        }

    }

    @GetMapping("/getAllNormalUsers")
    public List<NormalUserModel> getAllNormalUsers() {
        return normalUserRepository.findAll();
    }
    @GetMapping("/getAllPartners")
    public List<PartnerModel> getAllPartners() {
        return partnerRepository.findAll();
    }
    @GetMapping("/getAllAssociation")
    public List<AssociationModel> getAllAssociation() {
        return associationRepository.findAll();
    }


    ResponseModel response = new ResponseModel();


    record NewNormalProfileRequest(
            String firstName,
            String lastName,
            String phoneNumber,
            String email,
            String secretPassword,
            String image,
            String gender,
            String birthday,
            Double latitude,
            Double longitude,
            Boolean isBanned,
            Integer banInfo,
            String qrCode,
            String secretKey, String token, Double emeraldBalance, Double coinBalance,
            String shopHistory, String charityHistory, String totalSteps, String stepHistoryIds,
            String boosts, String coupons, String usedCoupons,
            String places, String visitedPlaces, String badges, String workouts,
            String completedWorkouts, String charityDonation, String challengesWallet,
            String score, String nationality, Integer membership,
            String lastMembershipActivationDate, String inbox, String seenInbox,
            String receivedNotification, Double heightInCm, Double weight, String goals,
            Boolean hadProblems, String problems, Boolean adBlocker, String phoneType,
            String logs, String createdAt, String modifiedAt) {
    }

    @GetMapping("/buyMembership")
    public ResponseModel buyMembership() {
        return response;
    }

    @PostMapping("/createNormalUser")
    public ResponseModel createNormalUserProfile(@RequestBody NewNormalProfileRequest request) {

        if (!checkUserExistByEmailAndPhone(request.phoneNumber(), request.email()).getReturnedBoolean()) {
            NormalUserModel profile = new NormalUserModel();
            profile.setBadges(request.badges());
            profile.setBanned(request.isBanned());
            profile.setBoosts(request.boosts());
            profile.setAdBlocker(request.adBlocker());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanInfo(request.banInfo());
            profile.setCoupons(request.coupons());

            profile.setEmail(request.email());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setMembership(request.membership());
            profile.setGender(request.gender());
            profile.setImage(request.image());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setPlaces(request.places());
            profile.setBirthday(request.birthday());
            profile.setWorkouts(request.workouts());
            profile.setWeight(request.weight());
            profile.setTotalSteps(request.totalSteps());
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPhoneType(request.phoneType());
            profile.setNationality(request.nationality());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setLastName(request.lastName());
            profile.setLastMembershipActivationDate(request.lastMembershipActivationDate());
            profile.setInbox(request.inbox());
            profile.setHeightInCm(request.heightInCm());
            profile.setGoals(request.goals());
            profile.setFirstName(request.firstName());
            profile.setCreatedAt(request.createdAt());
            profile.setCompletedWorkouts(request.completedWorkouts());
            profile.setQrCode(request.email().concat(request.phoneNumber()));
            String sK = (request.phoneNumber() + request.email() + LocalDateTime.now());
            String sc = "";
            for (int i = 0; i < sK.length(); i++) {
                char character = sK.charAt(i);
                sc = sc + Integer.toString((int) character);
            }
            profile.setSecretKey(sc);
            String str = (request.phoneNumber() + request.email() + LocalDateTime.now().toString());
            String tok = "";
            for (int i = 0; i < str.length(); i++) {
                tok = tok + (String.valueOf(str.charAt(i)));
            }

            profile.setToken(tok);
            //ban
            //message
            normalUserRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("user created successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.DataCorrupted);
            response.setMessage("user already exist");
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


    record UpdateNormalProfileRequest(Integer id,
                                      String firstName,
                                      String lastName,
                                      String phoneNumber,
                                      String email,
                                      String secretPassword,
                                      String image,
                                      String gender,
                                      String birthday,
                                      Double latitude,
                                      Double longitude,
                                      Boolean isBanned,
                                      Integer banInfo,
                                      String qrCode,
                                      String secretKey, String token, Double emeraldBalance, Double coinBalance,
                                      String shopHistory, String charityHistory, String totalSteps,
                                      String stepHistoryIds,
                                      String boosts, String coupons, String usedCoupons,
                                      String places, String visitedPlaces, String badges, String workouts,
                                      String completedWorkouts, String charityDonation, String challengesWallet,
                                      String score, String nationality, Integer membership,
                                      String lastMembershipActivationDate, String inbox, String seenInbox,
                                      String receivedNotification, Double heightInCm, Double weight, String goals,
                                      Boolean hadProblems, String problems, Boolean adBlocker, String phoneType,
                                      String logs, String createdAt, String modifiedAt) {
    }

    /****UPDATE NORMAL USER****/
    @PutMapping("/updateNormalUser")
    public ResponseModel updateNormalUserProfile(@RequestBody UpdateNormalProfileRequest request) {

        Optional<NormalUserModel> profileModel = normalUserRepository.findById(request.id());
        if (profileModel.isPresent()) {
            NormalUserModel profile = profileModel.get();
            profile.setBadges(request.badges());
            profile.setBanned(request.isBanned());
            profile.setBoosts(request.boosts());
            profile.setAdBlocker(request.adBlocker());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanInfo(request.banInfo());
            profile.setCoupons(request.coupons());

            profile.setEmail(request.email());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setMembership(request.membership());
            profile.setGender(request.gender());
            profile.setImage(request.image());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setPlaces(request.places());
            profile.setBirthday(request.birthday());
            profile.setWorkouts(request.workouts());
            profile.setWeight(request.weight());
            profile.setTotalSteps(request.totalSteps());
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPhoneType(request.phoneType());
            profile.setNationality(request.nationality());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setLastName(request.lastName());
            profile.setLastMembershipActivationDate(request.lastMembershipActivationDate());
            profile.setInbox(request.inbox());
            profile.setHeightInCm(request.heightInCm());
            profile.setGoals(request.goals());
            profile.setFirstName(request.firstName());
            profile.setCreatedAt(request.createdAt());
            profile.setCompletedWorkouts(request.completedWorkouts());
            //ban
            //message
            normalUserRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("user updated successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setMessage("user unfounded");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }

    @DeleteMapping("/deleteNormalUser{customerId}")
    public ResponseModel deleteNormalUser(@PathVariable("customerId") String id) {
        int ID = Integer.parseInt(id);
        if (normalUserRepository.existsById(ID)) {
            normalUserRepository.deleteById(ID);
            response.setMessage("user deleted Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("user unfounded with this id");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
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


    //PartnerProfile


    record NewPartnerRequest(
            Integer id, String name, String phoneNumber, String email, String secretPassword, String image,
            Double latitude, Double longitude, Boolean isBanned, Integer banInfo, String qrCode, String secretKey,
            String token, Double emeraldBalance, Double coinBalance, Double moneyBalance, String soledProducts,
            String score, String nationality, Boolean premium, String premiumActivationDate, String inbox,
            String seenInbox, String receivedNotification, String logs, String createdAt, String modifiedAt) {
    }

    public ResponseModel checkPartnerExistById(Integer id) {
        Optional<PartnerModel> partnerModel = partnerRepository.findById(id);

        if (!partnerModel.isPresent()) {
            response.setMessage("true");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setErrorCode("20000");
            response.setObject(partnerModel.get());
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        } else {

            response.setMessage("false");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;


    }

    public ResponseModel checkPartnerExistByEmail(String checker) {
        List<PartnerModel> partnerModels = partnerRepository.findByEmail(checker);
        if (!partnerModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(partnerModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }

    public ResponseModel checkPartnerExistByEmailOrPhone(String phone, String email) {
        List<PartnerModel> partnerModels = partnerRepository.findByEmailOrPhoneNumber(email, phone);
        if (!partnerModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(partnerModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;
    }

    public ResponseModel checkPartnerExistByPhone(String checker) {
        List<PartnerModel> partnerModels = partnerRepository.findByPhoneNumber(checker);
        if (!partnerModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(partnerModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }

    @PostMapping("/createPartner")
    public ResponseModel creatPartnerProfile(@RequestBody NewPartnerRequest request) {
        if (!checkPartnerExistByEmailOrPhone(request.phoneNumber(), request.email()).getReturnedBoolean()) {
            PartnerModel profile = new PartnerModel();
            profile.setSoledProducts(request.soledProducts());
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setSecretKey(request.secretKey());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPremiumActivationDate(request.premiumActivationDate());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setNationality(request.nationality());
            profile.setName(request.name());
            profile.setMoneyBalance(request.moneyBalance());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setInbox(request.inbox());
            profile.setImage(request.image());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setEmail(request.email());
            profile.setCreatedAt(request.createdAt());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanned(request.isBanned());
            profile.setBanInfo(request.banInfo());
            profile.setPremium(request.premium());
            profile.setActivated(false);
            profile.setQrCode(request.email().concat(request.phoneNumber()));
            String sK = (request.phoneNumber() + request.email() + LocalDateTime.now());
            String sc = "";
            for (int i = 0; i < sK.length(); i++) {
                char character = sK.charAt(i);
                sc = sc + Integer.toString((int) character);
            }
            profile.setSecretKey(sc);
            String str = (request.phoneNumber() + request.email() + LocalDateTime.now().toString());
            String tok = "";
            for (int i = 0; i < str.length(); i++) {
                tok = tok + (String.valueOf(str.charAt(i)));
            }

            profile.setToken(tok);
            //ban
            //message
            partnerRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("partner created successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.DataCorrupted);
            response.setMessage("partner already exist");
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


    record UpdatePartnerRequest(Integer id, String name, String phoneNumber, String email, String secretPassword,
                                String image,
                                Double latitude, Double longitude, Boolean isBanned, Integer banInfo, String qrCode,
                                String secretKey,
                                String token, Double emeraldBalance, Double coinBalance, Double moneyBalance,
                                String soledProducts,
                                String score, String nationality, Boolean premium, String premiumActivationDate,
                                String inbox,
                                String seenInbox, String receivedNotification, String logs, String createdAt,
                                String modifiedAt) {
    }

    /****UPDATE NORMAL USER****/
    @PutMapping("/updatePartner")
    public ResponseModel updatPartnerProfile(@RequestBody UpdatePartnerRequest request) {

        Optional<PartnerModel> partnerModel = partnerRepository.findById(request.id());
        if (partnerModel.isPresent()) {
            PartnerModel profile = partnerModel.get();
            profile.setSoledProducts(request.soledProducts());
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setSecretKey(request.secretKey());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPremiumActivationDate(request.premiumActivationDate());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setNationality(request.nationality());
            profile.setName(request.name());
            profile.setMoneyBalance(request.moneyBalance());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setInbox(request.inbox());
            profile.setImage(request.image());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setEmail(request.email());
            profile.setCreatedAt(request.createdAt());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanned(request.isBanned());
            profile.setBanInfo(request.banInfo());
            profile.setPremium(request.premium());

            //ban
            //message
            partnerRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("partner updated successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setMessage("partner unfounded");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }

    @DeleteMapping("/deletePartner{id}")
    public ResponseModel deletePartner(@PathVariable("id") Integer id) {

        if (partnerRepository.existsById(id)) {
            partnerRepository.deleteById(id);
            response.setMessage("partner deleted Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("partner unfounded with this id");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
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
    @PutMapping("/activatePartnerAccount{id}")
    public ResponseModel activatePartnerAccount(@PathVariable("id") Integer id) {
Optional<PartnerModel> partnerModel=partnerRepository.findById(id);
        if (partnerModel.isPresent()) {
            PartnerModel partner=partnerModel.get();
            partner.setActivated(true);
            partnerRepository.save(partner);
            response.setMessage("partner activated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("partner unfounded with this id");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
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


//Association Profile


    record NewAssociationRequest(Integer id, String name, String phoneNumber, String email, String secretPassword,
                                 String image, String description, Double latitude, Double longitude, Boolean isBanned,
                                 Integer banInfo, String secretKey, String token, Double emeraldBalance,
                                 Double coinBalance, Double moneyBalance, String badges, String score,
                                 String nationality, Boolean premium, String premiumActivationDate, String inbox,
                                 String seenInbox, String receivedNotification, String logs, String createdAt,
                                 String modifiedAt) {

    }

    public ResponseModel checkAssociationExistById(Integer id) {
        Optional<AssociationModel> associationModel = associationRepository.findById(id);

        if (!associationModel.isPresent()) {
            response.setMessage("true");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setErrorCode("20000");
            response.setObject(associationModel.get());
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        } else {

            response.setMessage("false");
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setObject(null);
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
            response.setThereIsAnError(false);
        }
        return response;


    }

    public ResponseModel checkAssociationExistByEmail(String checker) {
        List<AssociationModel> associationModels = associationRepository.findByEmail(checker);
        if (!associationModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(associationModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }

    public ResponseModel checkAssociationExistByEmailOrPhone(String phone, String email) {
        List<AssociationModel> associationModels = associationRepository.findByEmailOrPhoneNumber(email, phone);
        if (!associationModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(associationModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;
    }

    public ResponseModel checkAssociationExistByPhone(String checker) {
        List<AssociationModel> associationModels = associationRepository.findByPhoneNumber(checker);
        if (!associationModels.isEmpty()) {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(associationModels.get(0));
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        } else {
            response.setErrorType(ErrorResponseType.Nothing);
            response.setMessage("false");
            response.setReturnedBoolean(false);
            response.setErrorCode("40000");
            response.setThereIsAnError(false);
            response.setObject(null);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);

        }
        return response;


    }

    @PostMapping("/createAssociation")
    public ResponseModel creatAssociationProfile(@RequestBody NewAssociationRequest request) {
        if (!checkAssociationExistByEmailOrPhone(request.phoneNumber(), request.email()).getReturnedBoolean()) {
            AssociationModel profile = new AssociationModel();
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setSecretKey(request.secretKey());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPremiumActivationDate(request.premiumActivationDate());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setNationality(request.nationality());
            profile.setName(request.name());
            profile.setMoneyBalance(request.moneyBalance());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setInbox(request.inbox());
            profile.setImage(request.image());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setEmail(request.email());
            profile.setCreatedAt(request.createdAt());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanned(request.isBanned());
            profile.setBanInfo(request.banInfo());
            profile.setPremium(request.premium());
            profile.setDescription(request.description());
            profile.setBadges(request.badges());
            profile.setActivated(false);
            String sK = (request.phoneNumber() + request.email() + LocalDateTime.now());
            String sc = "";
            for (int i = 0; i < sK.length(); i++) {
                char character = sK.charAt(i);
                sc = sc + Integer.toString((int) character);
            }
            profile.setSecretKey(sc);
            String str = (request.phoneNumber() + request.email() + LocalDateTime.now().toString());
            String tok = "";
            for (int i = 0; i < str.length(); i++) {
                tok = tok + (String.valueOf(str.charAt(i)));
            }

            profile.setToken(tok);
            //ban
            //message
            associationRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("Association created successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.DataCorrupted);
            response.setMessage("Association already exist");
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


    record UpdateAssociationRequest(Integer id, String name, String phoneNumber, String email, String secretPassword,
                                    String image, String description, Double latitude, Double longitude, Boolean isBanned,
                                    Integer banInfo, String secretKey, String token, Double emeraldBalance,
                                    Double coinBalance, Double moneyBalance, String badges, String score,
                                    String nationality, Boolean premium, String premiumActivationDate, String inbox,
                                    String seenInbox, String receivedNotification, String logs, String createdAt,
                                    String modifiedAt) {
    }

    /****UPDATE NORMAL USER****/
    @PutMapping("/updateAssociation")
    public ResponseModel updateAssociationProfile(@RequestBody UpdateAssociationRequest request) {

        Optional<AssociationModel> associationModel = associationRepository.findById(request.id());
        if (associationModel.isPresent()) {
            AssociationModel profile = associationModel.get();
            profile.setSeenInbox(request.seenInbox());
            profile.setSecretPassword(request.secretPassword());
            profile.setSecretKey(request.secretKey());
            profile.setScore(request.score());
            profile.setReceivedNotification(request.receivedNotification());
            profile.setPremiumActivationDate(request.premiumActivationDate());
            profile.setPhoneNumber(request.phoneNumber());
            profile.setNationality(request.nationality());
            profile.setName(request.name());
            profile.setMoneyBalance(request.moneyBalance());
            profile.setModifiedAt(request.modifiedAt());
            profile.setLongitude(request.longitude());
            profile.setLogs(request.logs());
            profile.setLatitude(request.latitude());
            profile.setInbox(request.inbox());
            profile.setImage(request.image());
            profile.setEmeraldBalance(request.emeraldBalance());
            profile.setEmail(request.email());
            profile.setCreatedAt(request.createdAt());
            profile.setCoinBalance(request.coinBalance());
            profile.setBanned(request.isBanned());
            profile.setBanInfo(request.banInfo());
            profile.setPremium(request.premium());
            profile.setDescription(request.description());
            profile.setBadges(request.badges());
            //ban
            //message
            associationRepository.save(profile);
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(profile);
            response.setMessage("Association updated successfully");
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(profile.getId());
            response.setReturnedList(null);
            response.setReturnedString(profile.getToken());
            response.setReturnedMultipartFile(null);
        } else {
            response.setErrorType(ErrorResponseType.NoDataFound);
            response.setReturnedBoolean(false);
            response.setObject(null);
            response.setMessage("Association unfounded");
            response.setErrorCode("40000");
            response.setThereIsAnError(true);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        }
        return response;
    }

    @DeleteMapping("/deleteAssociation{id}")
    public ResponseModel deleteAssociation(@PathVariable("id") Integer id) {

        if (partnerRepository.existsById(id)) {
            partnerRepository.deleteById(id);
            response.setMessage("Association deleted Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("Association unfounded with this id");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
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
    @PutMapping("/activateAssociationAccount{id}")
    public ResponseModel activateAssociationAccount(@PathVariable("id") Integer id) {
        Optional<AssociationModel> associationModel=associationRepository.findById(id);
        if (associationModel.isPresent()) {
            AssociationModel association=associationModel.get();
            association.setActivated(true);
            associationRepository.save(association);
            response.setMessage("Association activated Successfully");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
            response.setObject(null);
            response.setErrorCode("20000");
            response.setThereIsAnError(false);
            response.setReturnedInteger(null);
            response.setReturnedList(null);
            response.setReturnedString(null);
            response.setReturnedMultipartFile(null);
        } else {
            response.setMessage("Association unfounded with this id");
            response.setErrorType(ErrorResponseType.Nothing);
            response.setReturnedBoolean(true);
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
