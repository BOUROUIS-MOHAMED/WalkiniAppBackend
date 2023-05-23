package com.walkini.models;

import jakarta.persistence.*;


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
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="coinPrice")
    private Double coinPrice;
    @Column(name="emeraldPrice")
    private Double emeraldPrice;
    @Column(name="image")
    private String image;
    @Column(name="category")
    private String category;
    @Column(name = "Score")
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
    @Column(name = "owner")
    private Integer owner;
    @Column(name="isAvailable")
    private Boolean isAvailable;
    @Column(name="canUseCoupon")
    private Boolean canUseCoupon;
    private String createdAt;
    private String modifiedAt;

    public ProductModel(Integer id, String name, String description, Double coinPrice, Double emeraldPrice, String image, String category, String score, Boolean isOnSale, Long saleLimitTimeInSeconds, Double salePercent, Integer rarity, Integer initialQuantity, Integer leftQuantity, Boolean isDeliverable, Integer owner, Boolean isAvailable, Boolean canUseCoupon, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
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
        this.owner = owner;
        this.isAvailable = isAvailable;
        this.canUseCoupon = canUseCoupon;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ProductModel() {
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

    public Double getCoinPrice() {
        return coinPrice;
    }

    public void setCoinPrice(Double coinPrice) {
        this.coinPrice = coinPrice;
    }

    public Double getEmeraldPrice() {
        return emeraldPrice;
    }

    public void setEmeraldPrice(Double emeraldPrice) {
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

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public Boolean getAvailable() {
        return isAvailable;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }

    public Boolean getCanUseCoupon() {
        return canUseCoupon;
    }

    public void setCanUseCoupon(Boolean canUseCoupon) {
        this.canUseCoupon = canUseCoupon;
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
