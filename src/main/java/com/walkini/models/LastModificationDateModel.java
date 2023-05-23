package com.walkini.models;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.Objects;


@Entity(name = "lastModificationDate")
public class LastModificationDateModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="last_modification_date_id_sequence",
            sequenceName = "last_modification_date_id_sequence"

    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "last_modification_date_id_sequence"
    )


    @Column(name="id")
    private Integer id;
    @Column(name="lastServerModificationDate")
    private String lastServerModificationDate= LocalDateTime.now().toString();
    @Column(name="lastShopItemsModificationDate")
    private String lastShopItemsModificationDate= LocalDateTime.now().toString();
    @Column(name="lastCharityModificationDate")
    private String lastCharityModificationDate= LocalDateTime.now().toString();
    @Column(name="lastWorkoutModificationDate")
    private String lastWorkoutModificationDate= LocalDateTime.now().toString();
    @Column(name="lastMainDataModificationDate")
    private String lastMainDataModificationDate= LocalDateTime.now().toString();

    public LastModificationDateModel() {
    }

    public LastModificationDateModel(Integer id, String lastServerModificationDate, String lastShopItemsModificationDate, String lastCharityModificationDate, String lastWorkoutModificationDate, String lastMainDataModificationDate) {
        this.id = id;
        this.lastServerModificationDate = lastServerModificationDate;
        this.lastShopItemsModificationDate = lastShopItemsModificationDate;
        this.lastCharityModificationDate = lastCharityModificationDate;
        this.lastWorkoutModificationDate = lastWorkoutModificationDate;
        this.lastMainDataModificationDate = lastMainDataModificationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastServerModificationDate() {
        return lastServerModificationDate;
    }

    public void setLastServerModificationDate(String lastServerModificationDate) {
        this.lastServerModificationDate = lastServerModificationDate;
    }

    public String getLastShopItemsModificationDate() {
        return lastShopItemsModificationDate;
    }

    public void setLastShopItemsModificationDate(String lastShopItemsModificationDate) {
        this.lastShopItemsModificationDate = lastShopItemsModificationDate;
    }

    public String getLastCharityModificationDate() {
        return lastCharityModificationDate;
    }

    public void setLastCharityModificationDate(String lastCharityModificationDate) {
        this.lastCharityModificationDate = lastCharityModificationDate;
    }

    public String getLastWorkoutModificationDate() {
        return lastWorkoutModificationDate;
    }

    public void setLastWorkoutModificationDate(String lastWorkoutModificationDate) {
        this.lastWorkoutModificationDate = lastWorkoutModificationDate;
    }

    public String getLastMainDataModificationDate() {
        return lastMainDataModificationDate;
    }

    public void setLastMainDataModificationDate(String lastMainDataModificationDate) {
        this.lastMainDataModificationDate = lastMainDataModificationDate;
    }
}


