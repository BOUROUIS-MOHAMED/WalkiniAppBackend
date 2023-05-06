package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 
import java.util.Objects;


@Entity(name = "ban")
public class BanModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="ban_id_sequence",
            sequenceName = "ban_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "ban_id_sequence"

           
    )
    @Column(insertable=false, updatable=false)
    private String id;

    @Column(name="banName")
    private String name;
    @Column(name="banDescription")
    private String description;
    @Column(name="banImage")
    private String image;
    @Column(name="banReason")
    private String reason;
    @Column(name="banDurationInSeconds")
    private Long banDurationInSeconds;
    @Column(name = "banMessage")
    private String message;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public BanModel() {
    }

    public BanModel(String id, String name, String description, String image, String reason, Long banDurationInSeconds, String message, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.reason = reason;
        this.banDurationInSeconds = banDurationInSeconds;
        this.message = message;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public BanModel(String name) {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BanModel banModel = (BanModel) o;
        return Objects.equals(id, banModel.id) && Objects.equals(name, banModel.name) && Objects.equals(description, banModel.description) && Objects.equals(image, banModel.image) && Objects.equals(reason, banModel.reason) && Objects.equals(banDurationInSeconds, banModel.banDurationInSeconds) && Objects.equals(message, banModel.message) && Objects.equals(createdAt, banModel.createdAt) && Objects.equals(modifiedAt, banModel.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, image, reason, banDurationInSeconds, message, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "BanModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                ", reason='" + reason + '\'' +
                ", banDuration=" + banDurationInSeconds +
                ", message='" + message + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}

