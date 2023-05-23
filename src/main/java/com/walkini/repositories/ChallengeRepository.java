package com.walkini.repositories;

import com.walkini.models.ChallengeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChallengeRepository extends JpaRepository<ChallengeModel,Integer> {
    List<ChallengeModel> findByname(String name);
}
