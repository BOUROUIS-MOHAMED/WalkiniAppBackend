package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "place")
public class PlaceModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="place_id_sequence",
            sequenceName = "place_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "place_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="placeName")
    private String name;
    @Column(name="placeLatitude")
    private double latitude;
    @Column(name="placeLongitude")
    private double longitude;
    @Column(name="placeDescription")
    private String description;
    @Column(name="rarity")
    private Integer rarity;
    @Column(name = "placeImage")
    private String image;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public PlaceModel() {
    }

    public PlaceModel(Integer id, String name, double latitude, double longitude, String description, Integer rarity, String image, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.rarity = rarity;
        this.image = image;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public PlaceModel(double latitude, double longitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
