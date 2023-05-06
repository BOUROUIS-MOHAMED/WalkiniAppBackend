package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity(name = "partnerWalletModel")
public class PartnerWalletModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="partner_wallet_id_sequence",
            sequenceName = "partner_wallet_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "partner_wallet_id_sequence"


    )
    @Column(insertable=false, updatable=false)
    private String id;
    
    @Column(name = "profileTypeName")
    private Integer profileType;
    @Column(name = "userId")
    private Integer userId;
    @Column(name="partnerMoney")
    private Double partnerMoney;
    @Column(name="partnerSoledProducts")
    private String soledProducts;
    @Column(name="partnerProducts")
    private String products;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public PartnerWalletModel() {
    }

    public PartnerWalletModel(String id, Integer profileType, Integer userId, Double partnerMoney, String soledProducts, String products, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.profileType = profileType;
        this.userId = userId;
        this.partnerMoney = partnerMoney;
        this.soledProducts = soledProducts;
        this.products = products;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public PartnerWalletModel(Integer integer) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getProfileType() {
        return profileType;
    }

    public void setProfileType(Integer profileType) {
        this.profileType = profileType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Double getPartnerMoney() {
        return partnerMoney;
    }

    public void setPartnerMoney(Double partnerMoney) {
        this.partnerMoney = partnerMoney;
    }

    public String getSoledProducts() {
        return soledProducts;
    }

    public void setSoledProducts(String soledProducts) {
        this.soledProducts = soledProducts;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Timestamp modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
