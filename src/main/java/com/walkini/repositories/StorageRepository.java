package com.walkini.repositories;

import com.walkini.models.ImageData;
import com.walkini.models.StepHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StorageRepository extends JpaRepository<ImageData,Integer> {


  Optional <ImageData> findByName(String fileName);
}
