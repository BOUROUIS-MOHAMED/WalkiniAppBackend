package com.walkini.repositories;

import com.walkini.models.MembershipTypeModel;
import com.walkini.models.ModifiedAttributeModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModifiedAttributeRepository
        extends JpaRepository<ModifiedAttributeModel,Integer> {
    List<ModifiedAttributeModel> findByname(String name);


}
