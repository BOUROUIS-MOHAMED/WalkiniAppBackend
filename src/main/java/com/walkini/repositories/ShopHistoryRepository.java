package com.walkini.repositories;

import com.walkini.models.ShopHistoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopHistoryRepository
        extends JpaRepository<ShopHistoryModel,Integer> {


}
