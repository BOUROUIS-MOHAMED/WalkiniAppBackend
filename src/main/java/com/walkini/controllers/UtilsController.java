
package com.walkini.controllers;

import com.walkini.AppConstants;
import com.walkini.models.*;
import com.walkini.repositories.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(AppConstants.API_BASE_URL + "/utils")
@CrossOrigin
public class UtilsController {
    private final NormalUserRepository normalUserRepository;
    private final RarityRepository rarityRepository;

    private final BadgeRepository badgeRepository;

    private final BoostRepository boostRepository;

    private final CouponRepository couponRepository;

    private final PlaceRepository placeRepository;
    public UtilsController(NormalUserRepository normalUserRepository, RarityRepository rarityRepository, BadgeRepository badgeRepository, BoostRepository boostRepository, CouponRepository couponRepository, PlaceRepository placeRepository) {
        this.normalUserRepository = normalUserRepository;
        this.rarityRepository = rarityRepository;
        this.badgeRepository = badgeRepository;
        this.boostRepository = boostRepository;
        this.couponRepository = couponRepository;
        this.placeRepository = placeRepository;
    }


    ResponseModel response = new ResponseModel();



    public Double returnRarity(Integer id) {
        Optional<RarityModel> rarityModel=rarityRepository.findById(id);
        if (rarityModel.isPresent()){
            return rarityModel.get().getRarityPercent();
        }else {
            return 0.0;
        }
    }


    List<Integer> returnListOfIntegerFromString(String str) {
        List<Integer> list = new ArrayList<>();
            List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
            for (String s : myList
            ) {
                list.add(Integer.parseInt(s));
            }
            return list;
    }
    List<String> returnListOfStringsFromString(String str) {
        List<String> myList = new ArrayList<String>(Arrays.asList(str.split("---")));
        return myList;
    }
    List<BadgeModel> returnBadgesListFromListOfIds(List<Integer> integerList) {
        List<BadgeModel> list = new ArrayList<>();
        for (Integer integer:integerList
             ) {
            Optional<BadgeModel> model=badgeRepository.findById(integer);
            if (model.isPresent()){
              list.add(model.get());
            }
        }
        return list;
    }

    List<BoostsModel> returnBoostsListFromListOfIds(List<Integer> integerList) {
        List<BoostsModel> list = new ArrayList<>();
        for (Integer integer:integerList
        ) {
            Optional<BoostsModel> model=boostRepository.findById(integer);
            if (model.isPresent()){
                list.add(model.get());
            }
        }
        return list;
    }

    List<CouponModel> returnCouponListFromListOfIds(List<Integer> integerList) {
        List<CouponModel> list = new ArrayList<>();
        for (Integer integer:integerList
        ) {
            Optional<CouponModel> model=couponRepository.findById(integer);
            if (model.isPresent()){
                list.add(model.get());
            }
        }
        return list;
    }
    List<PlaceModel> returnPlacesListFromListOfIds(List<Integer> integerList) {
        List<PlaceModel> list = new ArrayList<>();
        for (Integer integer:integerList
        ) {
            Optional<PlaceModel> model=placeRepository.findById(integer);
            if (model.isPresent()){
                list.add(model.get());
            }
        }
        return list;
    }
}

