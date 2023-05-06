package com.walkini.models;

import jakarta.persistence.*;

import java.sql.Timestamp;

import java.util.Objects;


@Entity(name = "action")
public class ActionModel {
    @Id
    @SequenceGenerator(
allocationSize=1,
            name="action_id_sequence",
            sequenceName = "action_id_sequence"

    )
    
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "action_id_sequence"
    )


    @Column(name="id")
    private Integer id;
    @Column(name="actionName")
    private String name;
    @Column(name="actionRoute")
    private String route;

    private Timestamp createdAt;
    private Timestamp modifiedAt;

    public ActionModel() {
    }

    public ActionModel(Integer id, String name, String route, Timestamp createdAt, Timestamp modifiedAt) {
        this.id = id;
        this.name = name;
        this.route = route;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public ActionModel(String name) {
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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
        ActionModel that = (ActionModel) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(route, that.route) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, route, createdAt, modifiedAt);
    }

    @Override
    public String toString() {
        return "ActionModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
