package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


import java.util.Objects;



@Entity(name = "product")
public class ProductModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="product_id_sequence",
            sequenceName = "product_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="productName")
    private String name;
    @Column(name="productCoinPrice")
    private String coinPrice;
    @Column(name="productEmeraldPrice")
    private String emeraldPrice;
    @Column(name="productImage")
    private String image;
    @Column(name="productCategory")
    private String category;
    @Column(name = "productScore")
    private String score;
    @Column(name="productIsOnSale")
    private Boolean isOnSale;
    @Column(name = "productSaleDurationInSeconds")
    private Long saleLimitTimeInSeconds;
    @Column(name="productSalePercent")
    private Double salePercent;
    @Column(name = "rarity")
    private Integer rarity;
    @Column(name="productInitialQuantity")
    private Integer initialQuantity;
    @Column(name="productLeftQuantity")
    private Integer leftQuantity;
    @Column(name="productIsDeliverable")
    private Boolean isDeliverable;
    @Column(name="productDeliveryPrice")
    private String deliveryPrice;
    @Column(name = "ownerId")
    private Integer owner;
    @Column(name="isAvailable")
    private Boolean isAvailable;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ProductModel() {
    }

    public ProductModel(Integer id, String name,Boolean isAvailable, String coinPrice, String emeraldPrice, String image, String category, String score, Boolean isOnSale, Long saleLimitTimeInSeconds, Double salePercent, Integer rarity, Integer initialQuantity, Integer leftQuantity, Boolean isDeliverable, String deliveryPrice, Integer owner, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.coinPrice = coinPrice;
        this.emeraldPrice = emeraldPrice;
        this.image = image;
        this.category = category;
        this.score = score;
        this.isOnSale = isOnSale;
        this.saleLimitTimeInSeconds = saleLimitTimeInSeconds;
        this.salePercent = salePercent;
        this.rarity = rarity;
        this.initialQuantity = initialQuantity;
        this.leftQuantity = leftQuantity;
        this.isDeliverable = isDeliverable;
        this.deliveryPrice = deliveryPrice;
        this.owner = owner;
        this.isAvailable=isAvailable;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ProductModel(String name) {
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
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

    public String getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(String coinPrice) {
        this.coinPrice = coinPrice;
    }

    public String getEmeraldPrice() {
        return emeraldPrice;
    }

    public void setEmeraldPrice(String emeraldPrice) {
        this.emeraldPrice = emeraldPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Boolean getOnSale() {
        return isOnSale;
    }

    public void setOnSale(Boolean onSale) {
        isOnSale = onSale;
    }

    public Long getSaleLimitTimeInSeconds() {
        return saleLimitTimeInSeconds;
    }

    public void setSaleLimitTimeInSeconds(Long saleLimitTimeInSeconds) {
        this.saleLimitTimeInSeconds = saleLimitTimeInSeconds;
    }

    public Double getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(Double salePercent) {
        this.salePercent = salePercent;
    }

    public Integer getRarity() {
        return rarity;
    }

    public void setRarity(Integer rarity) {
        this.rarity = rarity;
    }

    public Integer getInitialQuantity() {
        return initialQuantity;
    }

    public void setInitialQuantity(Integer initialQuantity) {
        this.initialQuantity = initialQuantity;
    }

    public Integer getLeftQuantity() {
        return leftQuantity;
    }

    public void setLeftQuantity(Integer leftQuantity) {
        this.leftQuantity = leftQuantity;
    }

    public Boolean getDeliverable() {
        return isDeliverable;
    }

    public void setDeliverable(Boolean deliverable) {
        isDeliverable = deliverable;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(coinPrice, that.coinPrice) && Objects.equals(emeraldPrice, that.emeraldPrice) && Objects.equals(image, that.image) && Objects.equals(category, that.category) && Objects.equals(score, that.score) && Objects.equals(isOnSale, that.isOnSale) && Objects.equals(saleLimitTimeInSeconds, that.saleLimitTimeInSeconds) && Objects.equals(salePercent, that.salePercent) && Objects.equals(rarity, that.rarity) && Objects.equals(initialQuantity, that.initialQuantity) && Objects.equals(leftQuantity, that.leftQuantity) && Objects.equals(isDeliverable, that.isDeliverable) && Objects.equals(deliveryPrice, that.deliveryPrice) && Objects.equals(owner, that.owner) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, coinPrice, emeraldPrice, image, category, score, isOnSale, saleLimitTimeInSeconds, salePercent, rarity, initialQuantity, leftQuantity, isDeliverable, deliveryPrice, owner, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coinPrice='" + coinPrice + '\'' +
                ", emeraldPrice='" + emeraldPrice + '\'' +
                ", image='" + image + '\'' +
                ", category='" + category + '\'' +
                ", score='" + score + '\'' +
                ", isOnSale=" + isOnSale +
                ", saleLimitTime=" + saleLimitTimeInSeconds +
                ", salePercent=" + salePercent +
                ", rarity=" + rarity +
                ", initialQuantity=" + initialQuantity +
                ", leftQuantity=" + leftQuantity +
                ", isDeliverable=" + isDeliverable +
                ", deliveryPrice='" + deliveryPrice + '\'' +
                ", owner=" + owner +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
