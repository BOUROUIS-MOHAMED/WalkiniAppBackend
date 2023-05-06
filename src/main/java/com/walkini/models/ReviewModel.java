package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity(name = "Review")
public class ReviewModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="review_id_sequence",
            sequenceName = "review_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_sequence"


    )
    @Column(insertable=false, updatable=false)
    private Integer id;

    @Column(name="userId")
    private int userId;
    @Column(name="reviewedProduct")
    private Integer reviewedProduct;
    @Column(name="reviewValue")
    private String reviewValue;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ReviewModel() {
    }

    public ReviewModel(Integer id, int userId, Integer reviewedProduct, String reviewValue, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.reviewedProduct = reviewedProduct;
        this.reviewValue = reviewValue;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ReviewModel(Integer integer, int i) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getReviewedProduct() {
        return reviewedProduct;
    }

    public void setReviewedProduct(Integer reviewedProduct) {
        this.reviewedProduct = reviewedProduct;
    }

    public String getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(String reviewValue) {
        this.reviewValue = reviewValue;
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
