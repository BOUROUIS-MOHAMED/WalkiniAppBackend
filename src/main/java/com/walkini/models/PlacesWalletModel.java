package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "placesWallet")
public class PlacesWalletModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "places_wallet_id_sequence",
            sequenceName = "places_wallet_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "places_wallet_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "placesId")
    private Integer placesId;
    @Column(name = "placesOwnedQuantity")
    private Integer placesOwnedQuantity;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public PlacesWalletModel(Integer id,Integer userId, Integer placesId, Integer placesOwnedQuantity, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.placesId = placesId;
        this.userId=userId;
        this.placesOwnedQuantity = placesOwnedQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public PlacesWalletModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlacesId() {
        return placesId;
    }

    public void setPlacesId(Integer placesId) {
        this.placesId = placesId;
    }

    public Integer getPlacesOwnedQuantity() {
        return placesOwnedQuantity;
    }

    public void setPlacesOwnedQuantity(Integer placesOwnedQuantity) {
        this.placesOwnedQuantity = placesOwnedQuantity;
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