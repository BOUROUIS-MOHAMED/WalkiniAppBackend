package com.walkini.repositories;

import com.walkini.models.ProfileModel;
import com.walkini.models.ProfileTypeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileTypeRepository
        extends JpaRepository<ProfileTypeModel,Integer> {


}
