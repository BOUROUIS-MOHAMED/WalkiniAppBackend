package com.walkini.repositories;

import com.walkini.models.BanModel;
import com.walkini.models.ProductModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository
        extends JpaRepository<ProductModel,Integer> {
    List<ProductModel> findByownerEquals(Integer owner);


}
