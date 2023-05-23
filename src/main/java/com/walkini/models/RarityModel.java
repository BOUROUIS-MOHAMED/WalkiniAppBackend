package com.walkini.models;

import jakarta.persistence.*;


@Entity(name = "rarityModel")
public class RarityModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "rarity_id_sequence",
            sequenceName = "rarity_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rarity_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "rarityColor")
    private String rarityColor;
    @Column(name = "rarityPercent")
    private Double rarityPercent;

    private String createdAt;
    private String modifiedAt;

    public RarityModel() {
    }

    public RarityModel(Integer id, String name, String rarityColor, Double rarityPercent, String createdAt, String modifiedAt) {
        this.id = id;
        name = name;
        this.rarityColor = rarityColor;
        this.rarityPercent = rarityPercent;
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
        name = name;
    }

    public String getRarityColor() {
        return rarityColor;
    }

    public void setRarityColor(String rarityColor) {
        this.rarityColor = rarityColor;
    }

    public Double getRarityPercent() {
        return rarityPercent;
    }

    public void setRarityPercent(Double rarityPercent) {
        this.rarityPercent = rarityPercent;
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