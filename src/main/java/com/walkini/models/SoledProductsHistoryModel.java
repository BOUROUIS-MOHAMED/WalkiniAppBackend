package com.walkini.models;

import jakarta.persistence.*;



@Entity(name = "soledProductsHistory")
public class SoledProductsHistoryModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="soled_products_history_id_sequence",
            sequenceName = "soled_products_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "soled_products_history_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name="product")
    private Integer product;
    @Column(name="productSoldPrice")
    private String  soldPrice;
    @Column(name="productBuyer")
    private Integer productBuyer;
    @Column(name="usedCouponsIds")
    private String  usedCoupons="";
    private String createdAt;
    private String modifiedAt;

    public SoledProductsHistoryModel() {
    }

    public SoledProductsHistoryModel(Integer id, Integer product, String soldPrice, Integer productBuyer, String usedCoupons, String createdAt, String modifiedAt) {
        this.id = id;
        this.product = product;
        this.soldPrice = soldPrice;
        this.productBuyer = productBuyer;
        this.usedCoupons = usedCoupons;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public String getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(String soldPrice) {
        this.soldPrice = soldPrice;
    }

    public Integer getProductBuyer() {
        return productBuyer;
    }

    public void setProductBuyer(Integer productBuyer) {
        this.productBuyer = productBuyer;
    }

    public String getUsedCoupons() {
        return usedCoupons;
    }

    public void setUsedCoupons(String usedCoupons) {
        this.usedCoupons = usedCoupons;
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
