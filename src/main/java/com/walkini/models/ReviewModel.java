package com.walkini.models;

import jakarta.persistence.*;



@Entity(name = "Review")
public class ReviewModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "review_id_sequence",
            sequenceName = "review_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "review_id_sequence"


    )
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(name = "userId")
    private Integer userId;
    @Column(name = "reviewedProduct")
    private Integer reviewedProduct;
    @Column(name = "reviewValue")
    private Double reviewValue;

    private String createdAt;
    private String modifiedAt;

    public ReviewModel() {
    }

    public ReviewModel(Integer id, Integer userId, Integer reviewedProduct, Double reviewValue, String createdAt, String modifiedAt) {
        this.id = id;
        this.userId = userId;
        this.reviewedProduct = reviewedProduct;
        this.reviewValue = reviewValue;
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

    public Integer getReviewedProduct() {
        return reviewedProduct;
    }

    public void setReviewedProduct(Integer reviewedProduct) {
        this.reviewedProduct = reviewedProduct;
    }

    public Double getReviewValue() {
        return reviewValue;
    }

    public void setReviewValue(Double reviewValue) {
        this.reviewValue = reviewValue;
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