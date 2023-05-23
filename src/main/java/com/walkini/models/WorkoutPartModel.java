package com.walkini.models;

import jakarta.persistence.*;
@Entity(name = "workoutPart")

public class WorkoutPartModel {
    @Id
    @SequenceGenerator(
            allocationSize=1,
            name="workout_part_id_sequence",
            sequenceName = "workout_part_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "workout_part_id_sequence"
    )

    @Column(name="id")
    private Integer id;
    @Column(name="workoutPartDescription")
    private String workoutPartDescription;
    @Column(name="workoutPartVideo")
    private String workoutPartVideo;
    @Column(name="workoutPartSound")
    private String workoutPartSound;
    @Column(name="workoutPartCaloriesBurned")
    private Double workoutPartCaloriesBurned;
    @Column(name="workoutPartDurationInSeconds")
    private Double workoutPartDurationInSeconds;
    private String createdAt;
    private String modifiedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkoutPartDescription() {
        return workoutPartDescription;
    }

    public void setWorkoutPartDescription(String workoutPartDescription) {
        this.workoutPartDescription = workoutPartDescription;
    }

    public String getWorkoutPartVideo() {
        return workoutPartVideo;
    }

    public void setWorkoutPartVideo(String workoutPartVideo) {
        this.workoutPartVideo = workoutPartVideo;
    }

    public String getWorkoutPartSound() {
        return workoutPartSound;
    }

    public void setWorkoutPartSound(String workoutPartSound) {
        this.workoutPartSound = workoutPartSound;
    }

    public Double getWorkoutPartCaloriesBurned() {
        return workoutPartCaloriesBurned;
    }

    public void setWorkoutPartCaloriesBurned(Double workoutPartCaloriesBurned) {
        this.workoutPartCaloriesBurned = workoutPartCaloriesBurned;
    }

    public Double getWorkoutPartDurationInSeconds() {
        return workoutPartDurationInSeconds;
    }

    public void setWorkoutPartDurationInSeconds(Double workoutPartDurationInSeconds) {
        this.workoutPartDurationInSeconds = workoutPartDurationInSeconds;
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

    public WorkoutPartModel() {
    }

    public WorkoutPartModel(Integer id, String workoutPartDescription, String workoutPartVideo, String workoutPartSound, Double workoutPartCaloriesBurned, Double workoutPartDurationInSeconds, String createdAt, String modifiedAt) {
        this.id = id;
        this.workoutPartDescription = workoutPartDescription;
        this.workoutPartVideo = workoutPartVideo;
        this.workoutPartSound = workoutPartSound;
        this.workoutPartCaloriesBurned = workoutPartCaloriesBurned;
        this.workoutPartDurationInSeconds = workoutPartDurationInSeconds;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
