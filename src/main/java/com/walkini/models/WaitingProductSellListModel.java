package com.walkini.models;

import jakarta.persistence.*;

@Entity(name = "waitingProductSellList")
public class WaitingProductSellListModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "waiting_product_sell_list_id_sequence",
            sequenceName = "waiting_product_sell_list_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "waiting_product_sell_list_id_sequence"
    )

    @Column(insertable = false, updatable = false)
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "productId")
    private Integer productId;
    @Column(name = "buyingQuantity")
    private Integer buyingQuantity;
    @Column(name = "buyingPrice")
    private String buyingPrice;
    @Column(name = "couponId")
    private Integer couponId;
    @Column(name = "status")
    private ProductSellingStatus status;
    @Column(name = "message")
    private String message;

    private String createdAt;
    private String modifiedAt;

    public WaitingProductSellListModel() {
    }

    public WaitingProductSellListModel(Integer id, Integer userId, Integer productId, Integer buyingQuantity, String buyingPrice, Integer couponId, ProductSellingStatus status, String message, String createdAt, String modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.buyingQuantity = buyingQuantity;
        this.buyingPrice = buyingPrice;
        this.couponId = couponId;
        this.status = status;
        this.message = message;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBuyingQuantity() {
        return buyingQuantity;
    }

    public void setBuyingQuantity(Integer buyingQuantity) {
        this.buyingQuantity = buyingQuantity;
    }

    public String getBuyingPrice() {
        return buyingPrice;
    }

    public void setBuyingPrice(String buyingPrice) {
        this.buyingPrice = buyingPrice;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public ProductSellingStatus getStatus() {
        return status;
    }

    public void setStatus(ProductSellingStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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