package com.walkini.repositories;


import com.walkini.models.ProductModel;
import com.walkini.models.RarityModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RarityRepository
        extends JpaRepository<RarityModel,Integer> {
    List<RarityModel> findByname(String name);


}
