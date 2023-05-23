package com.walkini.repositories;

import com.walkini.models.StepHistoryModel;
import com.walkini.models.WorkoutModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<WorkoutModel,Integer> {
    List<WorkoutModel> findByWorkoutName(String workoutName);

}
