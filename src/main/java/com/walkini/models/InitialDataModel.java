package com.walkini.models;

import org.springframework.web.bind.annotation.GetMapping;

public class InitialDataModel {

    Object ProfileTypeModels;

    Object banModels;

    Object rarityModels;

    Object ModifiedAttributeModel;

    Object CategoryModels;

    Object BoostModels;

    Object CouponModels;

    Object ActionModels;

    public InitialDataModel() {
    }

    public InitialDataModel(Object profileTypeModels, Object banModels, Object rarityModels, Object modifiedAttributeModel, Object categoryModels, Object boostModels, Object couponModels, Object actionModels) {
        ProfileTypeModels = profileTypeModels;
        this.banModels = banModels;
        this.rarityModels = rarityModels;
        ModifiedAttributeModel = modifiedAttributeModel;
        CategoryModels = categoryModels;
        BoostModels = boostModels;
        CouponModels = couponModels;
        ActionModels = actionModels;
    }

    public Object getProfileTypeModels() {
        return ProfileTypeModels;
    }

    public void setProfileTypeModels(Object profileTypeModels) {
        ProfileTypeModels = profileTypeModels;
    }

    public Object getBanModels() {
        return banModels;
    }

    public void setBanModels(Object banModels) {
        this.banModels = banModels;
    }

    public Object getRarityModels() {
        return rarityModels;
    }

    public void setRarityModels(Object rarityModels) {
        this.rarityModels = rarityModels;
    }

    public Object getModifiedAttributeModel() {
        return ModifiedAttributeModel;
    }

    public void setModifiedAttributeModel(Object modifiedAttributeModel) {
        ModifiedAttributeModel = modifiedAttributeModel;
    }

    public Object getCategoryModels() {
        return CategoryModels;
    }

    public void setCategoryModels(Object categoryModels) {
        CategoryModels = categoryModels;
    }

    public Object getBoostModels() {
        return BoostModels;
    }

    public void setBoostModels(Object boostModels) {
        BoostModels = boostModels;
    }

    public Object getCouponModels() {
        return CouponModels;
    }

    public void setCouponModels(Object couponModels) {
        CouponModels = couponModels;
    }

    public Object getActionModels() {
        return ActionModels;
    }

    public void setActionModels(Object actionModels) {
        ActionModels = actionModels;
    }
}





