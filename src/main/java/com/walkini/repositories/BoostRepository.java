package com.walkini.repositories;

import com.walkini.models.BoostsModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoostRepository extends JpaRepository<BoostsModel,Integer> {
    List<BoostsModel> findByName(String boostName);


}
