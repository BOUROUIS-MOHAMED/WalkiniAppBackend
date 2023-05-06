package com.walkini.models;

import jakarta.persistence.*;


@Entity(name = "profileAdditionalInformationModel")
public class ProfileAdditionalInformationModel {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            name = "profile_additional_information_id_sequence",
            sequenceName = "profile_additional_information_id_sequence")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "profile_additional_information_id_sequence"
    )

    @Column(name = "id")
    private Integer id;
    @Column(name = "height")
    private String height;
    @Column(name = "weight")
    private String weight;
    @Column(name = "goals")
    private String goals;
    @Column(name = "hadProblems")
    private Boolean hadProblems;
    @Column(name = "problems")
    private String problems;


    public ProfileAdditionalInformationModel(Integer id, String height, String weight, String goals, Boolean hadProblems,String problems) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.goals = goals;
        this.hadProblems = hadProblems;
        this.problems=problems;
    }

    public ProfileAdditionalInformationModel() {
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weigth) {
        this.weight = weigth;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public Boolean getHadProblems() {
        return hadProblems;
    }

    public void setHadProblems(Boolean hadProblems) {
        this.hadProblems = hadProblems;
    }

}


