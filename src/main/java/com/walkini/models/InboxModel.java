package com.walkini.models;

import jakarta.persistence.*;

@Entity(name = "inbox")
public class InboxModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "inbox_id_sequence",
            sequenceName = "inbox_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inbox_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "messageContent")
    private String content;
    @Column(name = "messageIsGift")
    private Boolean isGift;
    private String createdAt;
    private String modifiedAt;

    public InboxModel() {
    }

    public InboxModel(Integer id, String title, String content, Boolean isGift, String createdAt, String modifiedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.isGift = isGift;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getGift() {
        return isGift;
    }

    public void setGift(Boolean gift) {
        isGift = gift;
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