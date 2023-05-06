package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "profileType")
public class ProfileTypeModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="profile_type_id_sequence",
            sequenceName = "profile_type_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_type_id_sequence"
    )

    @Column(name="id")
    private Integer id;

    @Column(name="profileTypeName")
    private String profileTypeName;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ProfileTypeModel(Integer id, String profileTypeName, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.profileTypeName = profileTypeName;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ProfileTypeModel() {
    }

    public ProfileTypeModel(String s) {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfileTypeName() {
        return profileTypeName;
    }

    public void setProfileTypeName(String profileTypeName) {
        this.profileTypeName = profileTypeName;
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
