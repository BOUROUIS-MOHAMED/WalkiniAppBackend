package com.walkini.repositories;

import com.walkini.models.NormalUserModel;
import com.walkini.models.PartnerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PartnerRepository extends JpaRepository<PartnerModel,Integer> {
    List<PartnerModel> findByEmailOrPhoneNumber(String Email, String phoneNumber);
    List<PartnerModel> findByEmail(String Email);
    List<PartnerModel> findByPhoneNumber(String phoneNumber);
}
