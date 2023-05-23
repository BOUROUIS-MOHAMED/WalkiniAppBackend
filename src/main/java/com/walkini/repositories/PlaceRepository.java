package com.walkini.repositories;

import com.walkini.models.PlaceModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository
        extends JpaRepository<PlaceModel,Integer> {
    List<PlaceModel> findByName(String placeName);


}
