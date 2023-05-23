package com.walkini.models;

import jakarta.persistence.*;




@Entity(name = "charityCategory")
public class CharityCategoryModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "charity_category_id_sequence",
            sequenceName = "charity_category_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "charity_category_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "categoryName")
    private String categoryName;
    @Column(name = "categoryIcon")
    private String icon;
    private String createdAt;
    private String modifiedAt;

    public CharityCategoryModel(Integer id, String categoryName, String icon, String createdAt, String modifiedAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.icon = icon;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public CharityCategoryModel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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