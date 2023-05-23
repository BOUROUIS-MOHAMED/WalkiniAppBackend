package com.walkini.repositories;


import com.walkini.models.MembershipTypeModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembershipTypeRepository
        extends JpaRepository<MembershipTypeModel,Integer> {
    List<MembershipTypeModel> findByName(String membershipName);


}
