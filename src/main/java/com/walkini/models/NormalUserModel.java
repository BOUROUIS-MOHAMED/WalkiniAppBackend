package com.walkini.models;

import jakarta.persistence.*;
@Entity(name = "normalUser")
public class NormalUserModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "normal_user_id_sequence",
            sequenceName = "normal_user_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "normal_user_id_sequence"
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
    @Column(name = "password")
    private String secretPassword;
    @Column(name = "image")
    private String image="";
    @Column(name = "gender")
    private String gender="unknown";
    @Column(name = "birthday")
    private String birthday="unknown";
    @Column(name = "latitude")
    private Double latitude=null;
    @Column(name = "longitude")
    private Double longitude=null;
    @Column(name = "isBanned")
    private Boolean isBanned=false;;
    @Column(name = "banInfo")
    private Integer banInfo=null;
    @Column(name = "profileQrCode")
    private String qrCode;
    @Column(name = "secretKey")
    private String secretKey;
    @Column(name = "secretToken")
    private String token;
    @Column(name = "emeraldBalance")
    private Double emeraldBalance=0.0;
    @Column(name = "coinBalance")
    private Double coinBalance=0.0;
    /*  @Column(name = "shopHistoryIds")
      private String shopHistory;
      @Column(name = "charityHistoryIds")
      private String charityHistory;*/
    @Column(name = "totalSteps")
    private String totalSteps="0";;
    /*    @Column(name = "stepHistoryIds")
        private String stepHistoryIds;*/
    @Column(name = "boosts")
    private String boosts="";
    @Column(name = "coupons")
    private String coupons="";

    @Column(name = "places")
    private String places="";
    @Column(name = "badges")
    private String badges="";
    @Column(name = "workouts")
    private String workouts="";
    @Column(name = "completedWorkouts")
    private String completedWorkouts="";
    @Column(name = "Challenges")
    private String challenges="";
    @Column(name = "score")
    private String score="5";
    @Column(name = "nationality")
    private String nationality="unknown";;
    @Column(name = "membershipId")
    private Integer membership=1;
    @Column(name = "lastMembershipActivationDate")
    private String lastMembershipActivationDate="unknown";
    @Column(name = "inboxIds")
    private String inbox="";
    @Column(name = "seenInboxIds")
    private String  seenInbox="";
    @Column(name = "recievedNotificationIds")
    private String receivedNotification="";
    @Column(name = "heightInCm")
    private Double heightInCm;
    @Column(name = "weightInKg")
    private Double weight;
    @Column(name = "goals")
    private String goals="";
    @Column(name = "adBlocker")
    private Boolean adBlocker=false;
    @Column(name = "phoneType")
    private String phoneType="unknown";
    @Column(name = "logsIds")
    private String logs="";
    private String createdAt;
    private String modifiedAt;

    public NormalUserModel() {
    }

    public NormalUserModel(Integer id, String firstName, String lastName, String phoneNumber, String email, String secretPassword, String image, String gender, String birthday, Double latitude, Double longitude, Boolean isBanned, Integer banInfo, String qrCode, String secretKey, String token, Double emeraldBalance, Double coinBalance, String totalSteps, String boosts, String coupons, String places, String badges, String workouts, String completedWorkouts, String challenges, String score, String nationality, Integer membership, String lastMembershipActivationDate, String inbox, String seenInbox, String receivedNotification, Double heightInCm, Double weight, String goals, Boolean adBlocker, String phoneType, String logs, String createdAt, String modifiedAt) {
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
        this.isBanned = isBanned;
        this.banInfo = banInfo;
        this.qrCode = qrCode;
        this.secretKey = secretKey;
        this.token = token;
        this.emeraldBalance = emeraldBalance;
        this.coinBalance = coinBalance;
        this.totalSteps = totalSteps;
        this.boosts = boosts;
        this.coupons = coupons;

        this.places = places;
        this.badges = badges;
        this.workouts = workouts;
        this.completedWorkouts = completedWorkouts;
        this.challenges = challenges;
        this.score = score;
        this.nationality = nationality;
        this.membership = membership;
        this.lastMembershipActivationDate = lastMembershipActivationDate;
        this.inbox = inbox;
        this.seenInbox = seenInbox;
        this.receivedNotification = receivedNotification;
        this.heightInCm = heightInCm;
        this.weight = weight;
        this.goals = goals;
        this.adBlocker = adBlocker;
        this.phoneType = phoneType;
        this.logs = logs;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
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

    public String getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(String totalSteps) {
        this.totalSteps = totalSteps;
    }

    public String getBoosts() {
        return boosts;
    }

    public void setBoosts(String boosts) {
        this.boosts = boosts;
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons;
    }



    public String getPlaces() {
        return places;
    }

    public void setPlaces(String places) {
        this.places = places;
    }

    public String getBadges() {
        return badges;
    }

    public void setBadges(String badges) {
        this.badges = badges;
    }

    public String getWorkouts() {
        return workouts;
    }

    public void setWorkouts(String workouts) {
        this.workouts = workouts;
    }

    public String getCompletedWorkouts() {
        return completedWorkouts;
    }

    public void setCompletedWorkouts(String completedWorkouts) {
        this.completedWorkouts = completedWorkouts;
    }

    public String getChallenges() {
        return challenges;
    }

    public void setChallenges(String challenges) {
        this.challenges = challenges;
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

    public String getLastMembershipActivationDate() {
        return lastMembershipActivationDate;
    }

    public void setLastMembershipActivationDate(String lastMembershipActivationDate) {
        this.lastMembershipActivationDate = lastMembershipActivationDate;
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

    public Double getHeightInCm() {
        return heightInCm;
    }

    public void setHeightInCm(Double heightInCm) {
        this.heightInCm = heightInCm;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Boolean getAdBlocker() {
        return adBlocker;
    }

    public void setAdBlocker(Boolean adBlocker) {
        this.adBlocker = adBlocker;
    }

    public String getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
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