package com.walkini.models;

import jakarta.persistence.*;




@Entity(name = "place")
public class PlaceModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "place_id_sequence",
            sequenceName = "place_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "place_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "placeName")
    private String name;
    @Column(name = "placeLatitude")
    private Double latitude;
    @Column(name = "placeLongitude")
    private Double longitude;
    @Column(name = "placeDescription")
    private String description;
    @Column(name = "rarity")
    private Integer rarity;
    @Column(name = "placeImage")
    private String image;
    @Column(name = "placeCoinPrize")
    private String coinPrize = null;
    @Column(name = "owner")
    private Integer owner;
    private String createdAt;
    private String modifiedAt;

    public PlaceModel() {
    }

    public PlaceModel(Integer id, String name, Double latitude, Double longitude, String description, Integer rarity, String image, String coinPrize, Integer owner, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
        this.rarity = rarity;
        this.image = image;
        this.coinPrize = coinPrize;
        this.owner = owner;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
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

    public String getCoinPrize() {
        return coinPrize;
    }

    public void setCoinPrize(String coinPrize) {
        this.coinPrize = coinPrize;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
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
