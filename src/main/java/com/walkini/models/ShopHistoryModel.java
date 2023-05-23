package com.walkini.models;

import jakarta.persistence.*;




@Entity(name = "shopHistory")
public class ShopHistoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="shop_history_id_sequence",
            sequenceName = "shop_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shop_history_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="Buyer")
    private Integer buyer;
    @Column(name="logMessage")
    private String logMessage;
    @Column(name="productID")
    private Integer productID;
    @Column(name="buyingQuantity")
    private Integer buyingQuantity;
    @Column(name="Price")
    private String price;
    @Column(name="usedCouponIds")
    private Integer usedCoupons;
    private String createdAt;
    private String modifiedAt;

    public ShopHistoryModel() {
    }

    public ShopHistoryModel(Integer id, Integer buyer, String logMessage, Integer productID, Integer buyingQuantity, String price, Integer usedCoupons, String createdAt, String modifiedAt) {
        this.id = id;
        this.buyer = buyer;
        this.logMessage = logMessage;
        this.productID = productID;
        this.buyingQuantity = buyingQuantity;
        this.price = price;
        this.usedCoupons = usedCoupons;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getBuyingQuantity() {
        return buyingQuantity;
    }

    public void setBuyingQuantity(Integer buyingQuantity) {
        this.buyingQuantity = buyingQuantity;
    }



    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getUsedCoupons() {
        return usedCoupons;
    }

    public void setUsedCoupons(Integer usedCoupons) {
        this.usedCoupons = usedCoupons;
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
