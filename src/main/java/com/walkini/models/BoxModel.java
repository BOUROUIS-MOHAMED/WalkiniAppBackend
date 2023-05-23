package com.walkini.models;

import jakarta.persistence.*;


 



@Entity(name = "box")
public class BoxModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "box_id_sequence",
            sequenceName = "box_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "box_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "boxName")
    private String name;
    @Column(name = "boxDescription")
    private String description;
    @Column(name = "places")
    private String places;
    @Column(name = "coins")
    private String coins;
    @Column(name = "boosts")
    private String boosts;
    @Column(name = "coupons")
    private String coupons;
    @Column(name = "boxCoinPrice")
    private Double coinPrice;
    @Column(name = "boxEmeraldPrice")
    private Double emeraldPrice;
    @Column(name = "buyInEmerald")
    private Boolean buyInEmerald;
    @Column(name = "isActive")
    private Boolean isActive;
    @Column(name = "boxAvailableQuantity")
    private Integer availableQuantity;
    @Column(name = "boxLeftQuantity")
    private Integer leftQuantity;
    private String createdAt;
    private String modifiedAt;

    public BoxModel() {
    }

    public BoxModel(Integer id, String name, String description, String places, String coins, String boosts, String coupons, Double coinPrice, Double emeraldPrice, Boolean buyInEmerald, Boolean isActive, Integer availableQuantity, Integer leftQuantity, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.places = places;
        this.coins = coins;
        this.boosts = boosts;
        this.coupons = coupons;
        this.coinPrice = coinPrice;
        this.emeraldPrice = emeraldPrice;
        this.buyInEmerald = buyInEmerald;
        this.isActive = isActive;
        this.availableQuantity = availableQuantity;
        this.leftQuantity = leftQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getCoins() {
        return coins;
    }

    public void setCoins(String coins) {
        this.coins = coins;
    }

    public String getBoosts() {
        return boosts;
    }

    public void setBoosts(String boosts) {
        this.boosts = boosts;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }

    public Double getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(Double coinPrice) {
        this.coinPrice = coinPrice;
    }

    public Double getEmeraldPrice() {
        return emeraldPrice;
    }

    public void setEmeraldPrice(Double emeraldPrice) {
        this.emeraldPrice = emeraldPrice;
    }

    public Boolean getBuyInEmerald() {
        return buyInEmerald;
    }

    public void setBuyInEmerald(Boolean buyInEmerald) {
        this.buyInEmerald = buyInEmerald;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Integer availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Integer getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(Integer leftQuantity) {
        this.leftQuantity = leftQuantity;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(String modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
