package com.walkini.models;

import jakarta.persistence.*;



@Entity(name = "productCategory")
public class ProductCategoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="product_category_id_sequence",
            sequenceName = "product_category_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_category_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="categoryName")
    private String categoryName;
    @Column(name="categoryIcon")
    private String icon;
    private String createdAt;
    private String modifiedAt;

    public ProductCategoryModel() {
    }

    public ProductCategoryModel(Integer id, String categoryName, String icon, String createdAt, String modifiedAt) {
        this.id = id;
        this.categoryName = categoryName;
        this.icon = icon;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
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
