package com.walkini.repositories;

import com.walkini.models.BadgeModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BadgeRepository extends JpaRepository<BadgeModel,Integer> {
    List<BadgeModel> findBybadgeName(String badgeName);

}
