package com.walkini.models;
import jakarta.persistence.*;


@Entity
@Table(name = "imageData")

public class ImageData {

    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="image_data_id_sequence",
            sequenceName = "image_data_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "image_data_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    private  String name;
    private  String type;
    @Column(name = "imageData")
    private byte[] imageData;

    public ImageData(Integer id, String name, String type, byte[] imageData) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.imageData = imageData;
    }

    public ImageData() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }
}

