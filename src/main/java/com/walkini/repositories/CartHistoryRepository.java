package com.walkini.repositories;

import com.walkini.models.CartHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartHistoryRepository
        extends JpaRepository<CartHistoryModel,Integer> {
    List<CartHistoryModel> findByuserIdEquals(Integer userId);


}
