package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "notification")
public class NotificationModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="notification_id_sequence",
            sequenceName = "notification_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="notificationImage")
    private String image;
    @Column(name="notificationSubtitle")
    private String subtitle;
    @Column(name="notificationAction")
    private Integer action;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public NotificationModel() {
    }

    public NotificationModel(Integer id, String name, String image, String subtitle, Integer action, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.subtitle = subtitle;
        this.action = action;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public NotificationModel(String name) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
