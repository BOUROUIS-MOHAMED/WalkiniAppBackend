package com.walkini.models;

import jakarta.persistence.*;

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
    private Integer maxVisitPerDay;
    @Column(name="maxAskForConvertPerDay")
    private Integer maxAskForConvertPerDay;
    private String createdAt;
    private String modifiedAt;

    public ModifiedAttributeModel() {
    }

    public ModifiedAttributeModel(Integer id, String name, Integer maxStepsLimit, Double stepsMultiplayer, Integer maxBoxPerDay, Integer maxVisitPerDay, Integer maxAskForConvertPerDay, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.maxStepsLimit = maxStepsLimit;
        this.stepsMultiplayer = stepsMultiplayer;
        this.maxBoxPerDay = maxBoxPerDay;
        this.maxVisitPerDay = maxVisitPerDay;
        this.maxAskForConvertPerDay = maxAskForConvertPerDay;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getMaxVisitPerDay() {
        return maxVisitPerDay;
    }

    public void setMaxVisitPerDay(Integer maxVisitPerDay) {
        this.maxVisitPerDay = maxVisitPerDay;
    }

    public Integer getMaxAskForConvertPerDay() {
        return maxAskForConvertPerDay;
    }

    public void setMaxAskForConvertPerDay(Integer maxAskForConvertPerDay) {
        this.maxAskForConvertPerDay = maxAskForConvertPerDay;
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
