package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


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
    private String product;
    @Column(name="productSoldPrice")
    private String soldPrice;
    @Column(name="productOwnere")
    private Integer productOwner;
    @Column(name="productBuyer")
    private Integer productBuyer;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
