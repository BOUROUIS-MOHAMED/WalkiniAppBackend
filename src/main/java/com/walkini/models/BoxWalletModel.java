package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 



@Entity(name = "BoxWallet")
public class BoxWalletModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "box_wallet_id_sequence",
            sequenceName = "box_wallet_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "box_wallet_id_sequence"
    )
    @Column(name = "id")
    private Integer id;
    @Column(name = "userId")
    private Integer userId;
    @Column(name = "boxId")
    private Integer boxId;
    @Column(name = "boxOwnedQuantity")
    private Integer boxOwnedQuantity;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public BoxWalletModel() {
    }

    public BoxWalletModel(Integer id,Integer userId, Integer boxId, Integer boxOwnedQuantity, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.boxId = boxId;
        this.userId=userId;
        this.boxOwnedQuantity = boxOwnedQuantity;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    public Integer getBoxOwnedQuantity() {
        return boxOwnedQuantity;
    }

    public void setBoxOwnedQuantity(Integer boxOwnedQuantity) {
        this.boxOwnedQuantity = boxOwnedQuantity;
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