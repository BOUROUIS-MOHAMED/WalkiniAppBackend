package com.walkini.repositories;


import com.walkini.models.RarityModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RarityRepository
        extends JpaRepository<RarityModel,Integer> {


}
