package com.walkini.repositories;

import com.walkini.models.NormalUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NormalUserRepository extends JpaRepository<NormalUserModel,Integer> {
    List<NormalUserModel> findByEmailOrPhoneNumber(String Email, String phoneNumber);
    List<NormalUserModel> findByEmail(String Email);
    List<NormalUserModel> findByPhoneNumber(String phoneNumber);

}
