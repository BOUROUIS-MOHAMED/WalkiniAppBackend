package com.walkini.models;

import jakarta.persistence.*;






@Entity(name = "challenge")
public class ChallengeModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "challenge_id_sequence",
            sequenceName = "challenge_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "challenge_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "image")
    private String image;
    @Column(name = "target")
    private String target;
    @Column(name = "challengeCoinPrizeId")
    private String coinPrize = null;

    private String createdAt;
    private String modifiedAt;

    public ChallengeModel() {
    }

    public ChallengeModel(Integer id, String name, String description, String image, String target, String coinPrize, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.target = target;
        this.coinPrize = coinPrize;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getCoinPrize() {
        return coinPrize;
    }

    public void setCoinPrize(String coinPrize) {
        this.coinPrize = coinPrize;
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