package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "stepHistory")
public class StepHistoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="step_history_id_sequence",
            sequenceName = "step_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "step_history_id_sequence"
    )
    @Column(name="id")
    private Integer id;

    @Column(name="user")
    private String user;
    @Column(name="description")
    private String description;
    @Column(name="stepsValue")
    private String stepsValue;
    @Column(name="stepsDay")
    private String stepsDay;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public StepHistoryModel() {
    }

    public StepHistoryModel(Integer id, String user, String description, String stepsValue, String stepsDay, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.stepsValue = stepsValue;
        this.stepsDay = stepsDay;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStepsValue() {
        return stepsValue;
    }

    public void setStepsValue(String stepsValue) {
        this.stepsValue = stepsValue;
    }

    public String getStepsDay() {
        return stepsDay;
    }

    public void setStepsDay(String stepsDay) {
        this.stepsDay = stepsDay;
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
