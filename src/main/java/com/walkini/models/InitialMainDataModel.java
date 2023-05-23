package com.walkini.models;

import java.util.List;

public class InitialMainDataModel {

    List<PlaceModel> PlacesModel;
    List<BoxModel> BoxModel;
    List<BoostsModel> BoostModel;
    List<ChallengeModel> ChallengeModel;
    List<CouponModel> CouponModel;





    public InitialMainDataModel() {
    }

    public InitialMainDataModel(List<PlaceModel> placesModel, List<com.walkini.models.BoxModel> boxModel, List<BoostsModel> boostModel, List<com.walkini.models.ChallengeModel> challengeModel, List<com.walkini.models.CouponModel> couponModel) {
        PlacesModel = placesModel;
        BoxModel = boxModel;
        BoostModel = boostModel;
        ChallengeModel = challengeModel;
        CouponModel = couponModel;
    }

    public List<PlaceModel> getPlacesModel() {
        return PlacesModel;
    }

    public void setPlacesModel(List<PlaceModel> placesModel) {
        PlacesModel = placesModel;
    }

    public List<com.walkini.models.BoxModel> getBoxModel() {
        return BoxModel;
    }

    public void setBoxModel(List<com.walkini.models.BoxModel> boxModel) {
        BoxModel = boxModel;
    }

    public List<BoostsModel> getBoostModel() {
        return BoostModel;
    }

    public void setBoostModel(List<BoostsModel> boostModel) {
        BoostModel = boostModel;
    }

    public List<com.walkini.models.ChallengeModel> getChallengeModel() {
        return ChallengeModel;
    }

    public void setChallengeModel(List<com.walkini.models.ChallengeModel> challengeModel) {
        ChallengeModel = challengeModel;
    }

    public List<com.walkini.models.CouponModel> getCouponModel() {
        return CouponModel;
    }

    public void setCouponModel(List<com.walkini.models.CouponModel> couponModel) {
        CouponModel = couponModel;
    }
}
