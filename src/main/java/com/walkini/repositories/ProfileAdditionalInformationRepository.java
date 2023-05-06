package com.walkini.repositories;

import com.walkini.models.ProfileAdditionalInformationModel;
import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileAdditionalInformationRepository
        extends JpaRepository<ProfileAdditionalInformationModel,Integer>{

}
