package com.walkini.repositories;

import com.walkini.models.BoxModel;
import com.walkini.models.CartHistoryModel;
import com.walkini.models.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository
        extends JpaRepository<ReviewModel,Integer> {
    List<ReviewModel> findByreviewedProductEquals(Integer Id);

    List<ReviewModel> findByuserIdEquals(Integer Id);
}

