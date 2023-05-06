package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "coupon")
public class CouponModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="coupon_id_sequence",
            sequenceName = "coupon_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name="couponName")
    private Integer couponName;
    @Column(name="couponOwner")
    private Integer couponOwner;
    @Column(name="couponForAllProducts")
    private Boolean couponForAllProducts;
    @Column(name="couponForAllBox")
    private Boolean couponForBox;
    @Column(name="couponReductionPercent")
    private Integer couponReductionPercent;
    @Column(name="couponQuantity")
    private String couponQuantity;
    @Column(name="couponLeftQuantity")
    private Integer couponLeftQuantity;
    @Column(name="couponAvailableDurationInSeconds")
    private Long couponAvailableDurationInSeconds;
    @Column(name="couponAvailable")
    private Boolean couponAvailable;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public CouponModel() {
    }

    public CouponModel(Integer id, Integer couponName, Integer couponOwner, Boolean couponForAllProducts, Boolean couponForBox, Integer couponReductionPercent, String couponQuantity, Integer couponLeftQuantity, Long couponAvailableDurationInSeconds, Boolean couponAvailable, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.couponName = couponName;
        this.couponOwner = couponOwner;
        this.couponForAllProducts = couponForAllProducts;
        this.couponForBox = couponForBox;
        this.couponReductionPercent = couponReductionPercent;
        this.couponQuantity = couponQuantity;
        this.couponLeftQuantity = couponLeftQuantity;
        this.couponAvailableDurationInSeconds = couponAvailableDurationInSeconds;
        this.couponAvailable = couponAvailable;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public CouponModel(Integer integer) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponName() {
        return couponName;
    }

    public void setCouponName(Integer couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponOwner() {
        return couponOwner;
    }

    public void setCouponOwner(Integer couponOwner) {
        this.couponOwner = couponOwner;
    }

    public Boolean getCouponForAllProducts() {
        return couponForAllProducts;
    }

    public void setCouponForAllProducts(Boolean couponForAllProducts) {
        this.couponForAllProducts = couponForAllProducts;
    }

    public Boolean getCouponForBox() {
        return couponForBox;
    }

    public void setCouponForBox(Boolean couponForBox) {
        this.couponForBox = couponForBox;
    }

    public Integer getCouponReductionPercent() {
        return couponReductionPercent;
    }

    public void setCouponReductionPercent(Integer couponReductionPercent) {
        this.couponReductionPercent = couponReductionPercent;
    }

    public String getCouponQuantity() {
        return couponQuantity;
    }

    public void setCouponQuantity(String couponQuantity) {
        this.couponQuantity = couponQuantity;
    }

    public Integer getCouponLeftQuantity() {
        return couponLeftQuantity;
    }

    public void setCouponLeftQuantity(Integer couponLeftQuantity) {
        this.couponLeftQuantity = couponLeftQuantity;
    }

    public Long getCouponAvailableDurationInSeconds() {
        return couponAvailableDurationInSeconds;
    }

    public void setCouponAvailableDuration(Long couponAvailableDurationInSeconds) {
        this.couponAvailableDurationInSeconds = couponAvailableDurationInSeconds;
    }

    public Boolean getCouponAvailable() {
        return couponAvailable;
    }

    public void setCouponAvailable(Boolean couponAvailable) {
        this.couponAvailable = couponAvailable;
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
