package com.walkini.models;

import jakarta.persistence.*;

@Entity(name = "badge")
public class BadgeModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="badge_id_sequence",
            sequenceName = "badge_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "badge_id_sequence"


    )
    @Column(insertable=false, updatable=false)
    private Integer id;
    @Column(name="badgeName")
    private String badgeName;
    @Column(name="badgeDescription")
    private String badgeDescription;
    @Column(name="badgeImage")
    private String badgeImage;

    private String createdAt;
    private String modifiedAt;

    public BadgeModel(Integer id, String badgeName, String badgeDescription, String badgeImage, String createdAt, String modifiedAt) {
        this.id = id;
        this.badgeName = badgeName;
        this.badgeDescription = badgeDescription;
        this.badgeImage = badgeImage;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public BadgeModel() {
    }

    public BadgeModel(String badgeName, String badgeDescription, String badgeImage, String createdAt, String modifiedAt) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getBadgeDescription() {
        return badgeDescription;
    }

    public void setBadgeDescription(String badgeDescription) {
        this.badgeDescription = badgeDescription;
    }

    public String getBadgeImage() {
        return badgeImage;
    }

    public void setBadgeImage(String badgeImage) {
        this.badgeImage = badgeImage;
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

