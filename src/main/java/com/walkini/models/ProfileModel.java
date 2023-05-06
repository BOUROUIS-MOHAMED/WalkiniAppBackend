package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;
 
import java.util.Objects;


@Entity(name = "profile")
public class ProfileModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "profile_id_sequence",
            sequenceName = "profile_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "fName")
    private String firstName;
    @Column(name = "lName")
    private String lastName;
    @Column(name = "phone")
    private String phoneNumber;
    @Column(name = "email")
    private String email;
    @Column(name = "pass")
    private String secretPassword;
    @Column(name = "avatar")
    private String image;
    @Column(name = "gender")
    private String gender;
    @Column(name = "birthday")
    private Timestamp birthday;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "boosts")
    private String boosts;
    @Column(name = "isBanned")
    private Boolean isBanned;
    @Column(name = "banDetails")
    private Integer banDetails;
    @Column(name = "additionalInformationId")
    private Integer additionalInformationId;
    @Column(name = "banDurationInSeconds")
    private Long banDurationInSeconds;
    @Column(name = "profileQrCode")
    private String QrCode;
    @Column(name = "secretKey")
    private String secretKey;
    @Column(name = "secretToken")
    private String token;
    @Column(name = "emeraldBalance")
    private String emeraldBalance;
    @Column(name = "coinBalance")
    private String coinBalance;
    @Column(name = "totalSteps")
    private String totalSteps;
    @Column(name = "cupponsId")
    private String coupons;
    @Column(name = "boxesId")
    private String boxes;
    @Column(name = "placesId")
    private String places;
    @Column(name = "score")
    private String score;
    @Column(name = "nationality")
    private String nationality;
    /*    @ManyToOne
        @JoinColumn (name ="directMessageId")
        private DirectMessageModel directMessage;*/
    @Column(name = "membershipId")
    private Integer membership;
    @Column(name = "lastMembershipActivationDate")
    private Timestamp lastMembershipActivationDate;
    @Column(name = "isPartner")
    private Boolean isPartner;
    @Column(name = "reviewsId")
    private String reviewsId;
    @Column(name = "inbox")
    private String inbox;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ProfileModel(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ProfileModel(Integer id,
                        String firstName,
                        String lastName,
                        String phoneNumber,
                        String email,
                        String secretPassword,
                        String image,
                        String gender,
                        Timestamp birthday,
                        Double latitude,
                        Double longitude,
                        String boosts,
                        Boolean isBanned,
                        Integer banDetails,
                        Long banDurationInSeconds,
                        String qrCode,
                        String secretKey,
                        String token,
                        String emeraldBalance,
                        String coinBalance,
                        String totalSteps,
                        String coupons,
                        String boxes,
                        int additionalInformationId,
                        String places,
                        String score,
                        String nationality,
                        Integer membership,
                        Timestamp lastMembershipActivationDate,
                        Boolean isPartner,
                        String reviewsId,
                        String inbox,
                        Timestamp createdAt,
                        Timestamp modifiedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.secretPassword = secretPassword;
        this.image = image;
        this.gender = gender;
        this.birthday = birthday;
        this.latitude = latitude;
        this.longitude = longitude;
        this.boosts = boosts;
        this.additionalInformationId=additionalInformationId;
        this.isBanned = isBanned;
        this.banDetails = banDetails;
        this.banDurationInSeconds = banDurationInSeconds;
        this.QrCode = qrCode;
        this.secretKey = secretKey;
        this.token = token;
        this.emeraldBalance = emeraldBalance;
        this.coinBalance = coinBalance;
        this.totalSteps = totalSteps;
        this.coupons = coupons;
        this.boxes = boxes;
        this.places=places;
        this.score = score;
        this.nationality = nationality;
        this.membership = membership;
        this.lastMembershipActivationDate = lastMembershipActivationDate;
        this.isPartner = isPartner;
        this.reviewsId = reviewsId;
        this.inbox = inbox;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ProfileModel() {

    }

    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getAdditionalInformationId() {
        return additionalInformationId;
    }

    public void setAdditionalInformationId(Integer additionalInformationId) {
        this.additionalInformationId = additionalInformationId;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Timestamp getBirthday() {
        return birthday;
    }

    public void setBirthday(Timestamp birthday) {
        this.birthday = birthday;
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

    public String getBoosts() {
        return boosts;
    }

    public void setBoosts(String boosts) {
        this.boosts = boosts;
    }

    public Boolean getBanned() {
        return isBanned;
    }

    public void setBanned(Boolean banned) {
        isBanned = banned;
    }

    public Integer getBanDetails() {
        return banDetails;
    }

    public void setBanDetails(Integer banDetails) {
        this.banDetails = banDetails;
    }

    public Long getBanDurationInSeconds() {
        return banDurationInSeconds;
    }

    public void setBanDurationInSeconds(Long banDuration) {
        this.banDurationInSeconds = banDuration;
    }

    public String getQrCode() {
        return QrCode;
    }

    public void setQrCode(String qrCode) {
        QrCode = qrCode;
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

    public String getEmeraldBalance() {
        return emeraldBalance;
    }

    public void setEmeraldBalance(String emeraldBalance) {
        this.emeraldBalance = emeraldBalance;
    }

    public String getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(String coinBalance) {
        this.coinBalance = coinBalance;
    }

    public String getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(String totalSteps) {
        this.totalSteps = totalSteps;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String cuppons) {
        this.coupons = cuppons;
    }

    public String getBoxes() {
        return boxes;
    }

    public void setBoxes(String boxWallet) {
        this.boxes = boxWallet;
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

    public Integer getMembership() {
        return membership;
    }

    public void setMembership(Integer membership) {
        this.membership = membership;
    }

    public Timestamp getLastMembershipActivationDate() {
        return lastMembershipActivationDate;
    }

    public void setLastMembershipActivationDate(Timestamp lastMembershipActivationDate) {
        this.lastMembershipActivationDate = lastMembershipActivationDate;
    }

    public Boolean getPartner() {
        return isPartner;
    }

    public void setPartner(Boolean partner) {
        isPartner = partner;
    }

    public String getReviewsId() {
        return reviewsId;
    }

    public void setReviewsId(String reviewsId) {
        this.reviewsId = reviewsId;
    }

    public String getInbox() {
        return inbox;
    }

    public void setInbox(String inbox) {
        this.inbox = inbox;
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
        ProfileModel that = (ProfileModel) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(email, that.email) && Objects.equals(secretPassword, that.secretPassword) && Objects.equals(image, that.image) && Objects.equals(gender, that.gender) && Objects.equals(birthday, that.birthday) && Objects.equals(latitude, that.latitude) && Objects.equals(longitude, that.longitude) && Objects.equals(boosts, that.boosts) && Objects.equals(isBanned, that.isBanned) && Objects.equals(banDetails, that.banDetails) && Objects.equals(banDurationInSeconds, that.banDurationInSeconds) && Objects.equals(QrCode, that.QrCode) && Objects.equals(secretKey, that.secretKey) && Objects.equals(token, that.token) && Objects.equals(emeraldBalance, that.emeraldBalance) && Objects.equals(coinBalance, that.coinBalance) && Objects.equals(totalSteps, that.totalSteps) && Objects.equals(coupons, that.coupons) && Objects.equals(boxes, that.boxes) && Objects.equals(score, that.score) && Objects.equals(nationality, that.nationality) && Objects.equals(membership, that.membership) && Objects.equals(lastMembershipActivationDate, that.lastMembershipActivationDate) && Objects.equals(isPartner, that.isPartner) && Objects.equals(reviewsId, that.reviewsId) && Objects.equals(inbox, that.inbox) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phoneNumber, email, secretPassword, image, gender, birthday, latitude, longitude, boosts, isBanned, banDetails, banDurationInSeconds, QrCode, secretKey, token, emeraldBalance, coinBalance, totalSteps, coupons, boxes, score, nationality, membership, lastMembershipActivationDate, isPartner, reviewsId, inbox, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "ProfileModel{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", secretPassword='" + secretPassword + '\'' +
                ", image='" + image + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", boosts='" + boosts + '\'' +
                ", isBanned=" + isBanned +
                ", banDetails=" + banDetails +
                ", banDuration=" + banDurationInSeconds +
                ", QrCode='" + QrCode + '\'' +
                ", secretKey='" + secretKey + '\'' +
                ", token='" + token + '\'' +
                ", emeraldBalance='" + emeraldBalance + '\'' +
                ", coinBalance='" + coinBalance + '\'' +
                ", totalSteps='" + totalSteps + '\'' +
                ", cuppons='" + coupons + '\'' +
                ", boxes='" + boxes + '\'' +
                ", places='" + places + '\'' +
                ", score='" + score + '\'' +
                ", nationality='" + nationality + '\'' +
                ", membership=" + membership +
                ", lastMembershipActivationDate=" + lastMembershipActivationDate +
                ", isPartner=" + isPartner +
                ", reviewsId='" + reviewsId + '\'' +
                ", inbox='" + inbox + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}


