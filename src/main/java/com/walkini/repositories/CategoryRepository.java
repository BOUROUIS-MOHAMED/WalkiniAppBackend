package com.walkini.repositories;

import com.walkini.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<CategoryModel,Integer> {


}
