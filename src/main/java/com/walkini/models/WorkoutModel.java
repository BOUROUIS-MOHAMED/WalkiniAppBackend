package com.walkini.models;

import jakarta.persistence.*;





@Entity(name = "workout")
public class WorkoutModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "workout_id_sequence",
            sequenceName = "workout_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "workoutName")
    private String workoutName;
    @Column(name = "workoutMainImage")
    private String workoutMainImage;
    @Column(name = "workoutPartsId")
    private String workoutParts;
    @Column(name = "workoutIsFree")
    private Boolean workoutIsFree;
    @Column(name = "priceInEmerald")
    private Boolean priceInEmerald;
    @Column(name = "workoutPrice")
    private Double workoutPrice;
    @Column(name = "workoutDescription")
    private String workoutDescription;
    @Column(name = "workoutTimeInMinutes")
    private Double workoutTimeInMinutes;
    @Column(name = "workoutFocusedPart")
    private String workoutFocusedBodyPart;
    private String createdAt;
    private String modifiedAt;

    public WorkoutModel() {
    }

    public WorkoutModel(Integer id, String workoutName, String workoutMainImage, String workoutParts, Boolean workoutIsFree, Boolean priceInEmerald, Double workoutPrice, String workoutDescription, Double workoutTimeInMinutes, String workoutFocusedBodyPart, String createdAt, String modifiedAt) {
        this.id = id;
        this.workoutName = workoutName;
        this.workoutMainImage = workoutMainImage;
        this.workoutParts = workoutParts;
        this.workoutIsFree = workoutIsFree;
        this.priceInEmerald = priceInEmerald;
        this.workoutPrice = workoutPrice;
        this.workoutDescription = workoutDescription;
        this.workoutTimeInMinutes = workoutTimeInMinutes;
        this.workoutFocusedBodyPart = workoutFocusedBodyPart;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }

    public String getWorkoutMainImage() {
        return workoutMainImage;
    }

    public void setWorkoutMainImage(String workoutMainImage) {
        this.workoutMainImage = workoutMainImage;
    }

    public String getWorkoutParts() {
        return workoutParts;
    }

    public void setWorkoutParts(String workoutParts) {
        this.workoutParts = workoutParts;
    }

    public Boolean getWorkoutIsFree() {
        return workoutIsFree;
    }

    public void setWorkoutIsFree(Boolean workoutIsFree) {
        this.workoutIsFree = workoutIsFree;
    }

    public Boolean getPriceInEmerald() {
        return priceInEmerald;
    }

    public void setPriceInEmerald(Boolean priceInEmerald) {
        this.priceInEmerald = priceInEmerald;
    }

    public Double getWorkoutPrice() {
        return workoutPrice;
    }

    public void setWorkoutPrice(Double workoutPrice) {
        this.workoutPrice = workoutPrice;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public Double getWorkoutTimeInMinutes() {
        return workoutTimeInMinutes;
    }

    public void setWorkoutTimeInMinutes(Double workoutTimeInMinutes) {
        this.workoutTimeInMinutes = workoutTimeInMinutes;
    }

    public String getWorkoutFocusedBodyPart() {
        return workoutFocusedBodyPart;
    }

    public void setWorkoutFocusedBodyPart(String workoutFocusedBodyPart) {
        this.workoutFocusedBodyPart = workoutFocusedBodyPart;
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