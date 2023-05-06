package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;


@Entity(name = "inbox")
public class InboxModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="inbox_id_sequence",
            sequenceName = "inbox_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "inbox_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="title")
    private String title;
    @Column(name="messageContent")
    private String content;
    @Column(name="messageImage")
    private String image;
    @Column(name="messageFirstAction")
    private Integer firstAction;
    @Column(name="messageSecondAction")
    private Integer secondAction;
    @Column(name = "messageIsGift")
    private Boolean isGift;
    @Column(name = "messageIsCollected")
    private Boolean isCollected;
    @Column(name = "messageIsSeen")
    private Boolean isSeen;
    @Column(name="messageCollectGiftButtonAction")
    private Integer collectGiftButtonAction;
    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public InboxModel(Integer id, String title, String content, String image, Integer firstAction, Integer secondAction, Boolean isGift, Boolean isCollected, Boolean isSeen, Integer collectGiftButtonAction, Timestamp createdAt, Timestamp modifiedAt) {
        
        this.id = id;
        this.title = title;
        this.content = content;
        this.image = image;
        this.firstAction = firstAction;
        this.secondAction = secondAction;
        this.isGift = isGift;
        this.isCollected = isCollected;
        this.isSeen = isSeen;
        this.collectGiftButtonAction = collectGiftButtonAction;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public InboxModel() {
    }

    public InboxModel(String title) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getFirstAction() {
        return firstAction;
    }

    public void setFirstAction(Integer firstAction) {
        this.firstAction = firstAction;
    }

    public Integer getSecondAction() {
        return secondAction;
    }

    public void setSecondAction(Integer secondAction) {
        this.secondAction = secondAction;
    }

    public Boolean getGift() {
        return isGift;
    }

    public void setGift(Boolean gift) {
        isGift = gift;
    }

    public Boolean getCollected() {
        return isCollected;
    }

    public void setCollected(Boolean collected) {
        isCollected = collected;
    }

    public Boolean getSeen() {
        return isSeen;
    }

    public void setSeen(Boolean seen) {
        isSeen = seen;
    }

    public Integer getCollectGiftButtonAction() {
        return collectGiftButtonAction;
    }

    public void setCollectGiftButtonAction(Integer collectGiftButtonAction) {
        this.collectGiftButtonAction = collectGiftButtonAction;
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
