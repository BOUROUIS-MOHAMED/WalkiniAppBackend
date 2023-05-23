package com.walkini.repositories;

import com.walkini.models.ProductCategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategoryModel,Integer> {
    List<ProductCategoryModel> findBycategoryName(String categoryName);
}
