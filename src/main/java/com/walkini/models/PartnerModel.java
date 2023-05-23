package com.walkini.models;

import jakarta.persistence.*;
@Entity(name = "productOwner")
public class PartnerModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "product_owner_id_sequence",
            sequenceName = "product_owner_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "product_owner_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String secretPassword;
    @Column(name = "image")
    private String image;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "isBanned")
    private Boolean isBanned;
    @Column(name = "banInfo")
    private Integer banInfo;
    @Column(name = "profileQrCode")
    private String qrCode;
    @Column(name = "secretKey")
    private String secretKey;
    @Column(name = "secretToken")
    private String token;
    @Column(name = "emeraldBalance")
    private Double emeraldBalance;
    @Column(name = "coinBalance")
    private Double coinBalance;
    @Column(name = "moneyBalance")
    private Double moneyBalance;
    @Column(name = "partnerSoledProductsWalletIds")
    private String soledProducts;
    @Column(name = "score")
    private String score;
    @Column(name = "nationality")
    private String nationality;
    @Column(name = "isPremium")
    private Boolean premium;
    @Column(name = "premiumActivationDate")
    private String premiumActivationDate;
    @Column(name = "inboxIds")
    private String inbox;
    @Column(name = "seenInboxIds")
    private String seenInbox;
    @Column(name = "recievedNotificationIds")
    private String receivedNotification;
    @Column(name = "logsIds")
    private String logs;
    @Column(name = "activated")
    private Boolean activated;
    private String createdAt;
    private String modifiedAt;

    public PartnerModel() {
    }


    public PartnerModel(Integer id, String name, String phoneNumber, String email, String secretPassword, String image, Double latitude, Double longitude, Boolean isBanned, Integer banInfo, String qrCode, String secretKey, String token, Double emeraldBalance, Double coinBalance, Double moneyBalance, String soledProducts, String score, String nationality, Boolean premium, String premiumActivationDate, String inbox, String seenInbox, String receivedNotification, String logs, Boolean activated, String createdAt, String modifiedAt) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretPassword = secretPassword;
        this.image = image;
        this.latitude = latitude;
        this.longitude = longitude;
        this.isBanned = isBanned;
        this.banInfo = banInfo;
        this.qrCode = qrCode;
        this.secretKey = secretKey;
        this.token = token;
        this.emeraldBalance = emeraldBalance;
        this.coinBalance = coinBalance;
        this.moneyBalance = moneyBalance;
        this.soledProducts = soledProducts;
        this.score = score;
        this.nationality = nationality;
        this.premium = premium;
        this.premiumActivationDate = premiumActivationDate;
        this.inbox = inbox;
        this.seenInbox = seenInbox;
        this.receivedNotification = receivedNotification;
        this.logs = logs;
        this.activated = activated;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecretPassword() {
        return secretPassword;
    }

    public void setSecretPassword(String secretPassword) {
        this.secretPassword = secretPassword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Integer getBanInfo() {
        return banInfo;
    }

    public void setBanInfo(Integer banInfo) {
        this.banInfo = banInfo;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Double getEmeraldBalance() {
        return emeraldBalance;
    }

    public void setEmeraldBalance(Double emeraldBalance) {
        this.emeraldBalance = emeraldBalance;
    }

    public Double getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(Double coinBalance) {
        this.coinBalance = coinBalance;
    }

    public Double getMoneyBalance() {
        return moneyBalance;
    }

    public void setMoneyBalance(Double moneyBalance) {
        this.moneyBalance = moneyBalance;
    }

    public String getSoledProducts() {
        return soledProducts;
    }

    public void setSoledProducts(String soledProducts) {
        this.soledProducts = soledProducts;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Boolean getPremium() {
        return premium;
    }

    public void setPremium(Boolean premium) {
        this.premium = premium;
    }

    public String getPremiumActivationDate() {
        return premiumActivationDate;
    }

    public void setPremiumActivationDate(String premiumActivationDate) {
        this.premiumActivationDate = premiumActivationDate;
    }

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
    }

    public String getSeenInbox() {
        return seenInbox;
    }

    public void setSeenInbox(String seenInbox) {
        this.seenInbox = seenInbox;
    }

    public String getReceivedNotification() {
        return receivedNotification;
    }

    public void setReceivedNotification(String receivedNotification) {
        this.receivedNotification = receivedNotification;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }

    public Boolean getActivated() {
        return activated;
    }

    public void setActivated(Boolean activated) {
        this.activated = activated;
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