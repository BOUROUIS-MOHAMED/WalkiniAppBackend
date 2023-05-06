package com.walkini.repositories;

import com.walkini.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository
extends JpaRepository<ProfileModel,Integer>{
    List<ProfileModel> findByEmailOrPhoneNumber(String Email, String phoneNumber);


}
