package com.walkini.models;

import jakarta.persistence.*;

 

@Entity(name = "membership")
public class MembershipTypeModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "membership_type_id_sequence",
            sequenceName = "membership_type_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "membership_type_id_sequence"
    )


    @Column
    private Integer id;
    @Column(name = "membershipName")
    private String name;
    @Column(name = "membershipDescription")
    private String description;
    @Column(name = "membershipPrice")
    private Double price;
    @Column(name = "membershipBadge")
    private Integer badge;
    @Column(name = "membershipDurationInMonths")
    private Integer membershipDurationInMonths;
    @Column(name = "modifiedAttribute")
    private Integer modifiedAttribute;
    private String createdAt;
    private String modifiedAt;

    public MembershipTypeModel() {
    }

    public MembershipTypeModel(Integer id, String name, String description, Double price, Integer badge, Integer membershipDurationInMonths, Integer modifiedAttribute, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.badge = badge;
        this.membershipDurationInMonths = membershipDurationInMonths;
        this.modifiedAttribute = modifiedAttribute;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getBadge() {
        return badge;
    }

    public void setBadge(Integer badge) {
        this.badge = badge;
    }

    public Integer getMembershipDurationInMonths() {
        return membershipDurationInMonths;
    }

    public void setMembershipDurationInMonths(Integer membershipDurationInMonths) {
        this.membershipDurationInMonths = membershipDurationInMonths;
    }

    public Integer getModifiedAttribute() {
        return modifiedAttribute;
    }

    public void setModifiedAttribute(Integer modifiedAttribute) {
        this.modifiedAttribute = modifiedAttribute;
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