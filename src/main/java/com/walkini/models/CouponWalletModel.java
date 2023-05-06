package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "couponWallet")
public class CouponWalletModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "coupon_wallet_id_sequence",
            sequenceName = "coupon_wallet_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "coupon_wallet_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "couponId")
    private Integer couponId;
    @Column(name = "couponOwnedQuantity")
    private Integer couponOwnedQuantity;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public CouponWalletModel(Integer id,Integer userId, Integer couponId, Integer couponOwnedQuantity, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.couponId = couponId;
        this.userId=userId;
        this.couponOwnedQuantity = couponOwnedQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public CouponWalletModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public Integer getCouponOwnedQuantity() {
        return couponOwnedQuantity;
    }

    public void setCouponOwnedQuantity(Integer couponOwnedQuantity) {
        this.couponOwnedQuantity = couponOwnedQuantity;
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