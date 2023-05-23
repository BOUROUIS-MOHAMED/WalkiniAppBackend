package com.walkini.controllers;


import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/initialData")
@CrossOrigin
public class InitialDataForMobileController {
    final ActionRepository actionRepository;
    final BadgeRepository badgeRepository;
    final BanRepository banRepository;
    final BoostRepository boostRepository;
    final BoxRepository boxRepository;
    final ChallengeRepository challengeRepository;
    final CharityCategoryRepository charityCategoryRepository;
    final CharityRepository charityRepository;
    final CouponRepository couponRepository;
    final MembershipTypeRepository membershipTypeRepository;
    final ModifiedAttributeRepository modifiedAttributeRepository;
    final NewsRepository newsRepository;
    final PlaceRepository placeRepository;
    final ProductCategoryRepository productCategoryRepository;
    final ProductRepository productRepository;
    final RarityRepository rarityRepository;
    final ReviewRepository reviewRepository;
    final WorkoutRepository workoutRepository;
    final WorkoutPartRepository workoutPartRepository;



    public InitialDataForMobileController(ActionRepository actionRepository, BadgeRepository badgeRepository, BanRepository banRepository, BoostRepository boostRepository, BoxRepository boxRepository, ChallengeRepository challengeRepository, CharityCategoryRepository charityCategoryRepository, CharityRepository charityRepository, CouponRepository couponRepository, MembershipTypeRepository membershipTypeRepository, ModifiedAttributeRepository modifiedAttributeRepository, NewsRepository newsRepository, PlaceRepository placeRepository, ProductCategoryRepository productCategoryRepository, ProductRepository productRepository, RarityRepository rarityRepository, ReviewRepository reviewRepository, WorkoutRepository workoutRepository, WorkoutPartRepository workoutPartRepository) {
        this.actionRepository = actionRepository;
        this.badgeRepository = badgeRepository;
        this.banRepository = banRepository;
        this.boostRepository = boostRepository;
        this.boxRepository = boxRepository;
        this.challengeRepository = challengeRepository;
        this.charityCategoryRepository = charityCategoryRepository;
        this.charityRepository = charityRepository;
        this.couponRepository = couponRepository;
        this.membershipTypeRepository = membershipTypeRepository;
        this.modifiedAttributeRepository = modifiedAttributeRepository;
        this.newsRepository = newsRepository;
        this.placeRepository = placeRepository;
        this.productCategoryRepository = productCategoryRepository;
        this.productRepository = productRepository;
        this.rarityRepository = rarityRepository;
        this.reviewRepository = reviewRepository;
        this.workoutRepository = workoutRepository;
        this.workoutPartRepository = workoutPartRepository;
    }


    @GetMapping("/initialAppData")
    public ResponseModel initialData() {
        InitialDataForMobileModel initialDataForMobileModel = new InitialDataForMobileModel();
        List<ActionModel> actionModels = actionRepository.findAll();
        List<BadgeModel> badgeModel = badgeRepository.findAll();
        List<BanModel> banModels = banRepository.findAll();
        List<BoostsModel> boostModels = boostRepository.findAll();
        List<BoxModel> boxModels = boxRepository.findAll();
        List<ChallengeModel> challengeModels = challengeRepository.findAll();
        List<CharityCategoryModel> charityCategoriesModels = charityCategoryRepository.findAll();
        List<CharityModel> charityModels = charityRepository.findAll();
        List<CouponModel> couponModels = couponRepository.findAll();
        List<MembershipTypeModel> membershipTypeModel = membershipTypeRepository.findAll();
        List<ModifiedAttributeModel> modifiedAttributeModel = modifiedAttributeRepository.findAll();
        List<NewsModel> newsModel = newsRepository.findAll();
        List<PlaceModel> placeModels = placeRepository.findAll();
        List<ProductCategoryModel> productCategoryModels = productCategoryRepository.findAll();
        List<ProductModel> productModel = productRepository.findAll();
        List<RarityModel> rarityModel = rarityRepository.findAll();
        List<ReviewModel> reviewModel = reviewRepository.findAll();
        List<WorkoutModel> workoutModels = workoutRepository.findAll();
        List<WorkoutPartModel> workoutPartModels = workoutPartRepository.findAll();
        initialDataForMobileModel.setActionModels(actionModels);
        initialDataForMobileModel.setBadgeModel(badgeModel);
        initialDataForMobileModel.setBanModels(banModels);
        initialDataForMobileModel.setBoostModels(boostModels);
        initialDataForMobileModel.setBoxModels(boxModels);
        initialDataForMobileModel.setChallengeModels(challengeModels);
        initialDataForMobileModel.setCharityModels(charityModels);
        initialDataForMobileModel.setCharityCategoriesModels(charityCategoriesModels);
        initialDataForMobileModel.setCouponModels(couponModels);
        initialDataForMobileModel.setMembershipTypeModel(membershipTypeModel);
        initialDataForMobileModel.setModifiedAttributeModel(modifiedAttributeModel);
        initialDataForMobileModel.setNewsModel(newsModel);
        initialDataForMobileModel.setPlaceModels(placeModels);
        initialDataForMobileModel.setProductCategoryModels(productCategoryModels);
        initialDataForMobileModel.setProductModel(productModel);
        initialDataForMobileModel.setRarityModel(rarityModel);
        initialDataForMobileModel.setReviewModel(reviewModel);
        initialDataForMobileModel.setWorkoutModels(workoutModels);
        initialDataForMobileModel.setWorkoutPartModels(workoutPartModels);
        ResponseModel response =new ResponseModel();
        response.setMessage(null);
        response.setErrorType(ErrorResponseType.DataAlreadyExist);
        response.setReturnedBoolean(true);
        response.setObject(initialDataForMobileModel);
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
        return response;
    }

    @GetMapping("/initialMainData")
    public ResponseModel initialUseWalletData(@RequestParam Integer id) {
        InitialMainDataModel initialMainDataModel = new InitialMainDataModel();
       List < PlaceModel > placesModel=placeRepository.findAll();
        List<BoxModel> boxModel=boxRepository.findAll();
        List<BoostsModel> boostModel=boostRepository.findAll();
        List<ChallengeModel> challengeModel=challengeRepository.findAll();
        List<CouponModel> couponModel=couponRepository.findAll();

        initialMainDataModel.setPlacesModel(placesModel);
        initialMainDataModel.setBoxModel(boxModel);
        initialMainDataModel.setBoostModel(boostModel);
        initialMainDataModel.setChallengeModel(challengeModel);
        initialMainDataModel.setCouponModel(couponModel);
        ResponseModel response =new ResponseModel();
        response.setMessage(null);
        response.setErrorType(ErrorResponseType.DataAlreadyExist);
        response.setReturnedBoolean(true);
        response.setObject(initialMainDataModel);
        response.setErrorCode("20000");
        response.setThereIsAnError(false);
        response.setReturnedInteger(null);
        response.setReturnedList(null);
        response.setReturnedString(null);
        response.setReturnedMultipartFile(null);
            return response;
        }

        record req(
                java.util.ArrayList<Object> banModels, ArrayList<Object> rarityModels,
                ArrayList<Object> modifiedAttributeModel, ArrayList<Object> productCategoryModel,
                ArrayList<Object> charityCategoryModel, ArrayList<Object> boostModels, ArrayList<Object> couponModels,
                ArrayList<Object> actionModels, ArrayList<Object> placeModels, ArrayList<Object> membershipModels,
                ArrayList<Object> boxModels, ArrayList<Object> badgeModel, ArrayList<Object> challengeModel,
                ArrayList<Object> productModel, ArrayList<Object> charityModel, ArrayList<Object> workoutModel,
                ArrayList<Object> errorResponseModel, Object basicModifiedAttributeModel) {
        }


        public void initialServerLunchData () {

            BadgeModel badge = new BadgeModel();
            badge.setModifiedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            badge.setBadgeDescription("This badge for all user with free membership");
            badge.setCreatedAt("creation date");
            badge.setModifiedAt("modification date");
            badge.setBadgeImage("https://firebasestorage.googleapis.com/v0/b/walkini-f6669.appspot.com/o/profileImages%2F94970082?alt=media&token=3d58b38f-c925-49e5-b96b-e60fd8fa3265");
            badge.setBadgeName("Free user membership badge");
            badge.setCreatedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            badgeRepository.save(badge);
            RarityModel rarityModel=new RarityModel();
            rarityModel.setRarityColor("#E0DCDC");
            rarityModel.setName("Common");
            rarityModel.setRarityPercent(0.7);
            rarityModel.setCreatedAt(LocalDateTime.now().toString());
            rarityModel.setModifiedAt(LocalDateTime.now().toString());
            rarityRepository.save(rarityModel);
            RarityModel rarityModel1=new RarityModel();
            rarityModel1.setRarityColor("#DAAC7E");
            rarityModel1.setName("Rare");
            rarityModel1.setRarityPercent(0.5);
            rarityModel1.setCreatedAt(LocalDateTime.now(). toString());
            rarityModel1.setModifiedAt(LocalDateTime.now().toString());
            rarityRepository.save(rarityModel1);

            RarityModel rarityModel2=new RarityModel();
            rarityModel2.setRarityColor("#EE5DDE");
            rarityModel2.setName("Epic");
            rarityModel2.setRarityPercent(0.3);
            rarityModel2.setCreatedAt(LocalDateTime.now().toString());
            rarityModel2.setModifiedAt(LocalDateTime.now().toString());
            rarityRepository.save(rarityModel2);
            RarityModel rarityModel3=new RarityModel();
            rarityModel3.setRarityColor("#F15F21");
            rarityModel3.setName("Legendary");
            rarityModel3.setRarityPercent(0.1);
            rarityModel3.setCreatedAt(LocalDateTime.now().toString());
            rarityModel3.setModifiedAt(LocalDateTime.now().toString());
            rarityRepository.save(rarityModel3);
            System.out.println(badge);


            ModifiedAttributeModel modifiedAttribute = new ModifiedAttributeModel();
            modifiedAttribute.setCreatedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            modifiedAttribute.setMaxBoxPerDay(5);
            modifiedAttribute.setMaxAskForConvertPerDay(1);
            modifiedAttribute.setName("free users");
            modifiedAttribute.setMaxStepsLimit(8000);
            modifiedAttribute.setMaxVisitPerDay(2);
            modifiedAttribute.setStepsMultiplayer(1.0);
            modifiedAttribute.setModifiedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            modifiedAttributeRepository.save(modifiedAttribute);

            MembershipTypeModel membership = new MembershipTypeModel();
            membership.setCreatedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            membership.setBadge(0);

            membership.setDescription("Free version membership");
            membership.setName("Free");
            membership.setPrice(0.0);
            membership.setModifiedAttribute(modifiedAttribute.getId());
            membership.setModifiedAt(String.valueOf(Timestamp.valueOf(LocalDateTime.now())));
            membershipTypeRepository.save(membership);

        }

    }
