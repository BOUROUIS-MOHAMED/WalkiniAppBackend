package com.walkini.models;

import jakarta.persistence.*;

 



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
    private String couponName;
    @Column(name="couponOwner")
    private Integer couponOwner;
    @Column(name="couponReductionPercent")
    private Double couponReductionPercent;
    @Column(name="couponQuantity")
    private Integer couponQuantity;
    @Column(name="couponLeftQuantity")
    private Integer couponLeftQuantity;
    @Column(name="couponAvailableDurationInSeconds")
    private Long couponAvailableDurationInSeconds;
    @Column(name="couponAvailable")
    private Boolean couponAvailable;
    @Column(name="couponOnlyForOwner")
    private Boolean couponOnlyForOwner=false;
    @Column(name="couponForBox")
    private Boolean couponForBox;
    private String createdAt;
    private String modifiedAt;

    public CouponModel() {
    }

    public CouponModel(Integer id, String couponName, Integer couponOwner, Double couponReductionPercent, Integer couponQuantity, Integer couponLeftQuantity, Long couponAvailableDurationInSeconds, Boolean couponAvailable, Boolean couponOnlyForOwner, Boolean couponForBox, String createdAt, String modifiedAt) {
        this.id = id;
        this.couponName = couponName;
        this.couponOwner = couponOwner;
        this.couponReductionPercent = couponReductionPercent;
        this.couponQuantity = couponQuantity;
        this.couponLeftQuantity = couponLeftQuantity;
        this.couponAvailableDurationInSeconds = couponAvailableDurationInSeconds;
        this.couponAvailable = couponAvailable;
        this.couponOnlyForOwner = couponOnlyForOwner;
        this.couponForBox = couponForBox;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName;
    }

    public Integer getCouponOwner() {
        return couponOwner;
    }

    public void setCouponOwner(Integer couponOwner) {
        this.couponOwner = couponOwner;
    }

    public Double getCouponReductionPercent() {
        return couponReductionPercent;
    }

    public void setCouponReductionPercent(Double couponReductionPercent) {
        this.couponReductionPercent = couponReductionPercent;
    }

    public Integer getCouponQuantity() {
        return couponQuantity;
    }

    public void setCouponQuantity(Integer couponQuantity) {
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

    public void setCouponAvailableDurationInSeconds(Long couponAvailableDurationInSeconds) {
        this.couponAvailableDurationInSeconds = couponAvailableDurationInSeconds;
    }

    public Boolean getCouponAvailable() {
        return couponAvailable;
    }

    public void setCouponAvailable(Boolean couponAvailable) {
        this.couponAvailable = couponAvailable;
    }

    public Boolean getCouponOnlyForOwner() {
        return couponOnlyForOwner;
    }

    public void setCouponOnlyForOwner(Boolean couponOnlyForOwner) {
        this.couponOnlyForOwner = couponOnlyForOwner;
    }

    public Boolean getCouponForBox() {
        return couponForBox;
    }

    public void setCouponForBox(Boolean couponForBox) {
        this.couponForBox = couponForBox;
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
