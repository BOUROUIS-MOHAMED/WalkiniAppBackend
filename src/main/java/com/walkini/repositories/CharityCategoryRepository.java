package com.walkini.repositories;


import com.walkini.models.CharityCategoryModel;
import com.walkini.models.ProductCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharityCategoryRepository extends JpaRepository<CharityCategoryModel,Integer> {
    List<CharityCategoryModel> findByCategoryName(String categoryName);

}
