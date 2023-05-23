package com.walkini.repositories;

import com.walkini.models.StepHistoryModel;
import com.walkini.models.WorkoutPartModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutPartRepository extends JpaRepository<WorkoutPartModel,Integer> {
}
