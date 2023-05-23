package com.walkini.models;

import jakarta.persistence.*;

@Entity(name = "waitingCharityManagingList")
public class WaitingCharityManagingListModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "waiting_charity_managing_list_id_sequence",
            sequenceName = "waiting_charity_managing_list_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "waiting_charity_managing_list_id_sequence"
    )


    @Column(name = "id")
    private Integer id;
    @Column(name = "requestType")
    private requestType requestType;
    @Column(name = "modifiedCharityId")
    private Integer modifiedCharityId;
    @Column(name = "charityTitle")
    private String title;
    @Column(name = "charityImage")
    private String image;
    @Column(name = "charityDescription")
    private String description;
    @Column(name = "charityTarget")
    private String target;
    @Column(name = "charityScore")
    private String score;
    @Column(name = "inEmerald")
    private Boolean inEmerald;
    @Column(name = "charityCategory")
    private String category;
    @Column(name = "charityCurrentAmount")
    private String currentAmount;
    @Column(name = "charityLimitDay")
    private String limitDay;
    @Column(name = "charityLatitude")
    private Double latitude;
    @Column(name = "charityLongitude")
    private Double longitude;
    @Column(name = "owner")
    private Integer owner;
    private String createdAt;
    private String modifiedAt;

    public WaitingCharityManagingListModel() {
    }

    public WaitingCharityManagingListModel(Integer id, com.walkini.models.requestType requestType, Integer modifiedCharityId, String title, String image, String description, String target, String score, Boolean inEmerald, String category, String currentAmount, String limitDay, Double latitude, Double longitude, Integer owner, String createdAt, String modifiedAt) {
        this.id = id;
        this.requestType = requestType;
        this.modifiedCharityId = modifiedCharityId;
        this.title = title;
        this.image = image;
        this.description = description;
        this.target = target;
        this.score = score;
        this.inEmerald = inEmerald;
        this.category = category;
        this.currentAmount = currentAmount;
        this.limitDay = limitDay;
        this.latitude = latitude;
        this.longitude = longitude;
        this.owner = owner;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public com.walkini.models.requestType getRequestType() {
        return requestType;
    }

    public void setRequestType(com.walkini.models.requestType requestType) {
        this.requestType = requestType;
    }

    public Integer getModifiedCharityId() {
        return modifiedCharityId;
    }

    public void setModifiedCharityId(Integer modifiedCharityId) {
        this.modifiedCharityId = modifiedCharityId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Boolean getInEmerald() {
        return inEmerald;
    }

    public void setInEmerald(Boolean inEmerald) {
        this.inEmerald = inEmerald;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public String getLimitDay() {
        return limitDay;
    }

    public void setLimitDay(String limitDay) {
        this.limitDay = limitDay;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
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