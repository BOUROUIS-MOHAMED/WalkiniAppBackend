package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 

@Entity(name = "membership")
public class MembershipTypeModel {
    @Id
    @SequenceGenerator(
    allocationSize=1,
            name="membership_type_id_sequence",
            sequenceName = "membership_type_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_type_id_sequence"
    )


    @Column
    private  Integer id;
    @Column(name="membershipName")
    private String name;
    @Column(name="membershipDescription")
    private String description;
    @Column(name="membershipColor")
    private String color;
    @Column(name="membershipPrice")
    private String price;
    @Column(name="membershipBadge")
    private String badge;
    @Column(name="membershipDurationInSeconds")
    private Long membershipDurationInSeconds;
    @Column(name = "modifiedAttribute")
    private  Integer modifiedAttribute;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public MembershipTypeModel() {
    }

    public MembershipTypeModel(Integer id, String name, String description, String color, String price, String badge, Long membershipDurationInSeconds, Integer modifiedAttribute, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
        this.price = price;
        this.badge = badge;
        this.membershipDurationInSeconds = membershipDurationInSeconds;
        this.modifiedAttribute = modifiedAttribute;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public MembershipTypeModel(String name) {
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    public Long getMembershipDurationInSeconds() {
        return membershipDurationInSeconds;
    }

    public void setMembershipDurationInSeconds(Long membershipDurationInSeconds) {
        this.membershipDurationInSeconds = membershipDurationInSeconds;
    }

    public Integer getModifiedAttribute() {
        return modifiedAttribute;
    }

    public void setModifiedAttribute(Integer modifiedAttribute) {
        this.modifiedAttribute = modifiedAttribute;
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
