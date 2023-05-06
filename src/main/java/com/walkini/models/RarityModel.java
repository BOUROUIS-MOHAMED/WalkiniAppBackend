package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity(name = "rarityModel")
public class RarityModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="rarity_id_sequence",
            sequenceName = "rarity_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "rarity_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="Name")
    private String Name;
    @Column(name="rarityColor")
    private String rarityColor;
    @Column(name="rarityPercent")
    private String rarityPercent;
    @Column(name="rarityLevel")
    private String rarityLevel;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public RarityModel() {
    }

    public RarityModel(Integer id, String name, String rarityColor, String rarityPercent, String rarityLevel, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        Name = name;
        this.rarityColor = rarityColor;
        this.rarityPercent = rarityPercent;
        this.rarityLevel = rarityLevel;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public RarityModel(String name) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getRarityColor() {
        return rarityColor;
    }

    public void setRarityColor(String rarityColor) {
        this.rarityColor = rarityColor;
    }

    public String getRarityPercent() {
        return rarityPercent;
    }

    public void setRarityPercent(String rarityPercent) {
        this.rarityPercent = rarityPercent;
    }

    public String getRarityLevel() {
        return rarityLevel;
    }

    public void setRarityLevel(String rarityLevel) {
        this.rarityLevel = rarityLevel;
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
