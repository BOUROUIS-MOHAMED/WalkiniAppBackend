package com.walkini.repositories;

import com.walkini.models.PlaceModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository
        extends JpaRepository<PlaceModel,Integer> {


}
