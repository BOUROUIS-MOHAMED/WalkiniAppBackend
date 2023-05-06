package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity(name = "shopHistory")
public class ShopHistory {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="shop_history_id_sequence",
            sequenceName = "shop_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "shop_history_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="Buyer")
    private String buyer;
    @Column(name="description")
    private String Description;
    @Column(name="productID")
    private String productID;
    @Column(name="transactionType")
    private String transactionType;
    private Timestamp createdAt;
    private Timestamp modifiedAt;
}
