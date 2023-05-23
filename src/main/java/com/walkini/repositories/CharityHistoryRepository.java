package com.walkini.repositories;

import com.walkini.models.CharityHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharityHistoryRepository extends JpaRepository<CharityHistoryModel,Integer> {
}
