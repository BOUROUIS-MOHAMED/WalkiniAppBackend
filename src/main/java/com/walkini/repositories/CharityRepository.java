package com.walkini.repositories;

import com.walkini.models.CharityModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharityRepository
        extends JpaRepository<CharityModel,Integer> {
    List<CharityModel> findByownerEquals(Integer userId);
    List<CharityModel> findByTitle(String charityTitle);


}
