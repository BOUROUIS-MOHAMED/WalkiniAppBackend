package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "modifiedAttribute")
public class ModifiedAttributeModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="modified_Attribute_id_sequence",
            sequenceName = "modified_Attribute_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "modified_Attribute_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="maxStepsLimit")
    private Integer maxStepsLimit;
    @Column(name="stepsMultiplayer")
    private Double stepsMultiplayer;
    @Column(name="maxBoxPerDay")
    private Integer maxBoxPerDay;
    @Column(name="maxVisitPerDay")
    private String maxVisitPerDay;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ModifiedAttributeModel() {
    }

    public ModifiedAttributeModel(Integer id, String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, String maxVisitPerDay, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.maxStepsLimit = maxStepsLimit;
        this.stepsMultiplayer = stepsMultiplayer;
        this.maxBoxPerDay = maxBoxPerDay;
        this.maxVisitPerDay = maxVisitPerDay;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ModifiedAttributeModel(String name) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMaxStepsLimit() {
        return maxStepsLimit;
    }

    public void setMaxStepsLimit(Integer maxStepsLimit) {
        this.maxStepsLimit = maxStepsLimit;
    }

    public Double getStepsMultiplayer() {
        return stepsMultiplayer;
    }

    public void setStepsMultiplayer(Double stepsMultiplayer) {
        this.stepsMultiplayer = stepsMultiplayer;
    }

    public Integer getMaxBoxPerDay() {
        return maxBoxPerDay;
    }

    public void setMaxBoxPerDay(Integer maxBoxPerDay) {
        this.maxBoxPerDay = maxBoxPerDay;
    }

    public String getMaxVisitPerDay() {
        return maxVisitPerDay;
    }

    public void setMaxVisitPerDay(String maxVisitPerDay) {
        this.maxVisitPerDay = maxVisitPerDay;
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
