package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "cartHistory")
public class CartHistoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="cart_history_id_sequence",
            sequenceName = "cart_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cart_history_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name="ownerId")
    private Integer userId;
    @Column(name="products")
    private String products;
    @Column(name="totalPrice")
    private String totalPrice;
    @Column(name="couponsUsed")
    private String couponsUsed;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public CartHistoryModel() {
    }

    public CartHistoryModel(Integer id, Integer userId, String products, String totalPrice, String couponsUsed, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.products = products;
        this.totalPrice = totalPrice;
        this.couponsUsed = couponsUsed;
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

    public void setUserId(Integer user) {
        this.userId = user;
    }

    public String getProducts() {
        return products;
    }

    public void setProducts(String products) {
        this.products = products;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCouponsUsed() {
        return couponsUsed;
    }

    public void setCouponsUsed(String couponsUsed) {
        this.couponsUsed = couponsUsed;
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
