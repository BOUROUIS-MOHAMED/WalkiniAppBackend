package com.walkini.models;

import jakarta.persistence.*;




@Entity(name = "stepHistory")
public class StepHistoryModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "step_history_id_sequence",
            sequenceName = "step_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "step_history_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "user")
    private String user;
    @Column(name = "log")
    private String log;
    @Column(name = "stepsValue")
    private String stepsValue;
    @Column(name = "stepsDay")
    private String stepsDay;
    @Column(name = "status")
    private String status= StepsHistoryStatus.waiting.toString();
    private String createdAt;
    private String modifiedAt;

    public StepHistoryModel() {
    }

    public StepHistoryModel(Integer id, String user, String log, String stepsValue, String stepsDay, String status, String createdAt, String modifiedAt) {
        this.id = id;
        this.user = user;
        this.log = log;
        this.stepsValue = stepsValue;
        this.stepsDay = stepsDay;
        this.status = status;
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

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

