package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "box")
public class BoxModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="box_id_sequence",
            sequenceName = "box_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "box_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name="boxName")
    private String name;
    @Column(name="boxDescription")
    private String description;
    @Column(name="places")
    private String places;
    @Column(name="coins")
    private String coins;
    @Column(name="boosts")
    private String boosts;
    @Column(name="coupons")
    private String coupons;
    @Column(name="boxCoinPrice")
    private String coinPrice;
    @Column(name="boxEmeraldPrice")
    private String emeraldPrice;
    @Column(name="buyInEmerald")
    private boolean buyInEmerald;
    @Column(name="boxDurationInSeconds")
    private Long boxDurationInSeconds ;
    @Column(name="boxAvailableQuantity")
    private String availableQuantity;
    @Column(name="boxLeftQuantity")
    private String leftQuantity;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public BoxModel(String name) {
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

    public String getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(String coinPrice) {
        this.coinPrice = coinPrice;
    }

    public String getEmeraldPrice() {
        return emeraldPrice;
    }

    public void setEmeraldPrice(String emeraldPrice) {
        this.emeraldPrice = emeraldPrice;
    }

    public boolean isBuyInEmerald() {
        return buyInEmerald;
    }

    public void setBuyInEmerald(boolean buyInEmerald) {
        this.buyInEmerald = buyInEmerald;
    }

    public Long getBoxDurationInSeconds() {
        return boxDurationInSeconds;
    }

    public void setBoxDurationInSeconds(Long boxDurationInSeconds) {
        this.boxDurationInSeconds = boxDurationInSeconds;
    }

    public String getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(String availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public String getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(String leftQuantity) {
        this.leftQuantity = leftQuantity;
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

    public BoxModel() {
    }

    public BoxModel(Integer id, String name, String description, String places, String coins, String boosts, String coupons, String coinPrice, String emeraldPrice, boolean buyInEmerald, Long boxDurationInSeconds, String availableQuantity, String leftQuantity, Timestamp createdAt, Timestamp modifiedAt) {
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
        this.boxDurationInSeconds = boxDurationInSeconds;
        this.availableQuantity = availableQuantity;
        this.leftQuantity = leftQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
