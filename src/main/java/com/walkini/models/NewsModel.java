package com.walkini.models;

import jakarta.persistence.*;





@Entity(name = "news")
public class NewsModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="news_id_sequence",
            sequenceName = "news_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "news_id_sequence"
    )
    @Column(name="id")
    private Integer id;
    @Column(name="newsTitle")
    private String title;
    @Column(name="newsDescription")
    private String description;
    @Column(name="newsImage")
    private String newsImage;
    @Column(name="newsCountry")
    private String country;
    @Column(name="newsColor")
    private String color;
    @Column(name = "newsPriority")
    private String priority;
    @Column(name="newsIsSponsored")
    private Boolean sponsored;
    @Column(name="newsIsInfo")
    private Boolean newsIsInfo;
    @Column(name="newsIsFilteredByCountry")
    private Boolean newsIsFilteredByCountry;
    @Column(name="Newsaction")
    private Integer action;
    private String createdAt;
    private String modifiedAt;

    public NewsModel() {
    }

    public NewsModel(Integer id, String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Boolean newsIsInfo, Boolean newsIsFilteredByCountry, Integer action, String createdAt, String modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.newsImage = newsImage;
        this.country = country;
        this.color = color;
        this.priority = priority;
        this.sponsored = sponsored;
        this.newsIsInfo = newsIsInfo;
        this.newsIsFilteredByCountry = newsIsFilteredByCountry;
        this.action = action;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public Boolean getSponsored() {
        return sponsored;
    }

    public void setSponsored(Boolean sponsored) {
        this.sponsored = sponsored;
    }

    public Boolean getNewsIsInfo() {
        return newsIsInfo;
    }

    public void setNewsIsInfo(Boolean newsIsInfo) {
        this.newsIsInfo = newsIsInfo;
    }

    public Boolean getNewsIsFilteredByCountry() {
        return newsIsFilteredByCountry;
    }

    public void setNewsIsFilteredByCountry(Boolean newsIsFilteredByCountry) {
        this.newsIsFilteredByCountry = newsIsFilteredByCountry;
    }

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
