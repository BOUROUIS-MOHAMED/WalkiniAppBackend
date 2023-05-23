package com.walkini.models;

import jakarta.persistence.*;
import java.util.Objects;


@Entity(name = "ban")
public class BanModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "ban_id_sequence",
            sequenceName = "ban_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ban_id_sequence"


    )
    @Column(insertable = false, updatable = false)
    private Integer id;

    @Column(name = "banName")
    private String name;
    @Column(name = "banDescription")
    private String description;
    @Column(name = "banReason")
    private String reason;
    @Column(name = "banDurationInSeconds")
    private Long banDurationInSeconds;
    @Column(name = "banMessage")
    private String message;
    private String createdAt;
    private String modifiedAt;

    public BanModel() {
    }

    public BanModel(Integer id, String name, String description, String reason, Long banDurationInSeconds, String message, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.reason = reason;
        this.banDurationInSeconds = banDurationInSeconds;
        this.message = message;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Long getBanDurationInSeconds() {
        return banDurationInSeconds;
    }

    public void setBanDurationInSeconds(Long banDurationInSeconds) {
        this.banDurationInSeconds = banDurationInSeconds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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