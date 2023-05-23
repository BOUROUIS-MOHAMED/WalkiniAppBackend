package com.walkini.models;

import jakarta.persistence.*;




@Entity(name = "charityHistory")
public class CharityHistoryModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="charity_history_id_sequence",
            sequenceName = "charity_history_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "charity_history_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="donor")
    private String donor;
    @Column(name="logMessage")
    private String logMessage;
    @Column(name="charityID")
    private String charityID;
    @Column(name="emeraldOrCoin")
    private String emeraldOrCoin;
    @Column(name="donationAmount")
    private String donationAmount;

    private String createdAt;
    private String modifiedAt;

    public CharityHistoryModel() {
    }

    public CharityHistoryModel(Integer id, String donor, String logMessage, String charityID, String emeraldOrCoin, String donationAmount, String createdAt, String modifiedAt) {
        this.id = id;
        this.donor = donor;
        this.logMessage = logMessage;
        this.charityID = charityID;
        this.emeraldOrCoin = emeraldOrCoin;
        this.donationAmount = donationAmount;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDonor() {
        return donor;
    }

    public void setDonor(String donor) {
        this.donor = donor;
    }

    public String getLogMessage() {
        return logMessage;
    }

    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    public String getCharityID() {
        return charityID;
    }

    public void setCharityID(String charityID) {
        this.charityID = charityID;
    }

    public String getEmeraldOrCoin() {
        return emeraldOrCoin;
    }

    public void setEmeraldOrCoin(String emeraldOrCoin) {
        this.emeraldOrCoin = emeraldOrCoin;
    }

    public String getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(String donationAmount) {
        this.donationAmount = donationAmount;
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
