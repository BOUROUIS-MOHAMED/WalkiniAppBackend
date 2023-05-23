package com.walkini.models;
import jakarta.persistence.*;


@Entity
@Table(name = "fileData")

public class FileData {

    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="file_data_id_sequence",
            sequenceName = "file_data_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "file_data_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    private  String name;
    private  String type;
    private String filePath;

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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public FileData() {
    }

    public FileData(Integer id, String name, String type, String filePath) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }
}

