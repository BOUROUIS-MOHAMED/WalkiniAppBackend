package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;



@Entity(name = "category")
public class CategoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="category_id_sequence",
            sequenceName = "category_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="categoryName")
    private String categoryName;
    @Column(name="categoryIcon")
    private String icon;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public CategoryModel(Integer id, String categoryName, String icon, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.icon = icon;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public CategoryModel() {
    }

    public CategoryModel(String s) {
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
