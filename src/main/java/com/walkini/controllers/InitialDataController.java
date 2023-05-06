package com.walkini.controllers;


import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/initialData")
@CrossOrigin
public class InitialDataController {

    private final RarityRepository rarityRepository;
    private final ActionRepository actionRepository;
    private final BanRepository banRepository;
    private final CategoryRepository categoryRepository;
    private final ModifiedAttributeRepository modifiedAttributeRepository;
    private final BoostRepository boostRepository;
    private final CouponRepository couponRepository;
    private final ProfileTypeRepository profileTypeRepository;

    public InitialDataController(RarityRepository rarityRepository, ActionRepository actionRepository, BanRepository banRepository, CategoryRepository categoryRepository, ModifiedAttributeRepository modifiedAttributeRepository, BoostRepository boostRepository, CouponRepository couponRepository, ProfileTypeRepository profileTypeRepository) {
        this.rarityRepository = rarityRepository;
        this.actionRepository = actionRepository;
        this.banRepository = banRepository;
        this.categoryRepository = categoryRepository;
        this.modifiedAttributeRepository = modifiedAttributeRepository;
        this.boostRepository = boostRepository;
        this.couponRepository = couponRepository;
        this.profileTypeRepository = profileTypeRepository;
    }

@PostMapping("/initialAppData")
    public InitialDataModel initialData(){
        InitialDataModel initialDataModel= new InitialDataModel();

        List<RarityModel> rarityModels=rarityRepository.findAll();
        List<ActionModel> actionModels=actionRepository.findAll();
        List<BanModel> banModels=banRepository.findAll();
        List<ModifiedAttributeModel> modifiedAttributeRepositories=modifiedAttributeRepository.findAll();
        List<CategoryModel> categoryModels =categoryRepository.findAll();
        List<ProfileTypeModel> profileTypeModels=profileTypeRepository.findAll();
        List<CouponModel> couponModels=couponRepository.findAll();
        List<BoostsModel> boostsModels=boostRepository.findAll();

        initialDataModel.setActionModels(actionModels);
        initialDataModel.setBanModels(banModels);
        initialDataModel.setBoostModels(boostsModels);
        initialDataModel.setCategoryModels(categoryModels);
        initialDataModel.setCouponModels(couponModels);
        initialDataModel.setRarityModels(categoryModels);
        initialDataModel.setProfileTypeModels(profileTypeModels);
        initialDataModel.setModifiedAttributeModel(modifiedAttributeRepositories);
        return initialDataModel;
    }

}
