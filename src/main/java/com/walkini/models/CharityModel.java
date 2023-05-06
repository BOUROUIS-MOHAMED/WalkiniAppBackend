package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Set;


@Entity(name = "charity")
public class CharityModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="charity_id_sequence",
            sequenceName = "charity_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "charity_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="charityTitle")
    private String title;
    @Column(name="charityImage")
    private String image;
    @Column(name="charityAmount")
    private String amount;
    @Column(name="charityDescription")
    private String description;
    @Column(name="charityCurrentAmount")
    private String currentAmount;
    @Column(name = "charityLimitTime")
    private Timestamp limitTime;
    @Column(name = "owner")
    private Integer owner;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public CharityModel() {
    }

    public CharityModel(Integer id, String title, String image, String amount, String description, String currentAmount, Timestamp limitTime, Integer owner, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.amount = amount;
        this.description = description;
        this.currentAmount = currentAmount;
        this.limitTime = limitTime;
        this.owner = owner;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public CharityModel(String title) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(String currentAmount) {
        this.currentAmount = currentAmount;
    }

    public Timestamp getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Timestamp limitTime) {
        this.limitTime = limitTime;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
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
