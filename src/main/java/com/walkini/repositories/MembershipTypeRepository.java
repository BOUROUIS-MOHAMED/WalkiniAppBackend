package com.walkini.repositories;


import com.walkini.models.MembershipTypeModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipTypeRepository
        extends JpaRepository<MembershipTypeModel,Integer> {


}
