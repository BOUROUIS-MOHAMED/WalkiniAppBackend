package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;




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
    @Column(name="Newsaction")
    private Integer action;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public NewsModel() {
    }

    public NewsModel(Integer id, String title, String description, String newsImage, String country, String color, String priority, Boolean sponsored, Integer action, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.newsImage = newsImage;
        this.country = country;
        this.color = color;
        this.priority = priority;
        this.sponsored = sponsored;
        this.action = action;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public NewsModel(String title) {
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

    public Integer getAction() {
        return action;
    }

    public void setAction(Integer action) {
        this.action = action;
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
}
