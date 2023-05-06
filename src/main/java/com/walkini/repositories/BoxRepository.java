package com.walkini.repositories;

import com.walkini.models.BoxModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxRepository
        extends JpaRepository<BoxModel,Integer> {


}
