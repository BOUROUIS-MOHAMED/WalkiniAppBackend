package com.walkini.models;

import jakarta.persistence.*;





@Entity(name = "notification")
public class NotificationModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "notification_id_sequence",
            sequenceName = "notification_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "notification_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "notificationImage")
    private String image;
    @Column(name = "notificationHasImage")
    private Boolean notificationHasImage;
    @Column(name = "notificationSubtitle")
    private String subtitle;
    @Column(name = "notificationAction")
    private Integer action;
    private String createdAt;
    private String modifiedAt;

    public NotificationModel() {
    }

    public NotificationModel(Integer id, String name, String image, Boolean notificationHasImage, String subtitle, Integer action, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.notificationHasImage = notificationHasImage;
        this.subtitle = subtitle;
        this.action = action;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Boolean getNotificationHasImage() {
        return notificationHasImage;
    }

    public void setNotificationHasImage(Boolean notificationHasImage) {
        this.notificationHasImage = notificationHasImage;
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
