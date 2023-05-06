package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "boosts")
public class BoostsModel {
    @Id
    @SequenceGenerator(
allocationSize=1, 
            name="boosts_id_sequence",
            sequenceName = "boosts_id_sequence"
            )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "boosts_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="boostName")
    private String name;
    @Column(name="boostDescription")
    private String description;
    @Column(name="boostImage")
    private String image;
    @Column(name="boostDurationInSeconds")
    private Long boostDurationInSeconds;
    @Column(name = "boostPrice")
    private String price;
    @Column(name="boostModifiedAttributesList")
    private String modifiedAttributes;
    @Column(name="boostInBoxOrNot")
    private Boolean boostInBoxOrNot=false;
    @Column(name="boostRarity")
    private Integer boostRarity;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public BoostsModel() {
    }

    public BoostsModel(Integer id, String name, String description, String image, Long boostDurationInSeconds, String price, String modifiedAttributes, Boolean boostInBoxOrNot, Integer boostRarity, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.boostDurationInSeconds = boostDurationInSeconds;
        this.price = price;
        this.modifiedAttributes = modifiedAttributes;
        this.boostInBoxOrNot = boostInBoxOrNot;
        this.boostRarity = boostRarity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public BoostsModel(String name) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getBoostDurationInSeconds() {
        return boostDurationInSeconds;
    }

    public void setBoostDurationInSeconds(Long delay) {
        this.boostDurationInSeconds = delay;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModifiedAttributes() {
        return modifiedAttributes;
    }

    public void setModifiedAttributes(String modifiedAttributes) {
        this.modifiedAttributes = modifiedAttributes;
    }

    public boolean isBoostInBoxOrNot() {
        return boostInBoxOrNot;
    }

    public void setBoostInBoxOrNot(boolean boostInBoxOrNot) {
        this.boostInBoxOrNot = boostInBoxOrNot;
    }

    public Integer getBoostRarity() {
        return boostRarity;
    }

    public void setBoostRarity(Integer boostRarity) {
        this.boostRarity = boostRarity;
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
