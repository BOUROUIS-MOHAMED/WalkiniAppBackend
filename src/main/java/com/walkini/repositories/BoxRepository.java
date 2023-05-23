package com.walkini.repositories;

import com.walkini.models.BoxModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoxRepository
        extends JpaRepository<BoxModel,Integer> {
    List<BoxModel> findByName(String boxName);

}
